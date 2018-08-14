package br.gov.cgsus.gerenciamentocontrato.dao.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.gov.cgsus.gerenciamentocontrato.dao.VigenciaContratoDao;
import br.gov.cgsus.gerenciamentocontrato.domain.Contrato;
import br.gov.cgsus.gerenciamentocontrato.domain.VigenciaContrato;

public class VigenciaContratoDaoTest {
	
	private VigenciaContratoDao vigenciaContratoDao = new VigenciaContratoDao(true);
	
	
	
	@Test
	public void inserir() {
		
		VigenciaContrato vigenciaContrato = new VigenciaContrato();
		Contrato contrato = new Contrato();
		contrato.setId(2);
		vigenciaContrato.setContrato(contrato);
		vigenciaContrato.setInicioVigencia(new Date());
		vigenciaContrato.setTerminoVigencia(null);
		try{
			vigenciaContratoDao.inserir(vigenciaContrato);
			Assert.assertTrue(true);
		}catch(Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void selectAll() {
		
		try{
			List<VigenciaContrato> list= vigenciaContratoDao.selectAll();
			Assert.assertTrue(!list.isEmpty());
		}catch(Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void selectVigenciaValidaPorContrato() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		VigenciaContrato vigenciaContrato = new VigenciaContrato();
		Contrato contrato = new Contrato();
		contrato.setId(8);
		vigenciaContrato.setContrato(contrato);
		
		try {
			vigenciaContrato.setInicioVigencia(sdf.parse("01/01/2018"));
			vigenciaContrato.setTerminoVigencia(sdf.parse("12/12/2018"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try{
			VigenciaContrato retorno = vigenciaContratoDao.selectVigenciaValidaPorContrato(vigenciaContrato);
			Assert.assertTrue(retorno!=null);
		}catch(Exception e) {
			Assert.assertTrue(false);
		}
	}

}
