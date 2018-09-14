package br.gov.cgsus.gerenciamentocontrato.dao.test;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.gov.cgsus.gerenciamentocontrato.dao.ChamadoSistemaOSDao;
import br.gov.cgsus.gerenciamentocontrato.domain.ChamadoSistemaOS;
import br.gov.cgsus.gerenciamentocontrato.domain.SistemaOS;
import br.gov.cgsus.gerenciamentocontrato.domain.TipoAceite;

public class ChamadoSistemaOSDaoTest {
	
	private ChamadoSistemaOSDao chamadoSistemaOSDao = new ChamadoSistemaOSDao(true);
	
	@Test
	public void inserir() {
		
		ChamadoSistemaOS chamadoSistemaOS = new ChamadoSistemaOS();
		chamadoSistemaOS.setAbertura(new Date());
		chamadoSistemaOS.setAtraso(1);
		chamadoSistemaOS.setCoberturaTesteApurado(1D);
		chamadoSistemaOS.setDescricao("Teste");
		chamadoSistemaOS.setFimAtendimento(new Date());
		chamadoSistemaOS.setInicioAtendimento(new Date());
		chamadoSistemaOS.setQtdDiasAtrasoProduto(1);
		chamadoSistemaOS.setSistemaOS(new SistemaOS());
		chamadoSistemaOS.getSistemaOS().setId(5);
		chamadoSistemaOS.setStatus("A");
		chamadoSistemaOS.setTipoAceite(new TipoAceite(1));
		

		try{
			chamadoSistemaOSDao.inserir(chamadoSistemaOS);
			Assert.assertTrue(true);
		}catch(Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void selectAll() {
		
		try{
			List<ChamadoSistemaOS> list= chamadoSistemaOSDao.selectAll();
			Assert.assertTrue(!list.isEmpty());
		}catch(Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void selectTipoAceite() {
		
		try{
			List<TipoAceite> list= chamadoSistemaOSDao.selectTipoAceite();
			Assert.assertTrue(!list.isEmpty());
		}catch(Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void selectUltimoChamadoPorSistema() {
		
		try{
			ChamadoSistemaOS chamadoSistemaOS = chamadoSistemaOSDao.selectUltimoChamadoPorSistema(5);
			Assert.assertTrue(chamadoSistemaOS!=null);
		}catch(Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	

}
