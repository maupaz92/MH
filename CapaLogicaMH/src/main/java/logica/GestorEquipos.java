package logica;

import java.util.ArrayList;
import java.util.List;

import persistencia.implementaciones.actualizaciones.Actualizador;
import persistencia.implementaciones.escritura.Registrador;
import persistencia.implementaciones.lectura.LectorEquipos;
import persistencia.interfaces.ActualizadorDAO;
import persistencia.interfaces.LectorEquiposDAO;
import persistencia.interfaces.RegistradorDAO;
import modelos.recursos.EquipoModelo;
import modelos.recursos.PaisModelo;

public class GestorEquipos {
	
	
	private RegistradorDAO registradorObjetosBD;
	private ActualizadorDAO actualizadorObjetosBD;
	private LectorEquiposDAO lectorDatosEquipos;
	
	public GestorEquipos(){
		registradorObjetosBD = new Registrador();
		actualizadorObjetosBD = new Actualizador();
		lectorDatosEquipos = new LectorEquipos();
	}
	
	
	public boolean registrarNuevoEquipo(EquipoModelo equipo){
		
		this.getRegistradorObjetosBD().guardarNuevoRecurso(equipo);
		
		return true;
	}
	
	/**
	 * 
	 * @return
	 * Se retorna la lista de objetos tipo PaisModelo validos
	 */
	public List<PaisModelo> getPaisesValidos(){
		List<Object> paises = this.getLectorDatosEquipos().getPaisesDeOrigen();
		List<PaisModelo> listaFinal = new ArrayList<PaisModelo>();
		for (Object object : paises) {
			PaisModelo pais = (PaisModelo) object;
			listaFinal.add(pais);
		}
		return listaFinal;
	}

	
	//getters & setters
	private RegistradorDAO getRegistradorObjetosBD() {
		return registradorObjetosBD;
	}

	private ActualizadorDAO getActualizadorObjetosBD() {
		return actualizadorObjetosBD;
	}


	private LectorEquiposDAO getLectorDatosEquipos() {
		return lectorDatosEquipos;
	}


}
