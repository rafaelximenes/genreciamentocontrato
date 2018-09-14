package br.gov.cgsus.gerenciamentocontrato.service;

import java.util.List;

import br.gov.cgsus.gerenciamentocontrato.dao.ChamadoSistemaOSDao;
import br.gov.cgsus.gerenciamentocontrato.domain.ChamadoSistemaOS;
import br.gov.cgsus.gerenciamentocontrato.domain.TipoAceite;

public class ChamadoSistemaOSBusiness {
	
	private ChamadoSistemaOSDao chamadoSistemaOSDao = new ChamadoSistemaOSDao();
	
	public void inserir(ChamadoSistemaOS chamadoSistemaOS) throws Exception {
		if(chamadoSistemaOS==null) {
			throw new Exception("Chamado Sistema OS nulo.");
		}
		if(chamadoSistemaOS.getSistemaOS()==null) {
			throw new Exception("Sistema da OS é um campo obrigatório.");
		}
		if(chamadoSistemaOS.getSistemaOS().getId()==null) {
			throw new Exception("Sistema da OS é um campo obrigatório.");
		}
		if(chamadoSistemaOS.getTipoAceite()==null) {
			throw new Exception("Tipo Aceite é um campo obrigatório.");
		}
		if(chamadoSistemaOS.getTipoAceite().getId()==null) {
			throw new Exception("Tipo Aceite é um campo obrigatório.");
		}
		try {
			chamadoSistemaOSDao.inserir(chamadoSistemaOS);
		}catch(Exception e) {
			throw new Exception("Erro ao inserir no banco de dados.");
		}
	}
	
	public List<ChamadoSistemaOS> selectAll() throws Exception {
		try {
			return chamadoSistemaOSDao.selectAll();
		}catch(Exception e) {
			throw new Exception("Erro ao buscar no banco de dados.");
		}
	}
	
	public List<TipoAceite> selectTipoAceite() throws Exception {
		try {
			return chamadoSistemaOSDao.selectTipoAceite();
		}catch(Exception e) {
			throw new Exception("Erro ao buscar no banco de dados.");
		}
	}
	
	public ChamadoSistemaOS selectUltimoChamadoPorSistema(Integer id) throws Exception {
		try {
			return chamadoSistemaOSDao.selectUltimoChamadoPorSistema(id);
		}catch(Exception e) {
			throw new Exception("Erro ao buscar no banco de dados.");
		}
	}
	
	

}
