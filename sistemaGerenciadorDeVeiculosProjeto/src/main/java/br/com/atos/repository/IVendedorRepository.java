package br.com.atos.repository;

import java.util.List;

import br.com.atos.entity.VendedorEntity;

public interface IVendedorRepository {
	
	
	public VendedorEntity findById(long idVendedor);
	
	public List<VendedorEntity> findByCpf(String cpf);
	
	public void save(VendedorEntity vendedor);
	
	public void deleteById (long idVendedor);
	
}
