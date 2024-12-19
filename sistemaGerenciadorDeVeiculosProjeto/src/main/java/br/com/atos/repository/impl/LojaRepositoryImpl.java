package br.com.atos.repository.impl;

import java.util.List;

import br.com.atos.entity.LojaEntity;
import br.com.atos.repository.ILojaRepository;
import br.com.atos.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class LojaRepositoryImpl implements ILojaRepository {

	private EntityManager entityManager = JPAUtil.getEntityManager();
	
	@Override
	public List<LojaEntity> findAll() {
		ensureEntityManagerIsOpen();
		return entityManager.createQuery("SELECT l FROM LojaEntity l", LojaEntity.class)
				.getResultList();
	}

	@Override
	public List<LojaEntity> findByNomeLoja(String nomeLoja) {
		ensureEntityManagerIsOpen();
		return entityManager.createQuery("SELECT l FORM LojaEntity l WHERE l.nomeLoja = :nomeLoja", LojaEntity.class)
				.setParameter("nomeLoja",nomeLoja)
				.getResultList();
	}

	@Override
	public List<LojaEntity> findByEnderecoLoja(String enderecoLoja) {
		ensureEntityManagerIsOpen();
		return entityManager.createQuery("SELECT l FORM LojaEntity l WHERE l.enderecoLoja = :enderecoLoja", LojaEntity.class)
				.setParameter("enderecoLoja", enderecoLoja)
				.getResultList();
	}

	@Override
	public List<LojaEntity> findByTelefoneLoja(String telefoneLoja) {
		ensureEntityManagerIsOpen();
		return entityManager.createQuery("SELECT l FORM LojaEntity l WHERE l.telefonecoLoja = :telefoneLoja", LojaEntity.class)
				.setParameter("telefoneLoja", telefoneLoja)
				.getResultList();
	}
	
	@Override
	public LojaEntity findById(long idLoja) {
		ensureEntityManagerIsOpen();
		return entityManager.find(LojaEntity.class, idLoja);
	}
	

	@Override
	public void deleteById(long idLoja) {
		ensureEntityManagerIsOpen();
		LojaEntity loja = findById(idLoja);
		if(loja!=null) {
			entityManager.getTransaction().begin();
			entityManager.remove(loja);
			entityManager.getTransaction().commit();
		}
	}
	
	@Override
	public void save(LojaEntity loja) {
		entityManager.getTransaction().begin();
		if(loja.getIdLoja() == 0) {
			entityManager.persist(loja);
		} else {
			entityManager.merge(loja);
		}
			entityManager.getTransaction().commit();
	}
	
	private void ensureEntityManagerIsOpen() {
		if(entityManager.isOpen()) {
			entityManager = JPAUtil.getEntityManager();
		}
	}

	

}
