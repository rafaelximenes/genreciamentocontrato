package br.gov.cgsus.gerenciamentocontrato.dao.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.gov.cgsus.gerenciamentocontrato.dao.SistemaDao;
import br.gov.cgsus.gerenciamentocontrato.domain.Sistema;

public class SistemaDaoTest {
	
	private SistemaDao sistemaDao = new SistemaDao(true);
	
	
	
	@Test
	public void inserir() {
		
		Sistema sistema = new Sistema();
		sistema.setNome("Sistema Teste");
		sistema.setAtivo(true);

		try{
			sistemaDao.inserir(sistema);
			Assert.assertTrue(true);
		}catch(Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void selectAll() {
		
		try{
			List<Sistema> list= sistemaDao.selectAll();
			Assert.assertTrue(!list.isEmpty());
		}catch(Exception e) {
			Assert.assertTrue(false);
		}
	}

}
