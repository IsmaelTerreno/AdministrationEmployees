package com.cit.summamos.repository;

import java.util.List;

import com.cit.summamos.model.Empresa;

public interface EmpresaRepository{
	void save(Empresa empresa);
	List<Empresa> findAll();
}
