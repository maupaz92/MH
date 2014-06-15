package modelos.recursos;



import java.io.Serializable;
import java.sql.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * clase que modela una entidad jugador, 
 * anotada para soporte de conversion a formato xml
 * @author maupaz92
 *
 */
@XmlRootElement
public class JugadorModelo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5095105324317248308L;
	private int pasaporte;
	private String nombre;
	private Boolean estado;
	private EquipoModelo equipoActual;
	private String posicion;
	private Double altura;
	private Double peso;
	private Date fechaNacimiento;
	private PaisModelo pais;
	
	
	public JugadorModelo(){}

	
	//----------getters & setters
	@XmlAttribute
	public int getPasaporte() {
		return pasaporte;
	}

	public void setPasaporte(int pasaporte) {
		this.pasaporte = pasaporte;
	}

	@XmlElement
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@XmlElement
	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	@XmlElement
	public EquipoModelo getEquipoActual() {
		return equipoActual;
	}

	public void setEquipoActual(EquipoModelo equipoActual) {
		this.equipoActual = equipoActual;
	}

	@XmlElement
	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	@XmlElement
	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	@XmlElement
	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	@XmlElement
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public PaisModelo getPais() {
		return pais;
	}


	public void setPais(PaisModelo pais) {
		this.pais = pais;
	}

}

	
	
	

