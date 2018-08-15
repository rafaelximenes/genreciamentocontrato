package br.gov.cgsus.gerenciamentocontrato.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.gov.cgsus.gerenciamentocontrato.domain.MetricaVigencia;
import br.gov.cgsus.gerenciamentocontrato.domain.NivelCriticidade;
import br.gov.cgsus.gerenciamentocontrato.domain.OrdemServico;
import br.gov.cgsus.gerenciamentocontrato.domain.Sistema;
import br.gov.cgsus.gerenciamentocontrato.domain.SistemaOS;
import br.gov.cgsus.gerenciamentocontrato.domain.TamanhoFuncional;
import br.gov.cgsus.gerenciamentocontrato.domain.TipoDisponibilidade;
import br.gov.cgsus.gerenciamentocontrato.service.MetricaVigenciaBusiness;
import br.gov.cgsus.gerenciamentocontrato.service.NivelCriticidadeBusiness;
import br.gov.cgsus.gerenciamentocontrato.service.OrdemServicoBusiness;
import br.gov.cgsus.gerenciamentocontrato.service.SistemaBusiness;
import br.gov.cgsus.gerenciamentocontrato.service.TamanhoFuncionalBusiness;
import br.gov.cgsus.gerenciamentocontrato.service.TipoDisponibilidadeBusiness;

@ManagedBean
@ViewScoped
public class SistemasOSController extends Controller {

	
	
	private OrdemServico ordemServico;
	
	private List<OrdemServico> listaOrdemServico;
	
	private List<Sistema> listaSistemas;
	
	private TamanhoFuncional tamanhoFuncional;
	
	private List<TipoDisponibilidade> listaTiposDisponibilidades;
	
	private List<NivelCriticidade> listaNiveisCriticas;
	
	private SistemaOS sistemaOS;
	
	private Double valorServico;
	
	@PostConstruct
	public void inicializar() {
		sistemaOS = new SistemaOS();
		sistemaOS.setNivelCriticidade(new NivelCriticidade());
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		ordemServico = (OrdemServico) sessionMap.get("os_user");
		pesquisar();
		populaCombos();
		buscaValorUnitarioPF();
		
	}
	
	private void buscaValorUnitarioPF() {
		MetricaVigenciaBusiness metricaVigenciaBusiness = new MetricaVigenciaBusiness();
		MetricaVigencia metricaVigencia = new MetricaVigencia();
		metricaVigencia.setVigenciaContrato(ordemServico.getVigenciaContrato());
		try {
			sistemaOS.setValorUnitarioPFS(metricaVigenciaBusiness.selectMetricaPorVigencia(metricaVigencia));
			
		} catch (Exception e) {
			jsfError(e.getMessage());
		}
		
	}
	
	public void calculaQuantPFS() {
		if(sistemaOS.getQtdhoraSustentada()!=null && sistemaOS.getPercentualDisponibilidade()!=null) {
			Double a = sistemaOS.getQtdhoraSustentada()/720 * sistemaOS.getPercentualDisponibilidade()/99.5*10000;
			sistemaOS.setFatorPFS(a);
			calculaQtPFS();
			calculaValorServico();
		}
		
	}

	private void calculaQtPFS() {
		if(sistemaOS.getTamanhoPF()!=null && sistemaOS.getFatorPFS()!=null && sistemaOS.getNivelCriticidade()!=null) {
			Double a = sistemaOS.getTamanhoPF()*sistemaOS.getFatorPFS()*sistemaOS.getNivelCriticidade().getFatorCriticidade();
			sistemaOS.setQtdPFS(a);
		}
		
	}

	private void calculaValorServico() {
		if(sistemaOS.getValorUnitarioPFS()!=null) {
			valorServico = sistemaOS.getQtdPFS() * sistemaOS.getValorUnitarioPFS();
		}
		
	}

	public void buscaTamanhoFuncional() {
		TamanhoFuncionalBusiness tamanhoFuncionalBusiness = new TamanhoFuncionalBusiness();
		TamanhoFuncional tamanhoFuncional = new TamanhoFuncional();
		tamanhoFuncional.setSistema(sistemaOS.getSistema());
		try {
			List<TamanhoFuncional> listaTamanhoFuncional = tamanhoFuncionalBusiness.selectPorIdSistema(tamanhoFuncional);
			for(TamanhoFuncional t: listaTamanhoFuncional) {
				sistemaOS.setTamanhoPF(t.getTamanhoPontoFuncao());
			}
		} catch (Exception e) {
			jsfError(e.getMessage());
		}
	}
	
	public void calculaQuantHoraSustentacao() {
		if(sistemaOS.getTipoDisponibilidade().isDiasCorridos()) {
			Integer a = ordemServico.getQtdDias()*sistemaOS.getTipoDisponibilidade().getFatorHoras();
			sistemaOS.setQtdhoraSustentada(new Double(a));
		}else {
			Integer a = ordemServico.getQtdDiasUteis()*sistemaOS.getTipoDisponibilidade().getFatorHoras();
			sistemaOS.setQtdhoraSustentada(new Double(a));
		}
	}
	
	private void populaCombos() {
		populaListaSistemas();
		populaListaTiposDisponibilidades();
		populaListaNiveisCriticas();
	}

	public void populaListaSistemas() {
		SistemaBusiness business = new SistemaBusiness();
		try {
			listaSistemas = business.selectAll();
		} catch (Exception e) {
			jsfError(e.getMessage());
		}
	}
	
	public void populaListaNiveisCriticas() {
		NivelCriticidadeBusiness business = new NivelCriticidadeBusiness();
		try {
			listaNiveisCriticas = business.selectAll();
		} catch (Exception e) {
			jsfError(e.getMessage());
		}
	}
	
	public void populaListaTiposDisponibilidades() {
		TipoDisponibilidadeBusiness business = new TipoDisponibilidadeBusiness();
		try {
			listaTiposDisponibilidades = business.selectAll();
		} catch (Exception e) {
			jsfError(e.getMessage());
		}
	}
	
	public void cadastrar() {
		/*try {
			fornecedorBusiness.inserir(fornecedor);
			jsfInfo("Fornecedor cadastrado com sucesso!");
			pesquisar();
		} catch (Exception e) {
			jsfError(e.getMessage());
		}
		limparDados();*/
		
	}
	
	public void pesquisar() {
		OrdemServicoBusiness ordemServicoBusiness = new OrdemServicoBusiness();
		try {
			listaOrdemServico = ordemServicoBusiness.selectAll();
		} catch (Exception e) {
			jsfError(e.getMessage());
		}
		
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

	public List<OrdemServico> getListaOrdemServico() {
		return listaOrdemServico;
	}

	public void setListaOrdemServico(List<OrdemServico> listaOrdemServico) {
		this.listaOrdemServico = listaOrdemServico;
	}

	public List<Sistema> getListaSistemas() {
		return listaSistemas;
	}

	public void setListaSistemas(List<Sistema> listaSistemas) {
		this.listaSistemas = listaSistemas;
	}

	public TamanhoFuncional getTamanhoFuncional() {
		return tamanhoFuncional;
	}

	public void setTamanhoFuncional(TamanhoFuncional tamanhoFuncional) {
		this.tamanhoFuncional = tamanhoFuncional;
	}

	public List<TipoDisponibilidade> getListaTiposDisponibilidades() {
		return listaTiposDisponibilidades;
	}

	public void setListaTiposDisponibilidades(List<TipoDisponibilidade> listaTiposDisponibilidades) {
		this.listaTiposDisponibilidades = listaTiposDisponibilidades;
	}

	public List<NivelCriticidade> getListaNiveisCriticas() {
		return listaNiveisCriticas;
	}

	public void setListaNiveisCriticas(List<NivelCriticidade> listaNiveisCriticas) {
		this.listaNiveisCriticas = listaNiveisCriticas;
	}

	public SistemaOS getSistemaOS() {
		return sistemaOS;
	}

	public void setSistemaOS(SistemaOS sistemaOS) {
		this.sistemaOS = sistemaOS;
	}

	public Double getValorServico() {
		return valorServico;
	}

	public void setValorServico(Double valorServico) {
		this.valorServico = valorServico;
	}


	
}
