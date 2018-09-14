package br.gov.cgsus.gerenciamentocontrato.service;

import java.util.List;
import java.util.Map;

import br.gov.cgsus.gerenciamentocontrato.dao.UsuarioDao;
import br.gov.cgsus.gerenciamentocontrato.domain.Perfil;
import br.gov.cgsus.gerenciamentocontrato.domain.Usuario;
import br.gov.cgsus.gerenciamentocontrato.domain.UsuarioContrato;
import br.gov.cgsus.gerenciamentocontrato.utils.Util;

public class UsuarioBusiness {
	
	private UsuarioDao usuarioDao = new UsuarioDao();
	
	public void inserir(Usuario usuario) throws Exception {
		if(usuario==null) {
			throw new Exception("Usuario nulo.");
		}
		if(usuario.getEmail()==null || "".equalsIgnoreCase(usuario.getEmail())) {
			throw new Exception("E-mail é um campo obrigatório.");
		}
		if(usuario.getNome()==null || "".equalsIgnoreCase(usuario.getNome())) {
			throw new Exception("Nome é um campo obrigatório.");
		}
		if(usuario.getSenha()==null || "".equalsIgnoreCase(usuario.getSenha())) {
			throw new Exception("Senha é um campo obrigatório.");
		}
		if(usuario.getCpf()==null || "".equalsIgnoreCase(usuario.getCpf())) {
			throw new Exception("CPF é um campo obrigatório.");
		}
		try {
			usuario.setSenha(Util.geraSHA256(usuario.getSenha()));
			usuarioDao.inserir(usuario);
		}catch(Exception e) {
			throw new Exception("Erro ao inserir no banco de dados.");
		}
	}
	
	public Usuario selectByEmailSenha(Usuario usuario) throws Exception {
		try {
			return usuarioDao.selectByEmailSenha(usuario);
		}catch(Exception e) {
			throw new Exception("Erro ao buscar no banco de dados.");
		}
	}
	
	public List<Usuario> selectAll() throws Exception {
		try {
			return usuarioDao.selectAll();
		}catch(Exception e) {
			throw new Exception("Erro ao buscar no banco de dados.");
		}
	}
	
	public List<Perfil> selectPerfil() throws Exception {
		try {
			return usuarioDao.selectPerfil();
		}catch(Exception e) {
			throw new Exception("Erro ao buscar no banco de dados.");
		}
	}
	
	public void vincularUsuarioAoContrato(UsuarioContrato usuarioContrato) throws Exception {
		try {
			usuarioDao.vincularUsuarioAoContrato(usuarioContrato);
		}catch(Exception e) {
			throw new Exception("Erro ao inserir no banco de dados.");
		}
	}
	
	public List<UsuarioContrato> selectUsuarioContrato(Usuario usuario) throws Exception {
		try {
			if(usuario==null) {
				throw new Exception("Usuario nulo.");
			}
			if(usuario.getId()==null) {
				throw new Exception("Usuario não informado.");
			}
			return usuarioDao.selectUsuarioContrato(usuario);
		}catch(Exception e) {
			throw new Exception("Erro ao buscar no banco de dados.");
		}
	}
	
	public void alteraSenha(Usuario usuario) throws Exception {
		try {
			usuarioDao.alteraSenha(usuario);
		}catch(Exception e) {
			throw new Exception("Erro ao atualizar no banco de dados.");
		}
	}
	
	public void alteraUsuario(Usuario usuario) throws Exception {
		try {
			usuarioDao.alteraUsuario(usuario);
		}catch(Exception e) {
			throw new Exception("Erro ao atualizar no banco de dados.");
		}
	}
	
	public boolean selectUsuarioIsAdmin(UsuarioContrato uc) throws Exception {
		try {
			return usuarioDao.selectUsuarioIsAdmin(uc);
		}catch(Exception e) {
			throw new Exception("Erro ao atualizar no banco de dados.");
		}
		
	}
	
	public boolean selectUsuarioTemPerfil(Map<String, Integer> map) throws Exception {
		try {
			return usuarioDao.selectUsuarioTemPerfil(map);
		}catch(Exception e) {
			throw new Exception("Erro ao atualizar no banco de dados.");
		}
	}
	
	public Integer selectPerfilUsuario(UsuarioContrato uc) throws Exception {
		try {
			return usuarioDao.selectPerfilUsuario(uc);
		}catch(Exception e) {
			throw new Exception("Erro ao atualizar no banco de dados.");
		}
	}
	
	

}
