package br.com.atos.service;

import java.util.List;
import br.com.atos.controller.request.VendedorRequest;
import br.com.atos.controller.response.ListarVendedorResponse;

public interface VendedorService {
	
	void salvarVendedor(VendedorRequest request);
	
	List<ListarVendedorResponse> listarPorCpf();
	
	void deletarVendedor(long idVendedor);

}
