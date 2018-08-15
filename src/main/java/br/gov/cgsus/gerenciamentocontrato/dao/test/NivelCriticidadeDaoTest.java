package br.gov.cgsus.gerenciamentocontrato.dao.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.gov.cgsus.gerenciamentocontrato.dao.NivelCriticidadeDao;
import br.gov.cgsus.gerenciamentocontrato.domain.NivelCriticidade;

public class NivelCriticidadeDaoTest {
	
	private NivelCriticidadeDao nivelCriticidadeDao = new NivelCriticidadeDao(true);
	
	
	
	@Test
	public void selectAll() {
		
		try{
			List<NivelCriticidade> list= nivelCriticidadeDao.selectAll();
			Assert.assertTrue(!list.isEmpty());
		}catch(Exception e) {
			Assert.assertTrue(false);
		}
	}

}
