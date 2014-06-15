package logica;

import persistencia.implementaciones.actualizaciones.Actualizador;
import persistencia.implementaciones.escritura.Registrador;
import persistencia.interfaces.ActualizadorDAO;
import persistencia.interfaces.RegistradorDAO;
import modelos.recursos.EquipoModelo;

public class GestorEquipos {
	
	
	private RegistradorDAO registradorObjetosBD;
	private ActualizadorDAO actualizadorObjetosBD;
	
	public GestorEquipos(){
		registradorObjetosBD = new Registrador();
		actualizadorObjetosBD = new Actualizador();
	}
	
	
	public boolean registrarNuevoEquipo(EquipoModelo equipo){
		
		this.getRegistradorObjetosBD().guardarNuevoRecurso(equipo);
		
		return true;
	}

	
	//getters & setters
	private RegistradorDAO getRegistradorObjetosBD() {
		return registradorObjetosBD;
	}

	private ActualizadorDAO getActualizadorObjetosBD() {
		return actualizadorObjetosBD;
	}

}
