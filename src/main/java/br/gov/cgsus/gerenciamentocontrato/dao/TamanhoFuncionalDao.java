package br.gov.cgsus.gerenciamentocontrato.dao;

import java.util.List;

import br.gov.cgsus.gerenciamentocontrato.domain.TamanhoFuncional;

public class TamanhoFuncionalDao extends Dao{
	
	private String pacote = "org.mybatis.mapper.TamanhoFuncionalMapper";

	public static boolean teste = false;
	
	public TamanhoFuncionalDao() {
		teste = false;
	}

	public TamanhoFuncionalDao(boolean testeConstrutor) {
		teste = testeConstrutor;
	}
	
	public void inserir(TamanhoFuncional tamanhoFuncional) {
		sqlSession = abreConexao();
		sqlSession.insert(pacote + ".inserir", tamanhoFuncional);
		if (teste)
			fechaConexaoSemCommit();
		else
			fechaConexaoComCommit();
	}
	
	public List<TamanhoFuncional> selectAll() {
		sqlSession = abreConexao();
		return sqlSession.selectList(pacote + ".selectAll");
	}
	
	public List<TamanhoFuncional> selectPorIdSistema(TamanhoFuncional tamanhoFuncional) {
		sqlSession = abreConexao();
		return sqlSession.selectList(pacote + ".selectPorIdSistema", tamanhoFuncional);
	}
	

}
