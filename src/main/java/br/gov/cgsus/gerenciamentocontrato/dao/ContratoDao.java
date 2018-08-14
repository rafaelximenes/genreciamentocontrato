package br.gov.cgsus.gerenciamentocontrato.dao;

import java.util.List;

import br.gov.cgsus.gerenciamentocontrato.domain.Contrato;
import br.gov.cgsus.gerenciamentocontrato.domain.MetricaVigencia;
import br.gov.cgsus.gerenciamentocontrato.domain.VigenciaContrato;

public class ContratoDao extends Dao{
	
	private String pacote = "org.mybatis.mapper.ContratoMapper";

	public static boolean teste = false;
	
	public ContratoDao() {
		teste = false;
	}

	public ContratoDao(boolean testeConstrutor) {
		teste = testeConstrutor;
	}
	
	public void inserir(Contrato contrato, VigenciaContrato vigenciaContrato, MetricaVigencia metricaVigencia) {
		sqlSession = abreConexao();
		sqlSession.insert(pacote + ".inserir", contrato);
		if (teste) 
			fechaConexaoSemCommit();
		
		else {
			fechaConexaoComCommit();
			VigenciaContratoDao vigenciaContratoDao = new VigenciaContratoDao();
			vigenciaContrato.setContrato(contrato);
			vigenciaContratoDao.inserir(vigenciaContrato);
			
			MetricaVigenciaDao metricaVigenciaDao = new MetricaVigenciaDao();
			metricaVigencia.setVigenciaContrato(vigenciaContrato);
			metricaVigenciaDao.inserir(metricaVigencia);
		}
	}
	
	public List<Contrato> selectAll() {
		sqlSession = abreConexao();
		return sqlSession.selectList(pacote + ".selectAll");
	}
	

}
