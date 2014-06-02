package com.MH.Modelo;

import java.sql.Date;

/**
 * Clase que modela una entidad Administrador 
 * con sus respectivos atributos y métodos de acceso. 
 * @author DiegoJ
 **/

public class Administrador {
	
	//Atributos 
	
	private int id_Administrador;
	private String nombre_Administrador;
	private String apellido_Administrador;
	private String nombreUsuario;
	private String email_Administrador;
	private String password_Administrador;
	private Date fecha_Inscripcion;
	private Date fecha_Nacimiento;
	
	//Constructor
	
	public Administrador(){}
	
	//----------getters & setters
	
	public int getId_Administrador() {
		return id_Administrador;
	}

	public void setId_Administrador(int id_Administrador) {
		this.id_Administrador = id_Administrador;
	}

	public String getNombre_Administrador() {
		return nombre_Administrador;
	}

	public void setNombre_Administrador(String nombre_Administrador) {
		this.nombre_Administrador = nombre_Administrador;
	}

	public String getApellido_Administrador() {
		return apellido_Administrador;
	}

	public void setApellido_Administrador(String apellido_Administrador) {
		this.apellido_Administrador = apellido_Administrador;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getEmail_Administrador() {
		return email_Administrador;
	}

	public void setEmail_Administrador(String email_Administrador) {
		this.email_Administrador = email_Administrador;
	}

	public String getPassword_Administrador() {
		return password_Administrador;
	}

	public void setPassword_Administrador(String password_Administrador) {
		this.password_Administrador = password_Administrador;
	}

	public Date getFecha_Inscripcion() {
		return fecha_Inscripcion;
	}

	public void setFecha_Inscripcion(Date fecha_Inscripcion) {
		this.fecha_Inscripcion = fecha_Inscripcion;
	}

	public Date getFecha_Nacimiento() {
		return fecha_Nacimiento;
	}

	public void setFecha_Nacimiento(Date fecha_Nacimiento) {
		this.fecha_Nacimiento = fecha_Nacimiento;
	}

	
	
	
	

}
