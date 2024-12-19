package br.com.atos.repository.impl;

import java.util.List;

import br.com.atos.entity.ClienteEntity;
import br.com.atos.repository.IClienteRepository;
import br.com.atos.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class ClienteRepositoryImpl implements IClienteRepository{

	private EntityManager entityManager = JPAUtil.getEntityManager();
	
	@Override
	public ClienteEntity findById(long idCliente) {
		ensureEntityManagerIsOpen();
		return entityManager.find(ClienteEntity.class, idCliente);
	}

	@Override
	public List<ClienteEntity> findByCpf(String cpf) {
		ensureEntityManagerIsOpen();
		return entityManager.createQuery("SELECT c FROM ClienteEntity c WHERE c.cpf = :cpf", ClienteEntity.class)
				.setParameter("cpf",cpf)
				.getResultList();
	}

	@Override
	public void save(ClienteEntity cliente) {
		entityManager.getTransaction().begin();
		if(cliente == null) {
			entityManager.persist(cliente);
		} else {
			entityManager.merge(cliente);
		}
		entityManager.getTransaction().commit();
	}

	@Override
	public void deleteById(long idCliente) {
		ensureEntityManagerIsOpen();
		ClienteEntity cliente = findById(idCliente);
		if (cliente != null) {
			entityManager.getTransaction().begin();
			entityManager.remove(cliente);
			entityManager.getTransaction().commit();
		}
	}
	
	private void ensureEntityManagerIsOpen() {
		if(entityManager.isOpen()) {
			entityManager = JPAUtil.getEntityManager();
		}
	}

}
