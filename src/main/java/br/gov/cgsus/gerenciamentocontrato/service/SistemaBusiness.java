package br.gov.cgsus.gerenciamentocontrato.service;

import java.util.List;

import br.gov.cgsus.gerenciamentocontrato.dao.SistemaDao;
import br.gov.cgsus.gerenciamentocontrato.domain.Sistema;

public class SistemaBusiness {
	
	private SistemaDao sistemaDao = new SistemaDao();
	
	public void inserir(Sistema sistema) throws Exception {
		if(sistema==null) {
			throw new Exception("Sistema nulo.");
		}
		if(sistema.getNome()==null || "".equalsIgnoreCase(sistema.getNome())) {
			throw new Exception("Nome é um campo obrigatório.");
		}
		try {
			sistema.setAtivo(true);
			sistemaDao.inserir(sistema);
		}catch(Exception e) {
			throw new Exception("Erro ao inserir no banco de dados.");
		}
	}
	
	public List<Sistema> selectAll() throws Exception {
		try {
			return sistemaDao.selectAll();
		}catch(Exception e) {
			throw new Exception("Erro ao buscar no banco de dados.");
		}
	}

}
