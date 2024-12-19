package br.com.atos.controller;

import java.util.List;

import br.com.atos.controller.request.VeiculoRequest;
import br.com.atos.controller.response.ListarVeiculoResponse;
import br.com.atos.service.VeiculoService;

public class VeiculoController {

	private final VeiculoService veiculoService;
	
	public VeiculoController(VeiculoService veiculoService) {
		this.veiculoService = veiculoService;
	}
	
	public void cadastrarVeiculo(VeiculoRequest veiculoRequest) {
		veiculoService.salvarVeiculo(veiculoRequest);
	}
	
	public List<ListarVeiculoResponse> buscarTodosVeiculos(){
		return veiculoService.buscarTodos();
	}
	
	public List<ListarVeiculoResponse> buscarPorPlaca(){
		return veiculoService.buscarPorPlaca();
	}
	
	public void deletarVeiculo(long id) {
		veiculoService.deletarVeiculo(id);
	}
}
