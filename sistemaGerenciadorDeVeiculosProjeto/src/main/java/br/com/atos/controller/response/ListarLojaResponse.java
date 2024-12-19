package br.com.atos.controller.response;

public class ListarLojaResponse {
	
	private String nomeLoja;
	private String enderecoLoja;
	private String telefoneLoja;
	
	public ListarLojaResponse(String nomeLoja, String enderecoLoja, String telefoneLoja) {
		this.nomeLoja = nomeLoja;
		this.enderecoLoja = enderecoLoja;
		this.telefoneLoja = telefoneLoja;
	}

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
