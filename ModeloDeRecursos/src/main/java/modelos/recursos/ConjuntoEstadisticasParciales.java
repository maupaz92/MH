package modelos.recursos;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class ConjuntoEstadisticasParciales {

	
	private List<EstadisticaParcial> listaEstadisticas;
	private int identificadorPartido;
	
	public ConjuntoEstadisticasParciales(){
		listaEstadisticas = new ArrayList<EstadisticaParcial>();				
	}
	
	public void agregarEstadisticas(EstadisticaParcial estadistica){
		listaEstadisticas.add(estadistica);
	}

	@XmlElement(name = "estadisticas")
	public List<EstadisticaParcial> getListaEstadisticas() {
		return listaEstadisticas;
	}


	public void setListaEstadisticas(List<EstadisticaParcial> listaEstadisticas) {
		this.listaEstadisticas = listaEstadisticas;
	}

	public int getIdentificadorPartido() {
		return identificadorPartido;
	}

	public void setIdentificadorPartido(int identificadorPartido) {
		this.identificadorPartido = identificadorPartido;
	}
	
	
	
	
}
