package modelos.recursos;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * clase encargada de proveer un modelo de acceso para un conjunto de 
 * torneos. Esta anotada de manera que retornara un xml o json con la estructura:
 * 
 * <torneos>
 * 	<torneo>
 *   ...
 * 	</torneo>
 *  <torneo>
 *   ...
 * 	</torneo>
 *  <torneo>
 *   ...
 * 	</torneo>
 * </torneos>
 * 
 * @author maupaz92
 *
 */
@XmlRootElement(name = "torneos")
public class ConjuntoDeTorneosModelo {

	
	private List<TorneoModelo> listaTorneos;

	//----constructors
	public ConjuntoDeTorneosModelo()
	{
		listaTorneos = new ArrayList<TorneoModelo>();
	}
	
	
	/**
	 * Agrega un nuevo objeto torneo tipo "TorneoModelo" al 
	 * conjunto de torneos
	 * @param torneo: objeto tipo "TorneoModelo" por agregar
	 */
	public void agregarTorneo(TorneoModelo torneo)
	{
		this.listaTorneos.add(torneo);
	}
	
	
	//----getters & setters
	@XmlElement(name = "records")
	public List<TorneoModelo> getListaTorneos() {
		return listaTorneos;
	}
	
	public void setListaTorneos(List<TorneoModelo> listaTorneos) {
		this.listaTorneos = listaTorneos;
	}
	
}
