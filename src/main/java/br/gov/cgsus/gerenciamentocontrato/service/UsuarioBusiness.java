package br.gov.cgsus.gerenciamentocontrato.service;

import java.util.List;

import br.gov.cgsus.gerenciamentocontrato.dao.UsuarioDao;
import br.gov.cgsus.gerenciamentocontrato.domain.Perfil;
import br.gov.cgsus.gerenciamentocontrato.domain.Usuario;
import br.gov.cgsus.gerenciamentocontrato.domain.UsuarioContrato;

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
		if(usuario.getPerfil()==null) {
			throw new Exception("Perfil é um campo obrigatório.");
		}
		if(usuario.getPerfil().getId()==null) {
			throw new Exception("Perfil é um campo obrigatório.");
		}
		try {
			usuarioDao.inserir(usuario);
		}catch(Exception e) {
			throw new Exception("Erro ao inserir no banco de dados.");
		}
	}
	
	public List<UsuarioContrato> selectByCpfSenha(Usuario usuario) throws Exception {
		try {
			return usuarioDao.selectByCpfSenha(usuario);
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

}
