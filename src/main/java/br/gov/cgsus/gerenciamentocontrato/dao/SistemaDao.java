package br.gov.cgsus.gerenciamentocontrato.dao;

import java.util.List;

import br.gov.cgsus.gerenciamentocontrato.domain.Sistema;

public class SistemaDao extends Dao{
	
	private String pacote = "org.mybatis.mapper.SistemaMapper";

	public static boolean teste = false;
	
	public SistemaDao() {
		teste = false;
	}

	public SistemaDao(boolean testeConstrutor) {
		teste = testeConstrutor;
	}
	
	public void inserir(Sistema sistema) {
		sqlSession = abreConexao();
		sqlSession.insert(pacote + ".inserir", sistema);
		if (teste)
			fechaConexaoSemCommit();
		else
			fechaConexaoComCommit();
	}
	
	public List<Sistema> selectAll() {
		sqlSession = abreConexao();
		return sqlSession.selectList(pacote + ".selectAll");
	}
	

}
