package br.gov.cgsus.gerenciamentocontrato.service;

import java.util.List;

import br.gov.cgsus.gerenciamentocontrato.dao.MetricaVigenciaDao;
import br.gov.cgsus.gerenciamentocontrato.domain.MetricaVigencia;

public class MetricaVigenciaBusiness {
	
	private MetricaVigenciaDao metricaVigenciaDao = new MetricaVigenciaDao();
	
	public void inserir(MetricaVigencia metricaVigencia) throws Exception {
		if(metricaVigencia==null) {
			throw new Exception("Metrica Vigência nulo.");
		}
		if(metricaVigencia.getMetrica()==null) {
			throw new Exception("Métrica é um campo obrigatório.");
		}
		if(metricaVigencia.getMetrica().getId()==null) {
			throw new Exception("Métrica é um campo obrigatório.");
		}
		if(metricaVigencia.getVigenciaContrato()==null) {
			throw new Exception("Vigência do contrato é um campo obrigatório.");
		}
		if(metricaVigencia.getVigenciaContrato().getId()==null) {
			throw new Exception("Vigência do contrato é um campo obrigatório.");
		}
		if(metricaVigencia.getQtdMetrica()==null) {
			throw new Exception("Quantidade é um campo obrigatório.");
		}
		if(metricaVigencia.getValorMetrica()==null) {
			throw new Exception("Valor é um campo obrigatório.");
		}
		try {
			metricaVigenciaDao.inserir(metricaVigencia);
		}catch(Exception e) {
			throw new Exception("Erro ao inserir no banco de dados.");
		}
	}
	
	public List<MetricaVigencia> selectAll() throws Exception {
		try {
			return metricaVigenciaDao.selectAll();
		}catch(Exception e) {
			throw new Exception("Erro ao buscar no banco de dados.");
		}
	}
	
	public Double selectMetricaPorVigencia(MetricaVigencia metricaVigencia) throws Exception {
		if(metricaVigencia==null) {
			throw new Exception("Metrica Vigência nulo.");
		}
		if(metricaVigencia.getVigenciaContrato()==null) {
			throw new Exception("Vigência do contrato é um campo obrigatório.");
		}
		if(metricaVigencia.getVigenciaContrato().getId()==null) {
			throw new Exception("Vigência do contrato é um campo obrigatório.");
		}
		try {
			return metricaVigenciaDao.selectMetricaPorVigencia(metricaVigencia);
		}catch(Exception e) {
			throw new Exception("Erro ao buscar no banco de dados.");
		}
	}

}
