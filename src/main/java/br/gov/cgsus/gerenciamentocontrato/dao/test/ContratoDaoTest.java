package br.gov.cgsus.gerenciamentocontrato.dao.test;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.gov.cgsus.gerenciamentocontrato.dao.ContratoDao;
import br.gov.cgsus.gerenciamentocontrato.domain.Contrato;
import br.gov.cgsus.gerenciamentocontrato.domain.Fornecedor;
import br.gov.cgsus.gerenciamentocontrato.domain.VigenciaContrato;

public class ContratoDaoTest {
	
	private ContratoDao contratoDao = new ContratoDao(true);
	
	
	
	@Test
	public void inserir() {
		
		Contrato contrato = new Contrato();
		contrato.setAno(2018);
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setId(6);
		contrato.setFornecedor(fornecedor);
		contrato.setNumero("12345");
		VigenciaContrato vigenciaContrato = new VigenciaContrato();
		vigenciaContrato.setInicioVigencia(new Date());
		try{
			contratoDao.inserir(contrato, null, null);
			Assert.assertTrue(true);
		}catch(Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void selectAll() {
		
		try{
			List<Contrato> list= contratoDao.selectAll();
			Assert.assertTrue(!list.isEmpty());
		}catch(Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void selectContratosPorEmail() {
		
		try{
			List<Contrato> list= contratoDao.selectContratosPorEmail("rafaximenes1@gmail.com");
			Assert.assertTrue(!list.isEmpty());
		}catch(Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	

}
