package br.gov.cgsus.gerenciamentocontrato.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.cgsus.gerenciamentocontrato.domain.Contrato;
import br.gov.cgsus.gerenciamentocontrato.domain.OrdemServico;
import br.gov.cgsus.gerenciamentocontrato.domain.TipoOS;
import br.gov.cgsus.gerenciamentocontrato.domain.Usuario;
import br.gov.cgsus.gerenciamentocontrato.report.Database;
import br.gov.cgsus.gerenciamentocontrato.report.AbstractReportBean.ExportOption;
import br.gov.cgsus.gerenciamentocontrato.service.ContratoBusiness;
import br.gov.cgsus.gerenciamentocontrato.service.OrdemServicoBusiness;
import br.gov.cgsus.gerenciamentocontrato.service.TipoOSBusiness;
import br.gov.cgsus.gerenciamentocontrato.service.VigenciaContratoBusiness;
import br.gov.cgsus.gerenciamentocontrato.session.UsuarioSessao;
import br.gov.cgsus.gerenciamentocontrato.utils.ReportConfigUtil;
import br.gov.cgsus.gerenciamentocontrato.utils.Util;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.j2ee.servlets.BaseHttpServlet;

@ManagedBean
@ViewScoped
public class OrdemServicoController extends Controller {

	private OrdemServico ordemServico;
	
	private OrdemServico ordemServicoSelected;
	
	private List<OrdemServico> listaOrdemServicoes;
	
	private List<OrdemServico> listaFiltrada;
	
	private List<Contrato> listaContratos;
	
	private List<TipoOS> listaTipoOS; 
	
	private OrdemServicoBusiness ordemServicoBusiness;
	
	private ExportOption exportOption;
	
	@ManagedProperty(value="#{usuarioSessao}")
	private UsuarioSessao usuarioSessao;
	
	public void setUsuarioSessao(UsuarioSessao usuarioSessao) { 
		this.usuarioSessao = usuarioSessao;
	}
	
	@PostConstruct
	public void inicializar() {
		Usuario usuario = usuarioSessao.getUsuario();
		if(!Util.temPerfilParaAcessar(usuario, usuarioSessao.getContrato(), 3)) {
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("/public/erro_permissao.jsf");
			} catch (IOException e) {
				jsfError(e.getMessage());
			}
		}
		ordemServicoBusiness = new OrdemServicoBusiness();
		ordemServico = new OrdemServico();
		ordemServico.setContrato(usuarioSessao.getContrato());
		pesquisar();
		pesquisarListaCombos();
		setExportOption(ExportOption.PDF);
	}
	
	public void criaRelatorio()  throws JRException, IOException  {
		Map<String, Object> reportParameters = new HashMap<String, Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        reportParameters.put("contrato", ordemServicoSelected.getContrato().getNumero()+"/"+ordemServicoSelected.getContrato().getAno()); //consertar ano
        reportParameters.put("numeroos", ordemServicoSelected.getNumero()+"/"+ordemServicoSelected.getAno());
        reportParameters.put("periodoexecucao", sdf.format(ordemServicoSelected.getDataInicioPeriodo()) +" a " + sdf.format(ordemServicoSelected.getDataFimPeriodo()));
        reportParameters.put("requisitante", "Rúbia Piassi Dalvi Meriguete");
        reportParameters.put("descricaoservico", "Execução de serviços de Sustentação de software, conforme disponibilidade e nível de criticidade definidos nesta Ordem de Serviço");
        reportParameters.put("nomefantasia", ordemServicoSelected.getContrato().getFornecedor().getNomeFantasia());
        reportParameters.put("dataemissao", sdf.format(ordemServicoSelected.getDataAbertura()));
        reportParameters.put("tiposervico", "Sustentação de Software");
        reportParameters.put("valorpf", "13.85");
        reportParameters.put("qtdpfsautorizada", "R$ 6.1827,14");
        reportParameters.put("valortotalos", "R$ 856.305,83");
		
		
		
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

		ServletContext context = (ServletContext) externalContext.getContext();
		HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
		HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();

		ReportConfigUtil.compileReport(context, "report/", "os");

		File reportFile = new File(
				ReportConfigUtil.getJasperFilePath(context, "report/", "os.jasper"));

		///////////////////
		Connection conn = null;
		try {
			conn = Database.getConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		/////////////////////

		JasperPrint jasperPrint = ReportConfigUtil.fillReport(reportFile, reportParameters, conn);

		request.getSession().setAttribute(BaseHttpServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);
		response.sendRedirect(request.getContextPath() + "/servlets/report/" + getExportOption());

		FacesContext.getCurrentInstance().responseComplete();
	}
	
	public void buscaNovoNumeroOS() {
		if(ordemServico.getContrato()!=null && ordemServico.getTipoOS()!=null && ordemServico.getAno()!=null) { 
			OrdemServicoBusiness ordemServicoBusiness = new OrdemServicoBusiness();
			try {
				ordemServico.setNumero(ordemServicoBusiness.selectUltimoNumeroPorAno(ordemServico));
			} catch (Exception e) {
				jsfError(e.getMessage());
				ordemServico.setNumero(1); 
			}
		}
		
	}
	
	public void calculaQtdDias() {
		if(ordemServico.getDataInicioPeriodo()!=null && ordemServico.getDataFimPeriodo()!=null) {
			ordemServico.setQtdDias(Util.diferencaDeDiasEntreDatas(ordemServico.getDataInicioPeriodo(), ordemServico.getDataFimPeriodo()));
		}
	}
	
	private void pesquisarListaCombos() {
		ContratoBusiness contratoBusiness = new ContratoBusiness();
		try {
			listaContratos = contratoBusiness.selectAll();
		} catch (Exception e) {
			jsfError(e.getMessage());
		}
		TipoOSBusiness tipoOSBusiness = new TipoOSBusiness();
		try {
			listaTipoOS = tipoOSBusiness.selectAll();
		} catch (Exception e) {
			jsfError(e.getMessage());
		}
		
	}

	public void cadastrar() {
		try {
			buscaVigenciaPelaDataAbertura();
			ordemServicoBusiness.inserir(ordemServico);
			jsfInfo("Ordem de Serviço cadastrada com sucesso!");
			pesquisar();
		} catch (Exception e) {
			jsfError(e.getMessage());
		}
		limparDados();
		
	}
	
	private void buscaVigenciaPelaDataAbertura() {
		VigenciaContratoBusiness vigenciaContratoBusiness = new VigenciaContratoBusiness();
		try {
			ordemServico.setVigenciaContrato(vigenciaContratoBusiness.selectVigenciaValidaPorContrato(ordemServico));
		} catch (Exception e) {
			jsfError(e.getMessage());
			ordemServico.setVigenciaContrato(null);
		}
		
	}

	public void pesquisar() {
		try {
			listaOrdemServicoes = ordemServicoBusiness.selectAll();
		} catch (Exception e) {
			jsfError(e.getMessage());
		}
		
	}
	
	public boolean isPodeCancelarOS() {
		return true;
	}
	
	public String chamaPaginaVincularSistemas() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		sessionMap.put("os_user", ordemServicoSelected);
		return "/poseidon/sistema_os.jsf?faces-redirect=true";
	}
	
	
	public void limparDados() {
		inicializar();
	}

	public OrdemServico getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(OrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}

	public List<OrdemServico> getListaOrdemServicoes() {
		return listaOrdemServicoes;
	}

	public void setListaOrdemServicoes(List<OrdemServico> listaOrdemServicoes) {
		this.listaOrdemServicoes = listaOrdemServicoes;
	}

	public List<OrdemServico> getListaFiltrada() {
		return listaFiltrada;
	}

	public void setListaFiltrada(List<OrdemServico> listaFiltrada) {
		this.listaFiltrada = listaFiltrada;
	}

	public List<Contrato> getListaContratos() {
		return listaContratos;
	}

	public void setListaContratos(List<Contrato> listaContratos) {
		this.listaContratos = listaContratos;
	}

	public List<TipoOS> getListaTipoOS() {
		return listaTipoOS;
	}

	public void setListaTipoOS(List<TipoOS> listaTipoOS) {
		this.listaTipoOS = listaTipoOS;
	}

	public OrdemServico getOrdemServicoSelected() {
		return ordemServicoSelected;
	}

	public void setOrdemServicoSelected(OrdemServico ordemServicoSelected) {
		if(ordemServicoSelected!=null) {
			this.ordemServicoSelected = ordemServicoSelected;
		}
	}

	public ExportOption getExportOption() {
		return exportOption;
	}

	public void setExportOption(ExportOption exportOption) {
		this.exportOption = exportOption;
	}

	
}
