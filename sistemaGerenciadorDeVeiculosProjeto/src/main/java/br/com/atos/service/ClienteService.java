package br.com.atos.service;

import java.util.List;

import br.com.atos.controller.request.ClienteRequest;
import br.com.atos.controller.response.ListarClienteResponse;

public interface ClienteService {
	
	void salvarCliente(ClienteRequest request);
	
	List<ListarClienteResponse> listarPorCpf();
	
	void deletarCliente(long idCliente);

}
