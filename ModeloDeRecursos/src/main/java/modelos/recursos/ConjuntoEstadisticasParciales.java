package modelos.recursos;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class ConjuntoEstadisticasParciales {

	
	private List<EstadisticaParcial> listaEstadisticas;
	private int identificadorPartido;
	private boolean deSeleccion;
	
	
	public ConjuntoEstadisticasParciales(){
		listaEstadisticas = new ArrayList<EstadisticaParcial>();				
	}
	
	/**
	 * 
	 * @param estadistica
	 */
	public void agregarEstadisticas(EstadisticaParcial estadistica){
		listaEstadisticas.add(estadistica);
	}

	//getters & setters
	
	@XmlElement
	public List<EstadisticaParcial> getListaEstadisticas() {
		return listaEstadisticas;
	}


	public void setListaEstadisticas(List<EstadisticaParcial> listaEstadisticas) {
		this.listaEstadisticas = listaEstadisticas;
	}
	@XmlElement
	public int getIdentificadorPartido() {
		return identificadorPartido;
	}

	public void setIdentificadorPartido(int identificadorPartido) {
		this.identificadorPartido = identificadorPartido;
	}
	@XmlElement
	public boolean isDeSeleccion() {
		return deSeleccion;
	}

	public void setDeSeleccion(boolean deSeleccion) {
		this.deSeleccion = deSeleccion;
	}
	
	
	
	
}
