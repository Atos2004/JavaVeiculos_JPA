package br.com.atos.controller.request;

import jakarta.validation.constraints.NotBlank;

public class PessoaRequest {

	@NotBlank(message = "O nome é obrigatório")
	private String nome;

	@NotBlank(message = "O cpf é obrigatório")
	private String cpf;

	@NotBlank(message = "O endereço é obrigatório")
	private String endereco;

	@NotBlank(message = "O telefone é obrigatório")
	private String telefone;

	public PessoaRequest(String nome, String cpf, String endereco, String telefone) {

		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
