package modelos.recursos;

import java.util.Date;


public class AdministradorPerfilModelo {

	private int id_Administrador;	
	private AdministradorModelo administrador;
	private String nombre;
	private String apellido;
	private String email;
	private Date fechaInscripcion;
	private Date fechaNacimiento;
	
	
	public int getId_Administrador() {
		return id_Administrador;
	}
	public void setId_Administrador(int id_Administrador) {
		this.id_Administrador = id_Administrador;
	}
	public AdministradorModelo getAdministrador() {
		return administrador;
	}
	public void setAdministrador(AdministradorModelo administrador) {
		this.administrador = administrador;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getFechaInscripcion() {
		return fechaInscripcion;
	}
	public void setFechaInscripcion(Date fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	
	
}
