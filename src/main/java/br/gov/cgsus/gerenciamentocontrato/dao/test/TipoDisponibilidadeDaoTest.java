package br.gov.cgsus.gerenciamentocontrato.dao.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.gov.cgsus.gerenciamentocontrato.dao.TipoDisponibilidadeDao;
import br.gov.cgsus.gerenciamentocontrato.domain.TipoDisponibilidade;

public class TipoDisponibilidadeDaoTest {
	
	private TipoDisponibilidadeDao tipoDisponibilidadeDao = new TipoDisponibilidadeDao(true);
	
	
	
	@Test
	public void inserir() {
		
		TipoDisponibilidade tipoDisponibilidade = new TipoDisponibilidade();
		tipoDisponibilidade.setDescricao("Teste Descrição");
		tipoDisponibilidade.setDiasCorridos(true);
		tipoDisponibilidade.setFatorHoras(12);
		tipoDisponibilidade.setNome("Teste Nome");

		try{
			tipoDisponibilidadeDao.inserir(tipoDisponibilidade);
			Assert.assertTrue(true);
		}catch(Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void selectAll() {
		
		try{
			List<TipoDisponibilidade> list= tipoDisponibilidadeDao.selectAll();
			Assert.assertTrue(!list.isEmpty());
		}catch(Exception e) {
			Assert.assertTrue(false);
		}
	}

}
