package br.com.atos.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "venda")
public class VendaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idVenda;
	
	@ManyToOne
	@JoinColumn(name = "idVeiculo", nullable = false)
	private VeiculoEntity veiculo;
	
	@ManyToOne
	@JoinColumn(name = "idVendedor", nullable = false)
	private VendedorEntity vendedor;
	
	@ManyToOne
	@JoinColumn(name = "idCliente", nullable = false)
	private ClienteEntity cliente;
	
	@Temporal(TemporalType.DATE)
	private Date data;
	
	public VendaEntity() {
		
	}

	public long getId() {
		return idVenda;
	}

	public VeiculoEntity getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(VeiculoEntity veiculo) {
		this.veiculo = veiculo;
	}

	public VendedorEntity getVendedor() {
		return vendedor;
	}

	public void setVendedor(VendedorEntity vendedor) {
		this.vendedor = vendedor;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
