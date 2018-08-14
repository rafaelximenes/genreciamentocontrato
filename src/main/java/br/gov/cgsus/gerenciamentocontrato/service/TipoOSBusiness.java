package br.gov.cgsus.gerenciamentocontrato.service;

import java.util.List;

import br.gov.cgsus.gerenciamentocontrato.dao.TipoOSDao;
import br.gov.cgsus.gerenciamentocontrato.domain.TipoOS;

public class TipoOSBusiness {
	
	private TipoOSDao tipoOSDao = new TipoOSDao();
	
	public void inserir(TipoOS tipoOS) throws Exception {
		if(tipoOS==null) {
			throw new Exception("TipoOS nulo.");
		}
		if(tipoOS.getMetrica() == null) {
			throw new Exception("Métrica é um campo obrigatório.");
		}
		if(tipoOS.getMetrica().getId() == null) {
			throw new Exception("Métrica é um campo obrigatório.");
		}
		if(tipoOS.getNome()==null || "".equalsIgnoreCase(tipoOS.getNome())) {
			throw new Exception("Nome é um campo obrigatório.");
		}
		try {
			tipoOSDao.inserir(tipoOS);
		}catch(Exception e) {
			throw new Exception("Erro ao inserir no banco de dados.");
		}
	}
	
	public List<TipoOS> selectAll() throws Exception {
		try {
			return tipoOSDao.selectAll();
		}catch(Exception e) {
			throw new Exception("Erro ao buscar no banco de dados.");
		}
	}

}
