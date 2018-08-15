package br.gov.cgsus.gerenciamentocontrato.service;

import java.util.List;

import br.gov.cgsus.gerenciamentocontrato.dao.TamanhoFuncionalDao;
import br.gov.cgsus.gerenciamentocontrato.domain.TamanhoFuncional;

public class TamanhoFuncionalBusiness {
	
	private TamanhoFuncionalDao tamanhoFuncionalDao = new TamanhoFuncionalDao();
	
	public void inserir(TamanhoFuncional tamanhoFuncional) throws Exception {
		if(tamanhoFuncional==null) {
			throw new Exception("TamanhoFuncional nulo.");
		}
		if(tamanhoFuncional.getDataVigencia()==null) {
			throw new Exception("Data vigência é um campo obrigatório.");
		}
		if(tamanhoFuncional.getSistema()==null) {
			throw new Exception("Sistema é um campo obrigatório.");
		}
		if(tamanhoFuncional.getSistema().getId()==null) {
			throw new Exception("Sistema é um campo obrigatório.");
		}
		if(tamanhoFuncional.getTamanhoPontoFuncao()==null) {
			throw new Exception("Tamanho funcional é um campo obrigatório.");
		}
		try {
			tamanhoFuncionalDao.inserir(tamanhoFuncional);
		}catch(Exception e) {
			throw new Exception("Erro ao inserir no banco de dados.");
		}
	}
	
	public List<TamanhoFuncional> selectAll() throws Exception {
		try {
			return tamanhoFuncionalDao.selectAll();
		}catch(Exception e) {
			throw new Exception("Erro ao buscar no banco de dados.");
		}
	}
	
	public List<TamanhoFuncional> selectPorIdSistema(TamanhoFuncional tamanhoFuncional) throws Exception {
		if(tamanhoFuncional==null) {
			throw new Exception("TamanhoFuncional nulo.");
		}
		if(tamanhoFuncional.getSistema()==null) {
			throw new Exception("Sistema é um campo obrigatório.");
		}
		if(tamanhoFuncional.getSistema().getId()==null) {
			throw new Exception("Sistema é um campo obrigatório.");
		}
		try {
			return tamanhoFuncionalDao.selectPorIdSistema(tamanhoFuncional);
		}catch(Exception e) {
			throw new Exception("Erro ao buscar no banco de dados.");
		}
	}

}
