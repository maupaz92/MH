package modelos.recursos;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "equipos")
public class ConjuntoDeEquiposModelo {

	private List<EquipoModelo> listaEquipos;
	
	public ConjuntoDeEquiposModelo(){
		listaEquipos = new ArrayList<EquipoModelo>();
	}
	
	public void agregarEquipo(EquipoModelo equipo){
		this.listaEquipos.add(equipo);
	}

	@XmlElement(name = "equipos")
	public List<EquipoModelo> getListaEquipos() {
		return listaEquipos;
	}

	public void setListaEquipos(List<EquipoModelo> listaEquipos) {
		this.listaEquipos = listaEquipos;
	}
	
	
	
}
