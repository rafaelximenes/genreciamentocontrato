package br.gov.cgsus.gerenciamentocontrato.dao.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public void selectByEmailSenha() {
		Usuario usuario = new Usuario();
		usuario.setEmail("rafaximenes1@gmail.com");
		usuario.setSenha("123");
		try{
			Usuario list= usuarioDao.selectByEmailSenha(usuario);
			Assert.assertTrue(list!=null);
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
	public void selectUsuarioContrato() {
		Usuario usuario = new Usuario();
		usuario.setId(5);
		try{
			List<UsuarioContrato> list= usuarioDao.selectUsuarioContrato(usuario);
			Assert.assertTrue(!list.isEmpty());
		}catch(Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void vincularUsuarioAoContrato() {
		UsuarioContrato usuarioContrato = new UsuarioContrato(new Usuario(5), new Contrato(7), new Perfil(1));
		try{
			usuarioDao.vincularUsuarioAoContrato(usuarioContrato);
			Assert.assertTrue(true);
		}catch(Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void selectUsuarioIsAdmin() {
		UsuarioContrato uc = new UsuarioContrato();
		uc.setContrato(new Contrato(11));
		uc.setUsuario(new Usuario(5));
		try{
			boolean retorno= usuarioDao.selectUsuarioIsAdmin(uc);
			Assert.assertTrue(retorno);
		}catch(Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void selectUsuarioTemPerfil() {
		Map<String, Integer> map = new HashMap<String,Integer>();
		map.put("id_contrato", 11);
		map.put("id_usuario", 7);
		map.put("id_funcionalidade", 2);
		try{
			boolean retorno= usuarioDao.selectUsuarioTemPerfil(map);
			Assert.assertTrue(retorno);
		}catch(Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void selectPerfilUsuario() {
		UsuarioContrato uc = new UsuarioContrato();
		uc.setContrato(new Contrato(11));
		uc.setUsuario(new Usuario(5));
		try{
			Integer retorno= usuarioDao.selectPerfilUsuario(uc);
			Assert.assertTrue(retorno!=null);
		}catch(Exception e) {
			Assert.assertTrue(false);
		}
	}
	
}
