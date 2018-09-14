package br.gov.cgsus.gerenciamentocontrato.dao.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.gov.cgsus.gerenciamentocontrato.dao.SistemaOSDao;
import br.gov.cgsus.gerenciamentocontrato.domain.NivelCriticidade;
import br.gov.cgsus.gerenciamentocontrato.domain.OrdemServico;
import br.gov.cgsus.gerenciamentocontrato.domain.Sistema;
import br.gov.cgsus.gerenciamentocontrato.domain.SistemaOS;
import br.gov.cgsus.gerenciamentocontrato.domain.TipoDisponibilidade;

public class SistemaOSDaoTest {
	
	private SistemaOSDao sistemaOSDao = new SistemaOSDao(true);
	
	
	
	@Test
	public void inserir() {
		NivelCriticidade nivelCriticidade = new NivelCriticidade(2);
		nivelCriticidade.setTempoIndisponibilidade(3);
		SistemaOS sistemaOS = new SistemaOS();
		sistemaOS.setSistema(new Sistema(2));
		sistemaOS.setNivelCriticidade(nivelCriticidade);
		sistemaOS.setTipoDisponibilidade(new TipoDisponibilidade(3));
		sistemaOS.setOrdemServico(new OrdemServico(3));
		sistemaOS.setTamanhoPF(100);
		sistemaOS.setCoberturaTeste(98D);
		sistemaOS.setPercentualDisponibilidade(99.5);
		sistemaOS.setQtdhoraSustentada(12.4);
		sistemaOS.setFatorPFS(12.4);
		sistemaOS.setQtdPFS(12.4);
		sistemaOS.setValorUnitarioPFS(12.4);
		

		try{
			sistemaOSDao.inserir(sistemaOS);
			Assert.assertTrue(true);
		}catch(Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void selectAll() {
		
		try{
			List<SistemaOS> list= sistemaOSDao.selectAll();
			Assert.assertTrue(!list.isEmpty());
		}catch(Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void selectSistemasAtivosDasOSAtivas() {
		
		try{
			List<SistemaOS> list= sistemaOSDao.selectSistemasAtivosDasOSAtivas();
			Assert.assertTrue(!list.isEmpty());
		}catch(Exception e) {
			Assert.assertTrue(false);
		}
	}

}
