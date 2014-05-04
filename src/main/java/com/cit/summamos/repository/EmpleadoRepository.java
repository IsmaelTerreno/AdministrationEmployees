package com.cit.summamos.repository;

import java.util.List;

import com.cit.summamos.model.Empleado;

public interface EmpleadoRepository {
	public void save(Empleado empleado);
	public List<Empleado> findAll();
	public Empleado findById(String id);
}
