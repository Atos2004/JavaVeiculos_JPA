package br.com.atos.controller.request;

import jakarta.validation.constraints.NotBlank;

public class LojaRequest {
	
	@NotBlank(message = "O nome da loja é obrigatório")
	private String nomeLoja;
	
	@NotBlank(message = "O endereço da loja é obrigatório")
	private String enderecoLoja;
	
	@NotBlank(message = "O endereço da loja é obrigatório")
	private String telefoneLoja;

	public String getNomeLoja() {
		return nomeLoja;
	}

	public void setNomeLoja(String nomeLoja) {
		this.nomeLoja = nomeLoja;
	}

	public String getEnderecoLoja() {
		return enderecoLoja;
	}

	public void setEnderecoLoja(String enderecoLoja) {
		this.enderecoLoja = enderecoLoja;
	}

	public String getTelefoneLoja() {
		return telefoneLoja;
	}

	public void setTelefoneLoja(String telefoneLoja) {
		this.telefoneLoja = telefoneLoja;
	}


}
