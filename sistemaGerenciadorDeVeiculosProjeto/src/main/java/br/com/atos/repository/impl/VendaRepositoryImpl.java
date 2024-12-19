package br.com.atos.repository.impl;

import java.util.List;

import br.com.atos.entity.ClienteEntity;
import br.com.atos.entity.VendaEntity;
import br.com.atos.repository.IVendaRepository;
import br.com.atos.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class VendaRepositoryImpl implements IVendaRepository{

private EntityManager entityManager = JPAUtil.getEntityManager();
	
	@Override
	public VendaEntity findById(long idVenda) {
		ensureEntityManagerIsOpen();
		return entityManager.find(VendaEntity.class, idVenda);
	}
	
	public Long totalVendas() {
	    ensureEntityManagerIsOpen();
	    return entityManager.createQuery(
	            "SELECT COUNT(v) FROM VendaEntity v", Long.class)
	            .getSingleResult();
	}
	
	public Long totalClientesCompraram() {
	    ensureEntityManagerIsOpen();
	    return entityManager.createQuery(
	            "SELECT COUNT(DISTINCT v.cliente) FROM VendaEntity v", Long.class)
	            .getSingleResult();
	}
	
	public Long totalVendedores() {
	    ensureEntityManagerIsOpen();
	    return entityManager.createQuery(
	            "SELECT COUNT(DISTINCT v.vendedor) FROM VendaEntity v", Long.class)
	            .getSingleResult();
	}
	
	public Long totalVeiculos() {
	    ensureEntityManagerIsOpen();
	    return entityManager.createQuery(
	            "SELECT COUNT(DISTINCT v.veiculo) FROM VendaEntity v", Long.class)
	            .getSingleResult();
	}

	@Override
	public void save(VendaEntity venda) {
		entityManager.getTransaction().begin();
		if(venda == null) {
			entityManager.persist(venda);
		} else {
			entityManager.merge(venda);
		}
		entityManager.getTransaction().commit();
	}

	@Override
	public void deleteById(long idVenda) {
		ensureEntityManagerIsOpen();
		VendaEntity venda = findById(idVenda);
		if (venda != null) {
			entityManager.getTransaction().begin();
			entityManager.remove(venda);
			entityManager.getTransaction().commit();
		}
	}
	
	private void ensureEntityManagerIsOpen() {
		if(entityManager.isOpen()) {
			entityManager = JPAUtil.getEntityManager();
		}
	}

}

