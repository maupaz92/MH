package persistencia.interfaces;

import java.util.List;



import modelos.recursos.JugadorModelo;


/**
 * Interface que define los metodos utilizados para poder 
 * acceder datos de Estadisticas de Jugadores guardados en la DB.
 * @author Diego
 *
 */
public interface LectorEstadisticasDAO {

	/**
	 * 
	 * @param jugador
	 * @param club
	 * @param year
	 * @return
	 * Objeto de tipo EstadisticaJugadorRegular contenido en un java Object segun el Pasaporte del Jugador ingresado
	 * el id del equipo ingresado y el año.
	 */
	public Object getEstadisticaRegular(JugadorModelo jugador,int club, int year);
	
	/**
	 * 
	 * @param jugador
	 * @param torneo
	 * @param year
	 * @return
	 * Objeto de tipo EstadisticaJugadorSeleccion contenido en un java Object segun el pasaporte del Jugador, el id
	 * del torneo ingresado y el año.
	 */
	public Object getEstadisticaSeleccion(JugadorModelo jugador, int torneo,int year);
	
	/**
	 * 
	 * @param jugador
	 * @return
	 * Conjunto de objetos EstadisticasJugadorRegularesModelo obtenido segun el identificador del jugador ingresado.
	 */
	public List<Object> getEstadisticasRegularesPorJugador(JugadorModelo jugador);
	
	/**
	 * 
	 * @param jugador
	 * @return
	 * Conjunto de objetos EstadisticasJugadorSeleccion obtenidas segun el identificador del jugador ingresado.
	 */
	public List<Object> getEstadisticasSeleccionPorJugador(JugadorModelo jugador);
	
	public Object getPartido(Integer idPartido);
}
