package br.gov.cgsus.gerenciamentocontrato.service;

import java.util.List;

import br.gov.cgsus.gerenciamentocontrato.dao.SistemaOSDao;
import br.gov.cgsus.gerenciamentocontrato.domain.SistemaOS;

public class SistemaOSBusiness {
	
	private SistemaOSDao sistemaOSDao = new SistemaOSDao();
	
	public void inserir(SistemaOS sistemaOS) throws Exception {
		if(sistemaOS==null) {
			throw new Exception("SistemaOS nulo.");
		}
		if(sistemaOS.getNivelCriticidade()==null) {
			throw new Exception("Nível de Criticidade é um campo obrigatório.");
		}
		if(sistemaOS.getNivelCriticidade().getId()==null) {
			throw new Exception("Nível de Criticidade é um campo obrigatório.");
		}
		if(sistemaOS.getNivelCriticidade().getTempoIndisponibilidade()==null) {
			throw new Exception("Tempo de Indisponibilidade é um campo obrigatório.");
		}
		if(sistemaOS.getSistema()==null) {
			throw new Exception("Sistema é um campo obrigatório.");
		}
		if(sistemaOS.getSistema().getId()==null) {
			throw new Exception("Sistema é um campo obrigatório.");
		}
		if(sistemaOS.getTipoDisponibilidade()==null) {
			throw new Exception("Tipo de Disponibilidade é um campo obrigatório.");
		}
		if(sistemaOS.getTipoDisponibilidade().getId()==null) {
			throw new Exception("Tipo de Disponibilidade é um campo obrigatório.");
		}
		if(sistemaOS.getOrdemServico()==null) {
			throw new Exception("Ordem de Serviço é um campo obrigatório.");
		}
		if(sistemaOS.getOrdemServico().getId()==null) {
			throw new Exception("Ordem de Serviço é um campo obrigatório.");
		}
		if(sistemaOS.getTamanhoPF()==null) {
			throw new Exception("Tamanho Funcional é um campo obrigatório.");
		}
		if(sistemaOS.getCoberturaTeste()==null) {
			throw new Exception("Cobertura de Teste é um campo obrigatório.");
		}
		if(sistemaOS.getPercentualDisponibilidade()==null) {
			throw new Exception("Percentual de Disponibilidade é um campo obrigatório.");
		}
		if(sistemaOS.getQtdhoraSustentada()==null) {
			throw new Exception("Qtd Hora Sustentada é um campo obrigatório.");
		}
		if(sistemaOS.getFatorPFS()==null) {
			throw new Exception("Fator PFS é um campo obrigatório.");
		}
		if(sistemaOS.getQtdPFS()==null) {
			throw new Exception("Qtd PFS é um campo obrigatório.");
		}
		if(sistemaOS.getValorUnitarioPFS()==null) {
			throw new Exception("Valor unitário PFS é um campo obrigatório.");
		}
		try {
			sistemaOSDao.inserir(sistemaOS);
		}catch(Exception e) {
			throw new Exception("Erro ao inserir no banco de dados.");
		}
	}
	
	public List<SistemaOS> selectAll() throws Exception {
		try {
			return sistemaOSDao.selectAll();
		}catch(Exception e) {
			throw new Exception("Erro ao buscar no banco de dados.");
		}
	}
	
	public List<SistemaOS> selectSistemasAtivosDasOSAtivas() throws Exception {
		try {
			return sistemaOSDao.selectSistemasAtivosDasOSAtivas();
		}catch(Exception e) {
			throw new Exception("Erro ao buscar no banco de dados.");
		}
	}

}
