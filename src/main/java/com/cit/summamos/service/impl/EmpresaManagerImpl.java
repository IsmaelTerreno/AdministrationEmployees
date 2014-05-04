package com.cit.summamos.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cit.summamos.model.Empresa;
import com.cit.summamos.repository.EmpresaRepository;
import com.cit.summamos.service.EmpresaManager;
@Service
public class EmpresaManagerImpl implements EmpresaManager {
	/**
	 * Reference to the DAO object.
	 */
	@Autowired
    private EmpresaRepository repository;
	
	@Override
	@Transactional
	public Boolean save(Empresa empresa) {
		repository.save(empresa);
		return Boolean.TRUE;
	}

	@Override
	public List<Empresa> findAll() {
		return repository.findAll();
	}
	
}
