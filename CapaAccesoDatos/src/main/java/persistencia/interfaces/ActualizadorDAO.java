package persistencia.interfaces;

/**
 * interface que define los metodos para implementar
 * las actualizaciones de los recursos del sistema
 * @author Mauricio Paz
 *
 */
public interface ActualizadorDAO {

	/**
	 * metodo base para actualizar un recurso(objeto)
	 * en la base de datos
	 * @param recurso: objeto que se desea actualziar en la BD.
	 */
	public void actualizarRecurso(Object recurso);
}
