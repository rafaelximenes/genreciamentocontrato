package br.gov.cgsus.gerenciamentocontrato.dao.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.gov.cgsus.gerenciamentocontrato.dao.MetricaDao;
import br.gov.cgsus.gerenciamentocontrato.domain.Metrica;

public class MetricaDaoTest {
	
	private MetricaDao metricaDao = new MetricaDao(true);
	
	
	
	@Test
	public void inserir() {
		
		Metrica metrica = new Metrica();
		metrica.setNome("Ponto de função");

		try{
			metricaDao.inserir(metrica);
			Assert.assertTrue(true);
		}catch(Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void selectAll() {
		
		try{
			List<Metrica> list= metricaDao.selectAll();
			Assert.assertTrue(!list.isEmpty());
		}catch(Exception e) {
			Assert.assertTrue(false);
		}
	}

}
