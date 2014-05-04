package com.cit.summamos.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.cit.summamos.model.Empleado;

/**
 * The main Empresa entity.
 * @author Ismael Terreno
 */
@Entity
@Table(name="empresas")
public class Empresa {
	/**
	 * Id of the entity, this use the Hibernate uuid2 generator for Id fields.
	 */
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "id", unique = true, length = 36, nullable = false, columnDefinition = "char(36)")
    private String id;
	/**
	 * Company name.
	 */
	@Column(name = "nombre" , length = 64, columnDefinition = "varchar(64)")
    private String nombre;
	/**
	 * Constructor.
	 */
	public Empresa(){}
	// Getters and setters.
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}


	/**
	 * Many-to-one association to Empleado
	 */
	@OneToMany(cascade = {CascadeType.ALL},mappedBy="empresa")
	private List<Empleado> empleados;
	
	public List<Empleado> getEmpleados() {
		return empleados;
	}
	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}
	
}
