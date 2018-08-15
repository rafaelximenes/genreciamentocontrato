package br.gov.cgsus.gerenciamentocontrato.dao;

import java.util.List;

import br.gov.cgsus.gerenciamentocontrato.domain.TipoDisponibilidade;

public class TipoDisponibilidadeDao extends Dao{
	
	private String pacote = "org.mybatis.mapper.TipoDisponibilidadeMapper";

	public static boolean teste = false;
	
	public TipoDisponibilidadeDao() {
		teste = false;
	}

	public TipoDisponibilidadeDao(boolean testeConstrutor) {
		teste = testeConstrutor;
	}
	
	public void inserir(TipoDisponibilidade fornecedor) {
		sqlSession = abreConexao();
		sqlSession.insert(pacote + ".inserir", fornecedor);
		if (teste)
			fechaConexaoSemCommit();
		else
			fechaConexaoComCommit();
	}
	
	public List<TipoDisponibilidade> selectAll() {
		sqlSession = abreConexao();
		return sqlSession.selectList(pacote + ".selectAll");
	}
	

}
