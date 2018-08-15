package br.gov.cgsus.gerenciamentocontrato.dao.test;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.gov.cgsus.gerenciamentocontrato.dao.TamanhoFuncionalDao;
import br.gov.cgsus.gerenciamentocontrato.domain.Sistema;
import br.gov.cgsus.gerenciamentocontrato.domain.TamanhoFuncional;

public class TamanhoFuncionalDaoTest {
	
	private TamanhoFuncionalDao tamanhoFuncionalDao = new TamanhoFuncionalDao(true);
	
	
	
	@Test
	public void inserir() {
		
		TamanhoFuncional tamanhoFuncional = new TamanhoFuncional();
		tamanhoFuncional.setSistema(new Sistema(2));
		tamanhoFuncional.setDataVigencia(new Date());
		tamanhoFuncional.setTamanhoPontoFuncao(150);

		try{
			tamanhoFuncionalDao.inserir(tamanhoFuncional);
			Assert.assertTrue(true);
		}catch(Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void selectAll() {
		
		try{
			List<TamanhoFuncional> list= tamanhoFuncionalDao.selectAll();
			Assert.assertTrue(!list.isEmpty());
		}catch(Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void selectPorIdSistema() {
		TamanhoFuncional tamanhoFuncional = new TamanhoFuncional();
		tamanhoFuncional.setSistema(new Sistema(2));
		
		try{
			List<TamanhoFuncional> list= tamanhoFuncionalDao.selectPorIdSistema(tamanhoFuncional);
			Assert.assertTrue(!list.isEmpty());
		}catch(Exception e) {
			Assert.assertTrue(false);
		}
	}
	

}
