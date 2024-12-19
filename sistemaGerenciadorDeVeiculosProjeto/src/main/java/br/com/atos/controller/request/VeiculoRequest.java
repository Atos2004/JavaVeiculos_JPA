package br.com.atos.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class VeiculoRequest {
	
	
	@NotBlank(message = "A marca do veículo é obrigatória")
	@Size(max = 50, message = "A marca não pode exceder 50 caracteres.")
	private String marca;
	
	@NotBlank(message = "O modelo do veículo é obrigatória")
	@Size(max = 50, message = "O modelo não pode exceder 50 caracteres.")
	private String modelo;
	
	@NotNull(message = "O ano do veículo é obrigatório.")
	@Positive
	private int ano;
	
	@NotBlank(message = "A placa do veículo é obrigatória.")
    @Size(max = 10)
    private String placa;
	
	@NotNull(message = "O preço do veículo é obrigatório.")
	private double preco;
	

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

}
