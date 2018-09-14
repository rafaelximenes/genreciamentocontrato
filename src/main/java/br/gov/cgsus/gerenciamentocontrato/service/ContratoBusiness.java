package br.gov.cgsus.gerenciamentocontrato.service;

import java.util.List;

import br.gov.cgsus.gerenciamentocontrato.dao.ContratoDao;
import br.gov.cgsus.gerenciamentocontrato.domain.Contrato;
import br.gov.cgsus.gerenciamentocontrato.domain.MetricaVigencia;
import br.gov.cgsus.gerenciamentocontrato.domain.VigenciaContrato;

public class ContratoBusiness {
	
	private ContratoDao contratoDao = new ContratoDao();
	
	public void inserir(Contrato contrato, VigenciaContrato vigenciaContrato, MetricaVigencia metricaVigencia) throws Exception {
		if(contrato==null) {
			throw new Exception("Contrato nulo.");
		}
		if(contrato.getNumero()==null || "".equalsIgnoreCase(contrato.getNumero())) {
			throw new Exception("Número do contrato é um campo obrigatório.");
		}
		if(contrato.getAno()==null) {
			throw new Exception("Ano do contrato é um campo obrigatório.");
		}
		if(contrato.getFornecedor()==null) {
			throw new Exception("Fornecedor do contrato é um campo obrigatório.");
		}
		if(contrato.getFornecedor().getId()==null) {
			throw new Exception("Fornecedor do contrato é um campo obrigatório.");
		}
		try {
			contratoDao.inserir(contrato, vigenciaContrato, metricaVigencia);
			
		}catch(Exception e) {
			throw new Exception("Erro ao inserir no banco de dados.");
		}
	}
	
	public List<Contrato> selectAll() throws Exception {
		try {
			return contratoDao.selectAll();
		}catch(Exception e) {
			throw new Exception("Erro ao buscar no banco de dados.");
		}
	}
	
	public List<Contrato> selectContratosPorEmail(String email) throws Exception {
		if(email==null) {
			throw new Exception("Email é obrigatório.");
		}
		try {
			return contratoDao.selectContratosPorEmail(email);
		}catch(Exception e) {
			throw new Exception("Erro ao buscar no banco de dados.");
		}
	}
	
	

}
