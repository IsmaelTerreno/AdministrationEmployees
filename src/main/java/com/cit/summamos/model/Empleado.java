package com.cit.summamos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

/**
 * The main Empleado entity.
 * @author Ismael Terreno
 * @see com.cit.networkproperties.repository.UserRepository
 */
@Entity
@Table(name="empleados")
public class Empleado {
	/**
	 * Id of the entity, this use the Hibernate uuid2 generator for Id fields.
	 */
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "id", unique = true, length = 36, nullable = false, columnDefinition = "char(36)")
    private String id;
	/**
	 * Employee name.
	 */
	@Column(name = "nombre" , length = 64, columnDefinition = "varchar(64)")
    private String nombre;
	/**
	 * Employee last name.
	 */
	@Column(name = "apellido" , length = 64, columnDefinition = "varchar(64)")
    private String apellido;
	/**
	 * Employee age.
	 */
	@Column(name = "edad" , length = 3, columnDefinition = "tinyint(3)")
    private int edad;
	/**
	 * Employee job.
	 * Must be programmer or designer. 
	 */
	@Column(name = "job" , length = 120, columnDefinition = "varchar(120)")
    private String job;
	/**
	 * Employee aptitude.
	 * Must be PHP,PYTHON,WEB or GRAPHIC.
	 */
	@Column(name = "aptitud" , length = 60, columnDefinition = "varchar(60)")
    private String aptitud;
	
	@Transient
	private String empresarelated;
	
	/**
	 * Many-to-one association to empresa.
	 */
	@ManyToOne
	@JoinColumn(name = "empresa_id", columnDefinition = "char(36)")
    private Empresa empresa;
	
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public String getEmpresarelated() {
		return empresarelated;
	}
	public void setEmpresarelated(String empresarelated) {
		this.empresarelated = empresarelated;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getAptitud() {
		return aptitud;
	}
	public void setAptitud(String aptitude) {
		this.aptitud = aptitude;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
