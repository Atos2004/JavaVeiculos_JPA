package br.com.atos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vendedor")
public class VendedorEntity extends Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idVendedor;
	
	public VendedorEntity() {
		
	}
	
	public VendedorEntity(String nome, String cpf, String endereco, String telefone) {
		super(nome, cpf, endereco, telefone);
	}

	public long getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(long idVendedor) {
		this.idVendedor = idVendedor;
	}
	
	
	
}
