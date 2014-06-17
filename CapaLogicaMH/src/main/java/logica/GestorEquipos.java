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
	private String mensajeError;
	
	public GestorEquipos(){
		registradorObjetosBD = new Registrador();
		actualizadorObjetosBD = new Actualizador();
		lectorDatosEquipos = new LectorEquipos();
		mensajeError = "";
	}
	
	/**
	 * metodo que gestiona el ingreso de un nuevo equipo al sistema.
	 * Valida que el nombre del equipo para el pais escogido no haya sido
	 * registrado previamente en el sistema.
	 * @param equipo
	 * Objeto tipo {@link EquipoModelo} que se desea registrar 
	 * @return
	 * True en caso de que el equipo no exista y se haya podido guardar en los 
	 * registros del sistema, false en caso contrario
	 */
	public boolean registrarNuevoEquipo(EquipoModelo equipo){
		boolean registroExitoso = false;
		//se intenta obtener un equipo con los mismos datos que el que ingresa
		EquipoModelo equipoPrueba = (EquipoModelo) this.getLectorDatosEquipos().
				getEquipo(equipo.getNombre(), equipo.getPais().getId_Pais());
		//si el equipo obtenido de prueba no es nulo
		if(equipoPrueba != null)
			this.setMensajeError("Error: Equipo repetido para dicho pais");
		else{
			this.getRegistradorObjetosBD().guardarNuevoRecurso(equipo);
			registroExitoso = true;
		}				
		return registroExitoso;
	}
	
	/**
	 * 
	 * @return
	 * Se retorna la lista de objetos tipo {@link PaisModelo} donde un equipo
	 * puede ser registrado
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
	
	/**
	 * 
	 * @return
	 * Lista de objetos tipo {@link EquipoModelo} registrados en el sistema.
	 */
	public List<EquipoModelo> getListaEquiposRegistrados(){
		//se obtiene la lista generica
		List<Object> listaInicial = this.getLectorDatosEquipos().getEquiposRegistrados();
		List<EquipoModelo> listaFinal = new ArrayList<EquipoModelo>();
		//se itera sobre la lista generica para construir los objetos
		for (Object equipoInicial : listaInicial) {
			EquipoModelo equipo = (EquipoModelo) equipoInicial;
			//se agrega el equipo, se debe crear una nueva instancia(copia total) del 
			//equipo porque no se mapea a JSON con el objeto retornado de hibernate
			listaFinal.add(new EquipoModelo(equipo));
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
	
	public String getMensajeError() {
		return mensajeError;
	}

	private void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}
	
	

}
