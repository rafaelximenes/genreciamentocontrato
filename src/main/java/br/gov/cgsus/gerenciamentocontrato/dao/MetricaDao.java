package br.gov.cgsus.gerenciamentocontrato.dao;

import java.util.List;

import br.gov.cgsus.gerenciamentocontrato.domain.Metrica;

public class MetricaDao extends Dao{
	
	private String pacote = "org.mybatis.mapper.MetricaMapper";

	public static boolean teste = false;
	
	public MetricaDao() {
		teste = false;
	}

	public MetricaDao(boolean testeConstrutor) {
		teste = testeConstrutor;
	}
	
	public void inserir(Metrica metrica) {
		sqlSession = abreConexao();
		sqlSession.insert(pacote + ".inserir", metrica);
		if (teste)
			fechaConexaoSemCommit();
		else
			fechaConexaoComCommit();
	}
	
	public List<Metrica> selectAll() {
		sqlSession = abreConexao();
		return sqlSession.selectList(pacote + ".selectAll");
	}
	

}
