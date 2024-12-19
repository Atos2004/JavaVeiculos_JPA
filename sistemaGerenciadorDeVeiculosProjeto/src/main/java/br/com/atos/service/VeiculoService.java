package br.com.atos.service;

import java.util.List;

import br.com.atos.controller.request.VeiculoRequest;
import br.com.atos.controller.response.ListarVeiculoResponse;

public interface VeiculoService {

	void salvarVeiculo(VeiculoRequest request);
	
	List<ListarVeiculoResponse> buscarTodos();
	
	List<ListarVeiculoResponse> buscarPorPlaca();
	
	void deletarVeiculo(long id);
	
}
