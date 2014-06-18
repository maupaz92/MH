package logica;

import java.util.ArrayList;
import java.util.List;

import persistencia.implementaciones.escritura.Registrador;
import persistencia.implementaciones.lectura.LectorJugadores;
import persistencia.interfaces.LectorJugadoresDAO;
import persistencia.interfaces.RegistradorDAO;
import modelos.recursos.JugadorModelo;

public class GestorJugadores {

	
	private RegistradorDAO registradorObjetosBD;
	private LectorJugadoresDAO lectorJugadores;
	private String mensajeError;	
	
	public GestorJugadores(){
		setRegistradorObjetosBD(new Registrador());
		setLectorJugadores(new LectorJugadores());
		setMensajeError("");		
	}
	
	/**
	 * metodo que valida y confirma el registro de un nuevo jugador
	 * en el sistema.
	 * @param jugador
	 * Objeto tipo {@link JugadorModelo} que contiene los datos del jugador a registrar
	 * @return
	 * True si el registro fue exitoso. False en caso de que el jugador
	 * ya exista en el sistema. Los jugadores se identifican por el pasaporte.
	 */
	public boolean registrarJugador(JugadorModelo jugador){						
		boolean registroExitoso = false;
		//se intenta obtener un equipo con los mismos datos que el que ingresa
		JugadorModelo jugadorPrueba = (JugadorModelo) this.getLectorJugadores().getJugador(jugador.getPasaporte());
		//si el equipo obtenido de prueba no es nulo
		if(jugadorPrueba != null)
			this.setMensajeError("Error: Jugador repetido");
		else{
			this.getRegistradorObjetosBD().guardarNuevoRecurso(jugador);
			registroExitoso = true;
		}				
		return registroExitoso;
	}
	
	
	/**
	 * 
	 * @return
	 * Lista de jugadores registrados en el sistema, objetos tipo {@link JugadorModelo}
	 */
	public List<JugadorModelo> getJugadoresRegistrados(){
		//se obtiene la lista generica
		List<Object> listaInicial = this.getLectorJugadores().getJugadoresRegistrados();
		List<JugadorModelo> listaFinal = new ArrayList<JugadorModelo>();
		//se itera sobre la lista generica para construir los objetos
		for (Object jugadorInicial : listaInicial) {
			JugadorModelo jugador = (JugadorModelo) jugadorInicial;
			listaFinal.add(new JugadorModelo(jugador));			
		}
		return listaFinal;
		
	}
	
	/**
	 * 
	 * @param idClub
	 * Id del equipo tipo club del que se quieren obtener los jugadores
	 * @return
	 * Lista de obtejos {@link JugadorModelo} unicamente con los datos
	 * de nombre y pasaporte
	 */
	public List<JugadorModelo> getIdentificacionJugadoresPorClub(int idClub){
		
		List<Object> listaParcial = this.getLectorJugadores().getJugadoresPorClub(idClub);
		List<JugadorModelo> listaFinal = new ArrayList<JugadorModelo>();
		for (Object object : listaParcial) {
			JugadorModelo jugador = new JugadorModelo((JugadorModelo)object);
			jugador.limpiarIdentificacion();
			listaFinal.add(jugador);
		}
		return listaFinal;
	}
	
	/**
	 * 
	 * @param idClub
	 * Id del equipo tipo seleccion del que se quieren obtener los jugadores
	 * @return
	 * Lista de obtejos {@link JugadorModelo} unicamente con los datos
	 * de nombre y pasaporte
	 */
	public List<JugadorModelo> getIdentificacionJugadoresPorSeleccion(int idSeleccion){
		
		List<Object> listaParcial = this.getLectorJugadores().getJugadoresPorSeleccion(idSeleccion);
		List<JugadorModelo> listaFinal = new ArrayList<JugadorModelo>();
		for (Object object : listaParcial) {
			JugadorModelo jugador = new JugadorModelo((JugadorModelo)object);
			jugador.limpiarIdentificacion();
			listaFinal.add(jugador);
		}
		return listaFinal;
	}
	
	
	//getters & settters

	private RegistradorDAO getRegistradorObjetosBD() {
		return registradorObjetosBD;
	}

	private void setRegistradorObjetosBD(RegistradorDAO registradorObjetosBD) {
		this.registradorObjetosBD = registradorObjetosBD;
	}

	private LectorJugadoresDAO getLectorJugadores() {
		return lectorJugadores;
	}

	private void setLectorJugadores(LectorJugadoresDAO lectorJugadores) {
		this.lectorJugadores = lectorJugadores;
	}

	public String getMensajeError() {
		return mensajeError;
	}

	private void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}
	
}
