package persistencia.interfaces;

import java.util.List;


/**
 * interface que define los accesos de datos
 * que se pueden obtener para los recursos tipo equipo
 * @author Mauricio Paz
 *
 */
public interface LectorEquiposDAO {

	/**
	 * 
	 * @param idEquipo
	 * Identificador del equipo.
	 * @return
	 * Se retorna un objeto con los datos del equipo segun 
	 * el identificador provisto en el parametro
	 */
	public Object getEquipo(int idEquipo);
	
	/**
	 * 
	 * @param nombre
	 * Nombre del equipo que se desea buscar
	 * @param idPais
	 * identificador del pais donde se desea buscar el equipo
	 * @return
	 * Un objeto con los datos del equipo identificado por el nombre
	 * para un pais especifico.
	 */
	public Object getEquipo(String nombre, int idPais);
	
	
	/**
	 * 
	 * @return
	 * Se retorna la lista de todos los equipos registrados en el sistema
	 */
	public List<Object> getEquiposRegistrados();
	
	/**
	 * 
	 * @return
	 * Se retorna la lista de objetos que contienen informacion de 
	 * los paises donde puede existir un equipo.
	 */
	public List<Object> getPaisesDeOrigen();
}
