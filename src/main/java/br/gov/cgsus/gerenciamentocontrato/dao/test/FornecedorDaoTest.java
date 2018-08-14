package br.gov.cgsus.gerenciamentocontrato.dao.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.gov.cgsus.gerenciamentocontrato.dao.FornecedorDao;
import br.gov.cgsus.gerenciamentocontrato.domain.Fornecedor;

public class FornecedorDaoTest {
	
	private FornecedorDao fornecedorDao = new FornecedorDao(true);
	
	
	
	@Test
	public void inserir() {
		
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setCnpj("12345678910123");
		fornecedor.setNomeFantasia("Teste nome fantasia");
		fornecedor.setRazaoSocial("Teste nome razão social");

		try{
			fornecedorDao.inserir(fornecedor);
			Assert.assertTrue(true);
		}catch(Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void selectAll() {
		
		try{
			List<Fornecedor> list= fornecedorDao.selectAll();
			Assert.assertTrue(!list.isEmpty());
		}catch(Exception e) {
			Assert.assertTrue(false);
		}
	}

}
