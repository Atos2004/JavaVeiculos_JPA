package br.com.atos.service;

import java.util.List;

import br.com.atos.controller.request.LojaRequest;
import br.com.atos.controller.response.ListarLojaResponse;

public interface LojaService {
	
	void salvarLoja(LojaRequest request);
	
	List<ListarLojaResponse> listarTodas();
	
	void deletarLoja(long idLoja);

}
