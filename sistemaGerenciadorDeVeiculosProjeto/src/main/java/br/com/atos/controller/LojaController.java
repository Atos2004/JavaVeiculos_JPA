package br.com.atos.controller;

import java.util.List;

import br.com.atos.controller.request.LojaRequest;
import br.com.atos.service.LojaService;
import br.com.atos.controller.response.ListarLojaResponse;

public class LojaController {
	
	private final LojaService lojaService;
	
	public LojaController(LojaService lojaService) {
		this.lojaService = lojaService;
	}
	
	public void cadastrarLoja(LojaRequest lojaRequest) {
		lojaService.salvarLoja(lojaRequest);
	}
	
	public List<ListarLojaResponse> listarTodas(){
		return lojaService.listarTodas();
	}
	
	public void deletarVeiculo(long idLoja) {
		lojaService.deletarLoja(idLoja);
	}

}
