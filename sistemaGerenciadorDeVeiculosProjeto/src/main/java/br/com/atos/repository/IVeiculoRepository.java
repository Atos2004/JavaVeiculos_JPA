package br.com.atos.repository;

import java.util.List;

import br.com.atos.entity.VeiculoEntity;


public interface IVeiculoRepository {
	
	
	public List<VeiculoEntity> findAll();
	
	public VeiculoEntity findById(long id);
	
	public List<VeiculoEntity> findByMarca(String marca);
	
	public List<VeiculoEntity> findByModelo(String modelo);
	
	public List<VeiculoEntity> findByAno(int ano);
	
	public List<VeiculoEntity> findByPlaca(String placa);

	public void save(VeiculoEntity veiculo);
	
	public void deleteById(long id);
	

}
