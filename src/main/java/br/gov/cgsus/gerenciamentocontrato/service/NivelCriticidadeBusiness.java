package br.gov.cgsus.gerenciamentocontrato.service;

import java.util.List;

import br.gov.cgsus.gerenciamentocontrato.dao.NivelCriticidadeDao;
import br.gov.cgsus.gerenciamentocontrato.domain.NivelCriticidade;

public class NivelCriticidadeBusiness {
	
	private NivelCriticidadeDao nivelCriticidadeDao = new NivelCriticidadeDao();
	
	public List<NivelCriticidade> selectAll() throws Exception {
		try {
			return nivelCriticidadeDao.selectAll();
		}catch(Exception e) {
			throw new Exception("Erro ao buscar no banco de dados.");
		}
	}

}
