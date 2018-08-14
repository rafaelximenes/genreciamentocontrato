package br.gov.cgsus.gerenciamentocontrato.dao;

import java.util.List;

import br.gov.cgsus.gerenciamentocontrato.domain.MetricaVigencia;

public class MetricaVigenciaDao extends Dao{
	
	private String pacote = "org.mybatis.mapper.MetricaVigenciaMapper";

	public static boolean teste = false;
	
	public MetricaVigenciaDao() {
		teste = false;
	}

	public MetricaVigenciaDao(boolean testeConstrutor) {
		teste = testeConstrutor;
	}
	
	public void inserir(MetricaVigencia metricaVigencia) {
		sqlSession = abreConexao();
		sqlSession.insert(pacote + ".inserir", metricaVigencia);
		if (teste)
			fechaConexaoSemCommit();
		else
			fechaConexaoComCommit();
	}
	
	public List<MetricaVigencia> selectAll() {
		sqlSession = abreConexao();
		return sqlSession.selectList(pacote + ".selectAll");
	}
	

}
