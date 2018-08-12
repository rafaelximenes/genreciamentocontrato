package br.gov.cgsus.gerenciamentocontrato.dao;

import java.util.List;

import br.gov.cgsus.gerenciamentocontrato.domain.Fornecedor;

public class FornecedorDao extends Dao{
	
	private String pacote = "org.mybatis.mapper.FornecedorMapper";

	public static boolean teste = false;
	
	public FornecedorDao() {
		teste = false;
	}

	public FornecedorDao(boolean testeConstrutor) {
		teste = testeConstrutor;
	}
	
	public void inserir(Fornecedor fornecedor) {
		sqlSession = abreConexao();
		sqlSession.insert(pacote + ".inserir", fornecedor);
		if (teste)
			fechaConexaoSemCommit();
		else
			fechaConexaoComCommit();
	}
	
	public List<Fornecedor> selectAll() {
		sqlSession = abreConexao();
		return sqlSession.selectList(pacote + ".selectAll");
	}
	

}
