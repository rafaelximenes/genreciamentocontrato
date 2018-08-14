package br.gov.cgsus.gerenciamentocontrato.service;

import java.util.List;

import br.gov.cgsus.gerenciamentocontrato.dao.MetricaDao;
import br.gov.cgsus.gerenciamentocontrato.domain.Metrica;

public class MetricaBusiness {
	
	private MetricaDao metricaDao = new MetricaDao();
	
	public void inserir(Metrica metrica) throws Exception {
		if(metrica==null) {
			throw new Exception("Metrica nulo.");
		}
		if(metrica.getNome()==null || "".equalsIgnoreCase(metrica.getNome())) {
			throw new Exception("Nome é um campo obrigatório.");
		}
		try {
			metricaDao.inserir(metrica);
		}catch(Exception e) {
			throw new Exception("Erro ao inserir no banco de dados.");
		}
	}
	
	public List<Metrica> selectAll() throws Exception {
		try {
			return metricaDao.selectAll();
		}catch(Exception e) {
			throw new Exception("Erro ao buscar no banco de dados.");
		}
	}

}
