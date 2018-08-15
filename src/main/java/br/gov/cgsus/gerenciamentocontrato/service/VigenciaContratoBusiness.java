package br.gov.cgsus.gerenciamentocontrato.service;

import java.util.List;

import br.gov.cgsus.gerenciamentocontrato.dao.VigenciaContratoDao;
import br.gov.cgsus.gerenciamentocontrato.domain.OrdemServico;
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
	
	public VigenciaContrato selectVigenciaValidaPorContrato(OrdemServico ordemServico) throws Exception {
		if(ordemServico==null) {
			throw new Exception("Ordem de Serviço nula.");
		}
		if(ordemServico.getContrato()==null) {
			throw new Exception("Contrato é um campo obrigatório.");
		}
		if(ordemServico.getContrato().getId()==null) {
			throw new Exception("Contrato é um campo obrigatório.");
		}
		if(ordemServico.getDataAbertura()==null) {
			throw new Exception("Data de Abertura é um campo obrigatório.");
		}
		try {
			return vigenciaContratoDao.selectVigenciaValidaPorContrato(ordemServico);
		}catch(Exception e) {
			throw new Exception("Erro ao buscar no banco de dados.");
		}
	}

}
