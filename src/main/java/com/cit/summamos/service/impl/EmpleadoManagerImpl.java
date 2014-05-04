package com.cit.summamos.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cit.summamos.model.Empleado;
import com.cit.summamos.repository.EmpleadoRepository;
import com.cit.summamos.repository.EmpresaRepository;
import com.cit.summamos.service.EmpleadoManager;
@Service
public class EmpleadoManagerImpl implements EmpleadoManager {
	/**
	 * Reference to the DAO object.
	 */
	@Autowired
    private EmpleadoRepository repository;
	/**
	 * Reference to the DAO object.
	 */
	@Autowired
    private EmpresaRepository repositoryEmpresa;
	/**
	 * Save one employee.
	 */
	@Override
	public void save(Empleado empleado) {
		repository.save(empleado);
	}
	/**
	 * Find all the employees.
	 * @return All the employees.
	 */
	@Override
	public List<Empleado> findAll() {
		return repository.findAll();
	}
	/**
	 * Find one employee by id.
	 * @return The found employee.
	 */
	@Override
	public Empleado findById(String id) {
		return repository.findById(id);
	}
	/**
	 * Calculates the average age from the employees.
	 * @return The average ages.
	 */
	@Override
	public double averageAge() {
		int totalages = 0;
		double averageAge = 0;
		// Find the currents employees.
		List<Empleado> allEmployees = repository.findAll();
		// Accumulates the ages.
		for (Empleado temp : allEmployees) {
			totalages += temp.getEdad();
		}
		// if whe has employees to process.
		if (allEmployees.size() > 0){
			// Calculates the average.
			averageAge = totalages/allEmployees.size();
		}
		return averageAge;
	}
}

