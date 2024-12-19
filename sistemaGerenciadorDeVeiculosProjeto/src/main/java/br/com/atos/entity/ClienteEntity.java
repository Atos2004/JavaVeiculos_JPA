package br.com.atos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class ClienteEntity extends Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCliente;
	
	public ClienteEntity() {
		
	}
	
	public ClienteEntity(String nome, String cpf, String endereco, String telefone) {
        super(nome, cpf, endereco, telefone); 
    }

	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}
	
	

}
