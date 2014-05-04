package com.cit.summamos.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cit.summamos.model.Empresa;
import com.cit.summamos.repository.EmpresaRepository;

@Repository(value = "EmpresaDAO")
public class EmpresaRepositoryImpl implements EmpresaRepository {
	private EntityManager entityManager = null;
	/*
     * Sets the entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void save(Empresa empresa) {
    	entityManager.merge(empresa);
    }

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Empresa> findAll() {
		return entityManager.createQuery("select e from Empresa e order by e.id").getResultList();
	}
}
