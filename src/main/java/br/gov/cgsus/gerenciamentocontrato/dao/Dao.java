package br.gov.cgsus.gerenciamentocontrato.dao;

import org.apache.ibatis.session.SqlSession;

import br.gov.cgsus.gerenciamentocontrato.dao.config.SqlSessionInstance;

public abstract class Dao {

	protected SqlSessionInstance sqlSessionInstance = SqlSessionInstance.getInstace();
	
	protected SqlSession sqlSession;
	
	protected SqlSession abreConexao() {
		return sqlSessionInstance.getInstanceSession(); 
	}
	
	protected void fechaConexaoComCommit() {
		sqlSession.commit();
		sqlSessionInstance.closeInstance();
	}
	
	protected void fechaConexaoSemCommit() {
		sqlSessionInstance.closeInstance();
	}
	
}
