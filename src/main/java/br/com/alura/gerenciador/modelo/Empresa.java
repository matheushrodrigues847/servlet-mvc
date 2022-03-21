package br.com.alura.gerenciador.modelo;

import java.util.Date;

public class Empresa {
	
	private Integer id;
	private String nome;
	private String cnpj;
	private Date dataAbertura = new Date();
	
	public Empresa(String nome, String cnpj) {
		this.nome = nome;
		this.cnpj = cnpj;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	
	public String getNome() {
		return nome;
	}
	
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	@Override
	public String toString() {
		return "Empresa{ id: "+ id +" \nnome:"+ nome+ "\ncnpj:"+cnpj+"}";
	}

}
