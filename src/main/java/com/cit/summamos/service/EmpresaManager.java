package com.cit.summamos.service;

import java.util.List;

import com.cit.summamos.model.Empresa;

public interface EmpresaManager {
	List<Empresa> findAll();
	Boolean save(Empresa empresa);
}
