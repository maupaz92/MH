package servicio.accesos;

import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.internal.txw2.annotation.XmlElement;

@XmlRootElement
public class Perro {

	private Integer edad_Perro;
	private Integer pesoPerro;
	
	public Perro(){
		
	}
	@XmlElement
	public Integer getPesoPerro() {
		return pesoPerro;
	}

	public void setPesoPerro(Integer peso_Perro) {
		this.pesoPerro = peso_Perro;
	}
	@XmlElement
	public Integer getEdad_Perro() {
		return edad_Perro;
	}

	public void setEdad_Perro(Integer edad_Perro) {
		this.edad_Perro = edad_Perro;
	}
	

	

	
}
