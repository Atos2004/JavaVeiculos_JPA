package br.com.atos.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Loja")
public class LojaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idLoja;
	
	@Column(nullable = false)
	private String nomeLoja;
	
	@Column(nullable = false)
	private String enderecoLoja;
	
	@Column(nullable = false)
	private String telefoneLoja;
	
	public long getIdLoja() {
		return idLoja;
	}
	
	public void setIdLoja(long idLoja) {
		this.idLoja = idLoja;
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
