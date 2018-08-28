package br.gov.cgsus.gerenciamentocontrato.dao.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.gov.cgsus.gerenciamentocontrato.dao.UsuarioDao;
import br.gov.cgsus.gerenciamentocontrato.domain.Contrato;
import br.gov.cgsus.gerenciamentocontrato.domain.Perfil;
import br.gov.cgsus.gerenciamentocontrato.domain.Usuario;
import br.gov.cgsus.gerenciamentocontrato.domain.UsuarioContrato;

public class UsuarioDaoTest {
	
	private UsuarioDao usuarioDao = new UsuarioDao(true);
	
	
	
	@Test
	public void inserir() {
		
		Usuario usuario = new Usuario();
		usuario.setNome("Teste");
		usuario.setPerfil(new Perfil(1, "Adm"));
	  	usuario.setEmail("rafaximenes1@gmail.com");
	  	usuario.setCpf("12345678951");
	  	usuario.setSenha("123");
		
		try{
			usuarioDao.inserir(usuario);
			Assert.assertTrue(true);
		}catch(Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void selectByCpfSenha() {
		Usuario usuario = new Usuario();
		usuario.setCpf("04208920360");
		usuario.setSenha("123");
		try{
			List<UsuarioContrato> list= usuarioDao.selectByCpfSenha(usuario);
			Assert.assertTrue(!list.isEmpty());
		}catch(Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void selectAll() {
		try{
			List<Usuario> list= usuarioDao.selectAll();
			Assert.assertTrue(!list.isEmpty());
		}catch(Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void selectPerfil() {
		try{
			List<Perfil> list= usuarioDao.selectPerfil();
			Assert.assertTrue(!list.isEmpty());
		}catch(Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void vincularUsuarioAoContrato() {
		UsuarioContrato usuarioContrato = new UsuarioContrato(new Usuario(1), new Contrato(7));
		try{
			usuarioDao.vincularUsuarioAoContrato(usuarioContrato);
			Assert.assertTrue(true);
		}catch(Exception e) {
			Assert.assertTrue(false);
		}
	}

}
