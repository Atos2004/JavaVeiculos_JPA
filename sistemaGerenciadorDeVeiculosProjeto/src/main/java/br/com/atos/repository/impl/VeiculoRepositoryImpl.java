package br.com.atos.repository.impl;

import java.util.List;

import br.com.atos.entity.VeiculoEntity;
import br.com.atos.repository.IVeiculoRepository;
import br.com.atos.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class VeiculoRepositoryImpl implements IVeiculoRepository {

    private EntityManager entityManager = JPAUtil.getEntityManager();

    @Override
    public List<VeiculoEntity> findAll() {
        ensureEntityManagerIsOpen();
        return entityManager.createQuery("SELECT v FROM VeiculoEntity v", VeiculoEntity.class)
                            .getResultList();
    }

    @Override
    public List<VeiculoEntity> findByMarca(String marca) {
        ensureEntityManagerIsOpen();
        return entityManager.createQuery("SELECT v FROM VeiculoEntity v WHERE v.marca = :marca", VeiculoEntity.class)
                            .setParameter("marca", marca)
                            .getResultList();
    }

    @Override
    public List<VeiculoEntity> findByModelo(String modelo) {
        ensureEntityManagerIsOpen();
        return entityManager.createQuery("SELECT v FROM VeiculoEntity v WHERE v.modelo = :modelo", VeiculoEntity.class)
                            .setParameter("modelo", modelo)
                            .getResultList();
    }

    @Override
    public List<VeiculoEntity> findByAno(int ano) {
        ensureEntityManagerIsOpen();
        return entityManager.createQuery("SELECT v FROM VeiculoEntity v WHERE v.ano = :ano", VeiculoEntity.class)
                            .setParameter("ano", ano)
                            .getResultList();
    }

    @Override
    public List<VeiculoEntity> findByPlaca(String placa) {
        ensureEntityManagerIsOpen();
        return entityManager.createQuery("SELECT v FROM VeiculoEntity v WHERE v.placa = :placa", VeiculoEntity.class)
                            .setParameter("placa", placa)
                            .getResultList();
    }

    @Override
    public VeiculoEntity findById(long id) {
        ensureEntityManagerIsOpen();
        return entityManager.find(VeiculoEntity.class, id);
    }

    @Override
    public void save(VeiculoEntity veiculo) {
        ensureEntityManagerIsOpen();
        entityManager.getTransaction().begin();
        if (veiculo.getId() == 0) {
            entityManager.persist(veiculo);
        } else {
            entityManager.merge(veiculo);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteById(long id) {
        ensureEntityManagerIsOpen();
        VeiculoEntity veiculo = findById(id);
        if (veiculo != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(veiculo);
            entityManager.getTransaction().commit();
        }
    }

    public void close() {
        if (entityManager.isOpen()) {
            entityManager.close();
        }
    }

    private void ensureEntityManagerIsOpen() {
        if (!entityManager.isOpen()) {
            entityManager = JPAUtil.getEntityManager();
        }
    }
}

