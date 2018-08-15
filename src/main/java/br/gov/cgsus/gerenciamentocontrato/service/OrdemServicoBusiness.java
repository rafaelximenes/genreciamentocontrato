package br.gov.cgsus.gerenciamentocontrato.service;

import java.util.List;

import br.gov.cgsus.gerenciamentocontrato.dao.OrdemServicoDao;
import br.gov.cgsus.gerenciamentocontrato.domain.OrdemServico;

public class OrdemServicoBusiness {
	
	private OrdemServicoDao ordemServicoDao = new OrdemServicoDao();
	
	public void inserir(OrdemServico ordemServico) throws Exception {
		if(ordemServico==null) {
			throw new Exception("Ordem de Serviço nula.");
		}
		if(ordemServico.getContrato()==null) {
			throw new Exception("Contrato é um campo obrigatório.");
		}
		if(ordemServico.getContrato().getId()==null) {
			throw new Exception("Contrato é um campo obrigatório.");
		}
		if(ordemServico.getTipoOS()==null) {
			throw new Exception("Tipo de OS é um campo obrigatório.");
		}
		if(ordemServico.getTipoOS().getId()==null) {
			throw new Exception("Tipo de OS é um campo obrigatório.");
		}
		if(ordemServico.getVigenciaContrato()==null) {
			throw new Exception("Vigência de Contrato é um campo obrigatório.");
		}
		if(ordemServico.getVigenciaContrato().getId()==null) {
			throw new Exception("Vigência de Contrato é um campo obrigatório.");
		}
		if(ordemServico.getAno()==null) {
			throw new Exception("Ano é um campo obrigatório.");
		}
		if(ordemServico.getDataAbertura()==null) {
			throw new Exception("Data de Abertura é um campo obrigatório.");
		}
		if(ordemServico.getDataInicioPeriodo()==null) {
			throw new Exception("Data Início Período é um campo obrigatório.");
		}
		if(ordemServico.getDataFimPeriodo()==null) {
			throw new Exception("Data Fim Período é um campo obrigatório.");
		}
		if(ordemServico.getNumero()==null) {
			throw new Exception("Número é um campo obrigatório.");
		}
		if(ordemServico.getQtdDias()==null) {
			throw new Exception("Quantidade Dias é um campo obrigatório.");
		}
		if(ordemServico.getQtdDiasUteis()==null) {
			throw new Exception("Quantidade Dias Úteis é um campo obrigatório.");
		}
		try {
			ordemServicoDao.inserir(ordemServico);
		}catch(Exception e) {
			throw new Exception("Erro ao inserir no banco de dados.");
		}
	}
	
	public List<OrdemServico> selectAll() throws Exception {
		try {
			return ordemServicoDao.selectAll();
		}catch(Exception e) {
			throw new Exception("Erro ao buscar no banco de dados.");
		}
	}
	
	public Integer selectUltimoNumeroPorAno(OrdemServico ordemServico) throws Exception {
		if(ordemServico==null) {
			throw new Exception("Ordem de Serviço nula.");
		}
		if(ordemServico.getAno()==null) {
			throw new Exception("Ano é um campo obrigatório.");
		}
		if(ordemServico.getContrato()==null) {
			throw new Exception("Contrato é um campo obrigatório.");
		}
		if(ordemServico.getContrato().getId()==null) {
			throw new Exception("Contrato é um campo obrigatório.");
		}
		try {
			Integer retorno = ordemServicoDao.selectUltimoNumeroPorAno(ordemServico);
			return retorno+1;
		}catch(Exception e) {
			throw new Exception("Erro ao buscar no banco de dados.");
		}
		
	}

}
