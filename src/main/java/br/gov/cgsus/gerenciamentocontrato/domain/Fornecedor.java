package br.gov.cgsus.gerenciamentocontrato.domain;

import java.io.Serializable;
import java.text.ParseException;

import javax.swing.text.MaskFormatter;

public class Fornecedor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String razaoSocial;

	private String nomeFantasia;

	private String cnpj;

	public Fornecedor() {

	}

	public Fornecedor(String razaoSocial, String nomeFantasia, String cnpj) {
		super();
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getCnpjFormatado() {
		MaskFormatter mf;
		try {
			mf = new MaskFormatter("##.###.###/####-##");
			mf.setValueContainsLiteralCharacters(false);
			return mf.valueToString(cnpj);
		} catch (ParseException e) {
			return cnpj;
		}
	}
	
	public static void main(String[] args) {
		Fornecedor a = new Fornecedor();
		a.setCnpj("123456789152");
		a.getCnpjFormatado();
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
