package br.gov.cgsus.gerenciamentocontrato.dao;

import java.util.List;

import br.gov.cgsus.gerenciamentocontrato.domain.VigenciaContrato;

public class VigenciaContratoDao extends Dao{
	
	private String pacote = "org.mybatis.mapper.VigenciaContratoMapper";

	public static boolean teste = false;
	
	public VigenciaContratoDao() {
		teste = false;
	}

	public VigenciaContratoDao(boolean testeConstrutor) {
		teste = testeConstrutor;
	}
	
	public void inserir(VigenciaContrato vigenciaContrato) {
		sqlSession = abreConexao();
		sqlSession.insert(pacote + ".inserir", vigenciaContrato);
		if (teste)
			fechaConexaoSemCommit();
		else
			fechaConexaoComCommit();
	}
	
	public List<VigenciaContrato> selectAll() {
		sqlSession = abreConexao();
		return sqlSession.selectList(pacote + ".selectAll");
	}
	
	public VigenciaContrato selectVigenciaValidaPorContrato(VigenciaContrato vigenciaContrato) {
		sqlSession = abreConexao();
		sqlSession.selectList(pacote + ".selectVigenciaValidaPorContrato");
		return sqlSession.selectOne(pacote + ".selectVigenciaValidaPorContrato", vigenciaContrato);
	}
	
	
	

}
