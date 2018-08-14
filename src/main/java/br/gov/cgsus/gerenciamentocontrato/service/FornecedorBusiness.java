package br.gov.cgsus.gerenciamentocontrato.service;

import java.util.List;

import br.gov.cgsus.gerenciamentocontrato.dao.FornecedorDao;
import br.gov.cgsus.gerenciamentocontrato.domain.Fornecedor;

public class FornecedorBusiness {
	
	private FornecedorDao fornecedorDao = new FornecedorDao();
	
	public void inserir(Fornecedor fornecedor) throws Exception {
		if(fornecedor==null) {
			throw new Exception("Fornecedor nulo.");
		}
		if(fornecedor.getCnpj()==null || "".equalsIgnoreCase(fornecedor.getCnpj())) {
			throw new Exception("CNPJ é um campo obrigatório.");
		}
		if(fornecedor.getRazaoSocial()==null || "".equalsIgnoreCase(fornecedor.getRazaoSocial())) {
			throw new Exception("Razão Social é um campo obrigatório.");
		}
		if(fornecedor.getNomeFantasia()==null || "".equalsIgnoreCase(fornecedor.getNomeFantasia())) {
			throw new Exception("Nome Fantasia é um campo obrigatório.");
		}
		try {
			fornecedorDao.inserir(fornecedor);
		}catch(Exception e) {
			throw new Exception("Erro ao inserir no banco de dados.");
		}
	}
	
	public List<Fornecedor> selectAll() throws Exception {
		try {
			return fornecedorDao.selectAll();
		}catch(Exception e) {
			throw new Exception("Erro ao buscar no banco de dados.");
		}
	}

}
