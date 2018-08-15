package br.gov.cgsus.gerenciamentocontrato.service;

import java.util.List;

import br.gov.cgsus.gerenciamentocontrato.dao.TipoDisponibilidadeDao;
import br.gov.cgsus.gerenciamentocontrato.domain.TipoDisponibilidade;

public class TipoDisponibilidadeBusiness {
	
	private TipoDisponibilidadeDao tipoDisponibilidadeDao = new TipoDisponibilidadeDao();
	
	public void inserir(TipoDisponibilidade tipoDisponibilidade) throws Exception {
		if(tipoDisponibilidade==null) {
			throw new Exception("Tipo de Disponibilidade nulo.");
		}
		if(tipoDisponibilidade.getNome()==null || "".equalsIgnoreCase(tipoDisponibilidade.getNome())) {
			throw new Exception("Nome é um campo obrigatório.");
		}
		if(tipoDisponibilidade.getDescricao()==null || "".equalsIgnoreCase(tipoDisponibilidade.getDescricao())) {
			throw new Exception("Descrição é um campo obrigatório.");
		}
		if(tipoDisponibilidade.getFatorHoras()==null) {
			throw new Exception("Fator Horas é um campo obrigatório.");
		}
		try {
			tipoDisponibilidadeDao.inserir(tipoDisponibilidade);
		}catch(Exception e) {
			throw new Exception("Erro ao inserir no banco de dados.");
		}
	}
	
	public List<TipoDisponibilidade> selectAll() throws Exception {
		try {
			return tipoDisponibilidadeDao.selectAll();
		}catch(Exception e) {
			throw new Exception("Erro ao buscar no banco de dados.");
		}
	}

}
