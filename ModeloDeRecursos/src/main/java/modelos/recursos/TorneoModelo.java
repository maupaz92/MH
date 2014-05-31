package modelos.recursos;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TorneoModelo {

	private String nombre;
	private String tipo;
	private String sede;
	private Boolean copa;
	
	public TorneoModelo(){
	}
	@XmlAttribute
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@XmlElement
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@XmlElement
	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	@XmlElement
	public Boolean isCopa() {
		return copa;
	}

	public void setCopa(Boolean copa) {
		this.copa = copa;
	}
	
	
	
	
}
