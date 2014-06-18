package persistencia.interfaces;

import java.util.List;

public interface LectorJugadoresDAO {
	
	/**
	 * 
	 * @param pasaporte
	 * Identificador del jugador
	 * @return
	 * El objeto con los datos del jugador identificado por el parametro, nulo
	 * si el jugador no existe.
	 */
	public Object getJugador(int pasaporte);

	
	/**
	 * 
	 * @return
	 * Lista con los objetos que contienen los datos de los
	 * jugadores registrados en el sistema
	 */
	public List<Object> getJugadoresRegistrados();
	
	
	/**
	 * 
	 * @param idEquipo
	 * Identificador del equipo del que se desea recuperar los jugadores
	 * @return
	 * Lista de objetos con informacion de jugadores que pertenezcan a un equipo
	 * club
	 */
	public List<Object> getJugadoresPorClub(int idEquipo);
	
	/**
	 * 
	 * @param idEquipo
	 * Identificador del equipo del que se desea recuperar los jugadores
	 * @return
	 * Lista de objetos con informacion de jugadores que pertenezcan a un equipo
	 * seleccion
	 */
	public List<Object> getJugadoresPorSeleccion(int idEquipo);
}
