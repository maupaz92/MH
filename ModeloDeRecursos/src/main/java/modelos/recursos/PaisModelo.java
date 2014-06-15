package modelos.recursos;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PaisModelo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1097810009845723069L;
	private Integer id_Pais;
	private String nombre;
	
	public PaisModelo(){}
	
	
	@Override
	public String toString() {	
		return "pais: "+nombre+" id: "+id_Pais;
	}
	
	//getters & setters
	
	@XmlAttribute
	public int getId_Pais() {
		return id_Pais;
	}

	public void setId_Pais(int id_Pais) {
		this.id_Pais = id_Pais;
	}

	@XmlAttribute
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
