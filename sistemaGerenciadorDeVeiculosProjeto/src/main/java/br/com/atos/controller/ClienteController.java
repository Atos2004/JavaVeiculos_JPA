package br.com.atos.controller;

import java.util.List;

import br.com.atos.controller.request.ClienteRequest;
import br.com.atos.controller.response.ListarClienteResponse;
import br.com.atos.service.ClienteService;


public class ClienteController {
	
	private final ClienteService clienteService;
	
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	public void cadastrarCliente(ClienteRequest clienteRequest) {
		clienteService.salvarCliente(clienteRequest);
	}
	
	public List<ListarClienteResponse> listarCpf(){
		return clienteService.listarPorCpf();
	}
	
	public void deletarClente(long idCliente) {
		clienteService.deletarCliente(idCliente);
	}

}
