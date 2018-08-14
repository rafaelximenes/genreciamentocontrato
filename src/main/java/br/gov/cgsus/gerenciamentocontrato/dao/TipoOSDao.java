package br.gov.cgsus.gerenciamentocontrato.dao;

import java.util.List;

import br.gov.cgsus.gerenciamentocontrato.domain.TipoOS;

public class TipoOSDao extends Dao{
	
	private String pacote = "org.mybatis.mapper.TipoOSMapper";

	public static boolean teste = false;
	
	public TipoOSDao() {
		teste = false;
	}

	public TipoOSDao(boolean testeConstrutor) {
		teste = testeConstrutor;
	}
	
	public void inserir(TipoOS tipoOS) {
		sqlSession = abreConexao();
		sqlSession.insert(pacote + ".inserir", tipoOS);
		if (teste)
			fechaConexaoSemCommit();
		else
			fechaConexaoComCommit();
	}
	
	public List<TipoOS> selectAll() {
		sqlSession = abreConexao();
		return sqlSession.selectList(pacote + ".selectAll");
	}
	

}
