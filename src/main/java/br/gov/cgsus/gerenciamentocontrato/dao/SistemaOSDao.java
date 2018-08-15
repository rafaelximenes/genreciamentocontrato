package br.gov.cgsus.gerenciamentocontrato.dao;

import java.util.List;

import br.gov.cgsus.gerenciamentocontrato.domain.SistemaOS;

public class SistemaOSDao extends Dao{
	
	private String pacote = "org.mybatis.mapper.SistemaOSMapper";

	public static boolean teste = false;
	
	public SistemaOSDao() {
		teste = false;
	}

	public SistemaOSDao(boolean testeConstrutor) {
		teste = testeConstrutor;
	}
	
	public void inserir(SistemaOS sistemaOS) {
		sqlSession = abreConexao();
		sqlSession.insert(pacote + ".inserir", sistemaOS);
		if (teste)
			fechaConexaoSemCommit();
		else
			fechaConexaoComCommit();
	}
	
	public List<SistemaOS> selectAll() {
		sqlSession = abreConexao();
		return sqlSession.selectList(pacote + ".selectAll");
	}
	

}
