package br.gov.cgsus.gerenciamentocontrato.service;

import java.util.List;

import br.gov.cgsus.gerenciamentocontrato.dao.VigenciaContratoDao;
import br.gov.cgsus.gerenciamentocontrato.domain.VigenciaContrato;

public class VigenciaContratoBusiness {
	
	private VigenciaContratoDao vigenciaContratoDao = new VigenciaContratoDao();
	
	public void inserir(VigenciaContrato vigenciaContrato) throws Exception {
		if(vigenciaContrato==null) {
			throw new Exception("Vigencia do Contrato nulo.");
		}
		if(vigenciaContrato.getInicioVigencia() ==null) {
			throw new Exception("Início da vigência é um campo obrigatório.");
		}
		if(vigenciaContrato.getContrato()==null) {
			throw new Exception("Contrato é um campo obrigatório.");
		}
		if(vigenciaContrato.getContrato().getId()==null) {
			throw new Exception("Contrato é um campo obrigatório.");
		}
		try {
			vigenciaContratoDao.inserir(vigenciaContrato);
		}catch(Exception e) {
			throw new Exception("Erro ao inserir no banco de dados.");
		}
	}
	
	public List<VigenciaContrato> selectAll() throws Exception {
		try {
			return vigenciaContratoDao.selectAll();
		}catch(Exception e) {
			throw new Exception("Erro ao buscar no banco de dados.");
		}
	}

}
