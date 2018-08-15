package br.gov.cgsus.gerenciamentocontrato.dao;

import java.util.List;

import br.gov.cgsus.gerenciamentocontrato.domain.NivelCriticidade;

public class NivelCriticidadeDao extends Dao{
	
	private String pacote = "org.mybatis.mapper.NivelCriticidadeMapper";

	public static boolean teste = false;
	
	public NivelCriticidadeDao() {
		teste = false;
	}

	public NivelCriticidadeDao(boolean testeConstrutor) {
		teste = testeConstrutor;
	}
	
	public List<NivelCriticidade> selectAll() {
		sqlSession = abreConexao();
		return sqlSession.selectList(pacote + ".selectAll");
	}
	

}
