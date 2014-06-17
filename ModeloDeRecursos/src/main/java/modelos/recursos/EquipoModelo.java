package modelos.recursos;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * clase que modela una entidad equipo, 
 * anotada para soporte de conversion a formato xml
 * @author maupaz92
 *
 */
@XmlRootElement
public class EquipoModelo{
		
	private Integer id_Equipo;	
	private String nombre;
	private PaisModelo pais;
	private Boolean tipoClub;
	
	public EquipoModelo(){
		id_Equipo = -1;
		nombre = "";
		tipoClub = false;
		pais = new PaisModelo();
	}
	
	public EquipoModelo(EquipoModelo equipo){
		id_Equipo = equipo.getId_Equipo();
		nombre = equipo.getNombre();
		pais = new PaisModelo(equipo.getPais());
		tipoClub = equipo.isTipoClub();
	}

	
	@Override
	public String toString() {	
		return "equipo: "+nombre+" id: "+id_Equipo+" es de clubes: "+tipoClub+" "+pais.toString();
	}
	
	
	//----------getters & setters
	
	@XmlAttribute
	public int getId_Equipo() {
		return id_Equipo;
	}


	public void setId_Equipo(int id_Equipo) {
		this.id_Equipo = id_Equipo;
	}	

	@XmlAttribute
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@XmlElement
	public PaisModelo getPais() {
		return pais;
	}

	public void setPais(PaisModelo pais) {
		this.pais = pais;
	}

	@XmlElement
	public Boolean isTipoClub() {
		return tipoClub;
	}

	public void setTipoClub(Boolean tipoClub) {
		this.tipoClub = tipoClub;
	}
	
	
	
}