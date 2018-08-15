package br.gov.cgsus.gerenciamentocontrato.dao;

import java.util.List;

import br.gov.cgsus.gerenciamentocontrato.domain.OrdemServico;

public class OrdemServicoDao extends Dao{
	
	private String pacote = "org.mybatis.mapper.OrdemServicoMapper";

	public static boolean teste = false;
	
	public OrdemServicoDao() {
		teste = false;
	}

	public OrdemServicoDao(boolean testeConstrutor) {
		teste = testeConstrutor;
	}
	
	public void inserir(OrdemServico ordemServico) {
		sqlSession = abreConexao();
		sqlSession.insert(pacote + ".inserir", ordemServico);
		if (teste)
			fechaConexaoSemCommit();
		else
			fechaConexaoComCommit();
	}
	
	public List<OrdemServico> selectAll() {
		sqlSession = abreConexao();
		return sqlSession.selectList(pacote + ".selectAll");
	}
	
	public Integer selectUltimoNumeroPorAno(OrdemServico ordemServico) {
		sqlSession = abreConexao();
		Integer retorno = sqlSession.selectOne(pacote + ".selectUltimoNumeroPorAno", ordemServico);
		if(retorno==null) {
			return 1;
		} else {
			return retorno;
		}
	}
	

}
