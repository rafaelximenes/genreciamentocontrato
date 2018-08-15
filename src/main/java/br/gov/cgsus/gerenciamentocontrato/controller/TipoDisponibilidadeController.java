package br.gov.cgsus.gerenciamentocontrato.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.gov.cgsus.gerenciamentocontrato.domain.TipoDisponibilidade;
import br.gov.cgsus.gerenciamentocontrato.enums.FatorDiasEnum;
import br.gov.cgsus.gerenciamentocontrato.service.TipoDisponibilidadeBusiness;

@ManagedBean
@ViewScoped
public class TipoDisponibilidadeController extends Controller {

	private TipoDisponibilidade tipoDisponibilidade;
	
	private List<TipoDisponibilidade> listaTipoDisponibilidadees;
	
	private List<TipoDisponibilidade> listaFiltrada;
	
	private TipoDisponibilidadeBusiness tipoDisponibilidadeBusiness;
	
	private FatorDiasEnum fatorDiasEnum;
	
	private String descricaFatorDias;
	
	@PostConstruct
	public void inicializar() {
		tipoDisponibilidadeBusiness = new TipoDisponibilidadeBusiness();
		tipoDisponibilidade = new TipoDisponibilidade();
		pesquisar();
	}
	
	public void cadastrar() {
		try {
			atribuiFatorDiaSeleciona();
			tipoDisponibilidadeBusiness.inserir(tipoDisponibilidade);
			jsfInfo("TipoDisponibilidade cadastrado com sucesso!");
			pesquisar();
		} catch (Exception e) {
			jsfError(e.getMessage());
		}
		limparDados();
		
	}
	
	private void atribuiFatorDiaSeleciona() {
		for(FatorDiasEnum f: FatorDiasEnum.values()) {
			if(f.getDescricao().equalsIgnoreCase(descricaFatorDias)) {
				tipoDisponibilidade.setFatorHoras(f.getCod());
				break;
			}
		}
		
		
	}

	public void pesquisar() {
		try {
			listaTipoDisponibilidadees = tipoDisponibilidadeBusiness.selectAll();
			atribuiDescricaoFatorDias();
		} catch (Exception e) {
			jsfError(e.getMessage());
		}
		
	}
	
	private void atribuiDescricaoFatorDias() {
		for(TipoDisponibilidade t: listaTipoDisponibilidadees) {
			for(FatorDiasEnum f: FatorDiasEnum.values()) {
				if(f.getCod().intValue()==t.getFatorHoras().intValue()) {
					t.setDescricaoFatorHoras(f.getDescricao());
					break;
				}
			}
		}
		
	}

	public void limparDados() {
		inicializar();
	}
	
	public List<String> getFatorDias(){
		List<String> descricaoEnum = new ArrayList<String>();
		for(FatorDiasEnum f: FatorDiasEnum.values()) {
			descricaoEnum.add(f.getDescricao());
		}
        return descricaoEnum;
    }

	public TipoDisponibilidade getTipoDisponibilidade() {
		return tipoDisponibilidade;
	}

	public void setTipoDisponibilidade(TipoDisponibilidade tipoDisponibilidade) {
		this.tipoDisponibilidade = tipoDisponibilidade;
	}

	public List<TipoDisponibilidade> getListaTipoDisponibilidadees() {
		return listaTipoDisponibilidadees;
	}

	public void setListaTipoDisponibilidadees(List<TipoDisponibilidade> listaTipoDisponibilidadees) {
		this.listaTipoDisponibilidadees = listaTipoDisponibilidadees;
	}

	public List<TipoDisponibilidade> getListaFiltrada() {
		return listaFiltrada;
	}

	public void setListaFiltrada(List<TipoDisponibilidade> listaFiltrada) {
		this.listaFiltrada = listaFiltrada;
	}

	public FatorDiasEnum getFatorDiasEnum() {
		return fatorDiasEnum;
	}

	public void setFatorDiasEnum(FatorDiasEnum fatorDiasEnum) {
		this.fatorDiasEnum = fatorDiasEnum;
	}

	public String getDescricaFatorDias() {
		return descricaFatorDias;
	}

	public void setDescricaFatorDias(String descricaFatorDias) {
		this.descricaFatorDias = descricaFatorDias;
	}

	
}
