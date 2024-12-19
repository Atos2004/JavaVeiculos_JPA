package br.com.atos.repository;

import java.util.List;

import br.com.atos.entity.LojaEntity;


public interface ILojaRepository {
	
	public List<LojaEntity> findAll();
	
	public LojaEntity findById(long idLoja);
	
	public List<LojaEntity> findByNomeLoja(String nomeLoja);
	
	public List<LojaEntity> findByEnderecoLoja(String enderecoLoja);
	
	public List<LojaEntity> findByTelefoneLoja(String telefoneLoja);
	
	public void save(LojaEntity loja);
	
	public void deleteById(long idLoja);

}
