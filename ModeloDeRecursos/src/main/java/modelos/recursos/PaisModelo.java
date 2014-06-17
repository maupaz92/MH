package modelos.recursos;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PaisModelo{
	
	private Integer id_Pais;
	private String nombre;
	
	public PaisModelo(){
		id_Pais = -1;
		nombre = "";
	}
	
	public PaisModelo(PaisModelo pais){
		id_Pais = pais.getId_Pais(); 
		nombre = pais.getNombre();
	}
	
	
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
