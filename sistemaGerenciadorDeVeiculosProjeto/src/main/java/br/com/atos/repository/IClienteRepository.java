package br.com.atos.repository;

import java.util.List;

import br.com.atos.entity.ClienteEntity;


public interface IClienteRepository {
	
	
	public ClienteEntity findById(long idCliente);
	
	public List<ClienteEntity> findByCpf(String cpf);
	
	public void save(ClienteEntity cliente);
	
	public void deleteById (long idCliente);
	

}
