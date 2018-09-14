package br.gov.cgsus.gerenciamentocontrato.dao;

import java.util.List;
import java.util.Map;

import br.gov.cgsus.gerenciamentocontrato.domain.Perfil;
import br.gov.cgsus.gerenciamentocontrato.domain.Usuario;
import br.gov.cgsus.gerenciamentocontrato.domain.UsuarioContrato;

public class UsuarioDao extends Dao{
	
	private String pacote = "org.mybatis.mapper.UsuarioMapper";

	public static boolean teste = false;
	
	public UsuarioDao() {
		teste = false;
	}

	public UsuarioDao(boolean testeConstrutor) {
		teste = testeConstrutor;
	}
	
	public void inserir(Usuario usuario) {
		sqlSession = abreConexao();
		sqlSession.insert(pacote + ".inserir", usuario);
		if (teste)
			fechaConexaoSemCommit();
		else
			fechaConexaoComCommit();
	}
	
	public Usuario selectByEmailSenha(Usuario usuario) {
		sqlSession = abreConexao();
		return sqlSession.selectOne(pacote + ".selectByEmailSenha", usuario);
	}
	
	public List<Usuario> selectAll() {
		sqlSession = abreConexao();
		return sqlSession.selectList(pacote + ".selectAll");
	}
	
	public List<Perfil> selectPerfil() {
		sqlSession = abreConexao();
		return sqlSession.selectList(pacote + ".selectPerfil");
	}
	
	public List<UsuarioContrato> selectUsuarioContrato(Usuario usuario) {
		sqlSession = abreConexao();
		return sqlSession.selectList(pacote + ".selectUsuarioContrato", usuario);
	}
	
	public void vincularUsuarioAoContrato(UsuarioContrato usuarioContrato) {
		sqlSession = abreConexao();
		sqlSession.insert(pacote + ".vincularUsuarioAoContrato", usuarioContrato);
		if (teste)
			fechaConexaoSemCommit();
		else
			fechaConexaoComCommit();
	}
	
	public void alteraSenha(Usuario usuario) {
		sqlSession = abreConexao();
		sqlSession.update(pacote + ".alteraSenha", usuario);
		if (teste)
			fechaConexaoSemCommit();
		else
			fechaConexaoComCommit();
	}
	
	public void alteraUsuario(Usuario usuario) {
		sqlSession = abreConexao();
		sqlSession.update(pacote + ".alteraUsuario", usuario);
		if (teste)
			fechaConexaoSemCommit();
		else
			fechaConexaoComCommit();
	}
	
	public boolean selectUsuarioIsAdmin(UsuarioContrato uc) {
		sqlSession = abreConexao();
		String retorno = sqlSession.selectOne(pacote + ".selectUsuarioIsAdmin",uc);
		return retorno==null?false:true;
	}
	
	public boolean selectUsuarioTemPerfil(Map<String, Integer> map) {
		sqlSession = abreConexao();
		String retorno = sqlSession.selectOne(pacote + ".selectUsuarioTemPerfil",map);
		return retorno==null?false:true;
	}
	
	public Integer selectPerfilUsuario(UsuarioContrato uc) {
		sqlSession = abreConexao();
		return sqlSession.selectOne(pacote + ".selectPerfilUsuario", uc);
	}
	
	
	
	
}
