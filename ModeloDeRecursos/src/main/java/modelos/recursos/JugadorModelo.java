package modelos.recursos;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class JugadorModelo {

	private String pasaporte;
	private String nombre;
	private Boolean estado;
	private EquipoModelo equipoActual;
	private String posicion;
	private Float altura;
	private Float peso;
	private String fechaNacimiento;
			
	public JugadorModelo(){}

	@XmlAttribute
	public String getPasaporte() {
		return pasaporte;
	}

	public void setPasaporte(String pasaporte) {
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
	public Float getAltura() {
		return altura;
	}

	public void setAltura(Float altura) {
		this.altura = altura;
	}

	@XmlElement
	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	@XmlElement
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	
	
	
	
}
