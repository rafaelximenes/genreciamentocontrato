package br.gov.cgsus.gerenciamentocontrato.dao.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.gov.cgsus.gerenciamentocontrato.dao.TipoOSDao;
import br.gov.cgsus.gerenciamentocontrato.domain.Metrica;
import br.gov.cgsus.gerenciamentocontrato.domain.TipoOS;

public class TipoOSDaoTest {
	
	private TipoOSDao tipoOSDao = new TipoOSDao(true);
	
	
	
	@Test
	public void inserir() {
		
		TipoOS tipoOS = new TipoOS();
		Metrica metrica = new Metrica();
		metrica.setId(3);
		tipoOS.setMetrica(metrica);
		tipoOS.setFlagSustentacao(true);
		tipoOS.setNome("Teste");
		
		try{
			tipoOSDao.inserir(tipoOS);
			Assert.assertTrue(true);
		}catch(Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void selectAll() {
		
		try{
			List<TipoOS> list= tipoOSDao.selectAll();
			Assert.assertTrue(!list.isEmpty());
		}catch(Exception e) {
			Assert.assertTrue(false);
		}
	}

}
