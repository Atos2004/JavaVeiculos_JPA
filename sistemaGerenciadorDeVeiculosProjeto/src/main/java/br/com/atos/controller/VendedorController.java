package br.com.atos.controller;

import java.util.List;

import br.com.atos.controller.request.VendedorRequest;
import br.com.atos.controller.response.ListarVendedorResponse;
import br.com.atos.service.VendedorService;

public class VendedorController {
	
private final VendedorService vendedorService;
	
	public VendedorController(VendedorService clienteService) {
		this.vendedorService = clienteService;
	}
	
	public void cadastrarVendedor(VendedorRequest vendedorRequest) {
		vendedorService.salvarVendedor(vendedorRequest);
	}
	
	public List<ListarVendedorResponse> listarCpf(){
		return vendedorService.listarPorCpf();
	}
	
	public void deletarVendedor(long idVendedor) {
		vendedorService.deletarVendedor(idVendedor);
	}

}
