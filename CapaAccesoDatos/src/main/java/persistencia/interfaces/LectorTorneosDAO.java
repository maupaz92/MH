package persistencia.interfaces;

import java.util.List;

/**
 * interface que define los metodos para poder
 * accesar datos de torneos guardardos en la BD
 * @author Mauricio Paz
 *
 */
public interface LectorTorneosDAO {

	/**
	 * 
	 * @param nombreTorneo
	 * @return 
	 * Objeto tipo torneo contenido en un java Object segun el nombre ingresado.
	 * Si no se encuentra el torneo con dicho nombre, se retorna un objeto null
	 */
	public Object getTorneoPorNombre(String nombreTorneo);
	/**
	 * 
	 * @param idTorneo
	 * @return 
	 * Objeto tipo torneo contenido en un java Object segun su identificador. Si no existe
	 * registro segun el parametro, se retorna un objeto null.
	 */
	public Object getTorneoPorId(int idTorneo);
	/**
	 * 
	 * @return 
	 * Lista total de objetos tipo torneo registrados en la BD
	 */
	public List<Object> getTorneosRegistrados();
	/**
	 * Parametro "deTipoSeleccion" = true, obtiene los torneos de selecciones,
	 * Parametro "deTipoSeleccion" = false, obtiene los torneos de clubes.
	 * @param deTipoSeleccion
	 * @return
	 * Lista de los objetos tipo torneo segun el tipo de bandera especificada
	 */
	public List<Object> getTorneosPorTipo(boolean deTipoSeleccion);
	
}
