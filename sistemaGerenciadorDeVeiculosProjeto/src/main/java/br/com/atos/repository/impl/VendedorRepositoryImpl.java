package br.com.atos.repository.impl;

import java.util.List;

import br.com.atos.entity.VendedorEntity;
import br.com.atos.repository.IVendedorRepository;
import br.com.atos.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class VendedorRepositoryImpl implements IVendedorRepository{

private EntityManager entityManager = JPAUtil.getEntityManager();
	
	@Override
	public VendedorEntity findById(long idVendedor) {
		ensureEntityManagerIsOpen();
		return entityManager.find(VendedorEntity.class, idVendedor);
	}

	@Override
	public List<VendedorEntity> findByCpf(String cpf) {
		ensureEntityManagerIsOpen();
		return entityManager.createQuery("SELECT v FROM VendedorEntity v WHERE v.cpf = :cpf", VendedorEntity.class)
				.setParameter("cpf",cpf)
				.getResultList();
	}

	@Override
	public void save(VendedorEntity vendedor) {
		entityManager.getTransaction().begin();
		if(vendedor == null) {
			entityManager.persist(vendedor);
		} else {
			entityManager.merge(vendedor);
		}
		entityManager.getTransaction().commit();
	}

	@Override
	public void deleteById(long idVendedor) {
		ensureEntityManagerIsOpen();
		VendedorEntity vendedor = findById(idVendedor);
		if (vendedor != null) {
			entityManager.getTransaction().begin();
			entityManager.remove(vendedor);
			entityManager.getTransaction().commit();
		}
	}
	
	private void ensureEntityManagerIsOpen() {
		if(entityManager.isOpen()) {
			entityManager = JPAUtil.getEntityManager();
		}
	}

}
