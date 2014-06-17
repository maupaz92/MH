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
	public Object getEquipoPorId(int idEquipo);
	
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
