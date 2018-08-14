package br.gov.cgsus.gerenciamentocontrato.dao.test;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.gov.cgsus.gerenciamentocontrato.dao.OrdemServicoDao;
import br.gov.cgsus.gerenciamentocontrato.domain.Contrato;
import br.gov.cgsus.gerenciamentocontrato.domain.OrdemServico;
import br.gov.cgsus.gerenciamentocontrato.domain.TipoOS;
import br.gov.cgsus.gerenciamentocontrato.domain.VigenciaContrato;

public class OrdemServicoDaoTest {
	
	private OrdemServicoDao ordemServicoDao = new OrdemServicoDao(true);
	
	
	
	@Test
	public void inserir() {
		
		OrdemServico ordemServico = new OrdemServico();
		ordemServico.setAno(2018);
		ordemServico.setContrato(new Contrato(8));
		ordemServico.setDataAbertura(new Date());
		ordemServico.setDataInicioPeriodo(new Date());
		ordemServico.setDataFimPeriodo(new Date());
		ordemServico.setNumero(1);
		ordemServico.setQtdDias(30);
		ordemServico.setQtdDiasUteis(20);
		ordemServico.setTipoOS(new TipoOS(2));
		ordemServico.setVigenciaContrato(new VigenciaContrato(6));

		try{
			ordemServicoDao.inserir(ordemServico);
			Assert.assertTrue(true);
		}catch(Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void selectAll() {
		
		try{
			List<OrdemServico> list= ordemServicoDao.selectAll();
			Assert.assertTrue(!list.isEmpty());
		}catch(Exception e) {
			Assert.assertTrue(false);
		}
	}

}
