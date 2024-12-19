package br.com.atos.repository;

import br.com.atos.entity.VendaEntity;

public interface IVendaRepository {
	
	public VendaEntity findById(long idVenda);
	
	public void save(VendaEntity venda);
	
	public void deleteById(long idVenda);

}
