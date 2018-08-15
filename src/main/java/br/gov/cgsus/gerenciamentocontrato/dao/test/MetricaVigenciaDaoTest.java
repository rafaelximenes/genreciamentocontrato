package br.gov.cgsus.gerenciamentocontrato.dao.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.gov.cgsus.gerenciamentocontrato.dao.MetricaVigenciaDao;
import br.gov.cgsus.gerenciamentocontrato.domain.Metrica;
import br.gov.cgsus.gerenciamentocontrato.domain.MetricaVigencia;
import br.gov.cgsus.gerenciamentocontrato.domain.VigenciaContrato;

public class MetricaVigenciaDaoTest {
	
	private MetricaVigenciaDao metricaVigenciaDao = new MetricaVigenciaDao(true);
	
	
	
	@Test
	public void inserir() {
		
		MetricaVigencia metricaVigencia = new MetricaVigencia();
		Metrica metrica = new Metrica();
		metrica.setId(2);
		VigenciaContrato vigenciaContrato = new VigenciaContrato();
		vigenciaContrato.setId(5);
		metricaVigencia.setMetrica(metrica);
		metricaVigencia.setVigenciaContrato(vigenciaContrato);
		metricaVigencia.setQtdMetrica(100);
		metricaVigencia.setValorMetrica(13.41D);
		try{
			metricaVigenciaDao.inserir(metricaVigencia);
			Assert.assertTrue(true);
		}catch(Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void selectAll() {
		
		try{
			List<MetricaVigencia> list= metricaVigenciaDao.selectAll();
			Assert.assertTrue(!list.isEmpty());
		}catch(Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void selectMetricaPorVigencia() {
		MetricaVigencia metricaVigencia = new MetricaVigencia();
		VigenciaContrato vigenciaContrato = new VigenciaContrato();
		vigenciaContrato.setId(6);
		metricaVigencia.setVigenciaContrato(vigenciaContrato);
		try{
			Double list= metricaVigenciaDao.selectMetricaPorVigencia(metricaVigencia);
			Assert.assertTrue(list!=null);
		}catch(Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	

}
