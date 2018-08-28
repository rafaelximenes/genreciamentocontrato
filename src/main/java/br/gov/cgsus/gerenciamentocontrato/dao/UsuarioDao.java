package br.gov.cgsus.gerenciamentocontrato.dao;

import java.util.List;

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
	
	public List<UsuarioContrato> selectByCpfSenha(Usuario usuario) {
		sqlSession = abreConexao();
		return sqlSession.selectList(pacote + ".selectByCpfSenha", usuario);
	}
	
	public List<Usuario> selectAll() {
		sqlSession = abreConexao();
		return sqlSession.selectList(pacote + ".selectAll");
	}
	
	public List<Perfil> selectPerfil() {
		sqlSession = abreConexao();
		return sqlSession.selectList(pacote + ".selectPerfil");
	}
	
	public void vincularUsuarioAoContrato(UsuarioContrato usuarioContrato) {
		sqlSession = abreConexao();
		sqlSession.insert(pacote + ".vincularUsuarioAoContrato", usuarioContrato);
		if (teste)
			fechaConexaoSemCommit();
		else
			fechaConexaoComCommit();
	}
	
}
