package com.cit.summamos.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cit.summamos.model.Empleado;
import com.cit.summamos.repository.EmpleadoRepository;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

@Repository(value = "empleadoDao")
public class EmpleadoRepositoryImpl implements EmpleadoRepository {
	private EntityManager entityManager = null;
	/*
     * Sets the entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    @Transactional(readOnly = false)
    public void save(Empleado empleado) {
    	entityManager.persist(empleado);
    }
	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> findAll() {
		return entityManager.createQuery("select e from Empleado e order by e.nombre").getResultList();
	}
	/**
	 *  Finds a Empleado entity by id.
	 */
	@Override
	public Empleado findById(String id) {
		return entityManager.find(Empleado.class, id);
	}
    
}
