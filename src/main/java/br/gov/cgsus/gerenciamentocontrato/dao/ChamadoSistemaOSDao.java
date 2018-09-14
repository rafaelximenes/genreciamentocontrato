package br.gov.cgsus.gerenciamentocontrato.dao;

import java.util.List;

import br.gov.cgsus.gerenciamentocontrato.domain.ChamadoSistemaOS;
import br.gov.cgsus.gerenciamentocontrato.domain.TipoAceite;

public class ChamadoSistemaOSDao extends Dao{
	
	private String pacote = "org.mybatis.mapper.ChamadoSistemaOSMapper";

	public static boolean teste = false;
	
	public ChamadoSistemaOSDao() {
		teste = false;
	}

	public ChamadoSistemaOSDao(boolean testeConstrutor) {
		teste = testeConstrutor;
	}
	
	public void inserir(ChamadoSistemaOS chamadoSistemaOS) {
		sqlSession = abreConexao();
		sqlSession.insert(pacote + ".inserir", chamadoSistemaOS);
		if (teste)
			fechaConexaoSemCommit();
		else
			fechaConexaoComCommit();
	}
	
	public List<ChamadoSistemaOS> selectAll() {
		sqlSession = abreConexao();
		return sqlSession.selectList(pacote + ".selectAll");
	}
	
	public List<TipoAceite> selectTipoAceite() {
		sqlSession = abreConexao();
		return sqlSession.selectList(pacote + ".selectTipoAceite");
	}
	
	public ChamadoSistemaOS selectUltimoChamadoPorSistema(Integer id) {
		sqlSession = abreConexao();
		return sqlSession.selectOne(pacote + ".selectUltimoChamadoPorSistema", id);
	}
	
}
