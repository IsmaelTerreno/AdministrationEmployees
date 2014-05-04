package com.cit.summamos.service;

import java.util.List;

import com.cit.summamos.model.Empleado;

public interface EmpleadoManager {
	void save(Empleado empleado);
	List<Empleado> findAll();
	Empleado findById(String id);
	double averageAge();
}
