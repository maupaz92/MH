package modelos.recursos;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * clase que modela una entidad torneo, 
 * anotada para soporte de conversion a formato xml
 * @author maupaz92
 *
 */
@XmlRootElement(name = "torneo")
public class TorneoModelo {

	private int id;
	private String nombre;
	private Boolean tipoSelecciones;
	private String sede;
	private Boolean copa;
	
	public TorneoModelo(){
		this.id = -1;
		this.nombre = "";
		this.tipoSelecciones = true;
		this.sede = "";
		this.copa = true;
	}
		
	
	//----------getters & setters
	
	@XmlAttribute
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@XmlAttribute
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	@XmlElement
	public Boolean getTipoSelecciones() {
		return tipoSelecciones;
	}

	public void setTipoSelecciones(Boolean tipoSelecciones) {
		this.tipoSelecciones = tipoSelecciones;
	}
	
	@Override
	public String toString()
	{
		return nombre+" sede en: "+sede+" tipo selecciones: "+tipoSelecciones+" es de copa: "+copa ;
	}	

	/**
	 * metodo que reemplaza los datos actuales del torneo por
	 * los datos del torneo que entra como parametro.
	 * @param torneo
	 */
	public void reemplazarDatos(TorneoModelo torneo){
		this.nombre = torneo.nombre;
		this.sede = torneo.sede;
		this.copa = torneo.copa;
		this.tipoSelecciones = torneo.tipoSelecciones;				
	}
	
	/**
	 * metodo que inicializa los datos del torneo como recien creado, predeterminadamente
	 * nombre = ""
	 * id = -1
	 * tipo = true
	 * sede = ""
	 * copa = true
	 */
	public void limpiarDatos(){
		this.setNombre("");
		this.setId(-1);
		this.setCopa(true);
		this.setSede("");
		this.setCopa(true);
	}
	
	
}
