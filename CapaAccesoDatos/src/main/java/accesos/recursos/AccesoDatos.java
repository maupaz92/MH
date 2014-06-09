package accesos.recursos;

import java.util.List;

public abstract class AccesoDatos {

	protected List<String> parametrosMetodo;
	
	/**
	 * Metodo para obtener un recurso 
	 * de la base de datos.  
	 * @return
	 */
	public abstract Object darRecurso(String identificador);
	
	/**
	 * Metodo para modificar un objeto en 
	 * la base de datos.
	 */
	public abstract void modificarRecurso(Object objeto);
	
	/**
	 * Metodo para crear un nuevo registro en la base
	 * de datos.
	 */
	public abstract void crearRecurso(Object objeto);
	
	
	/**
	 * Metodo para agregar Parametros a los metodos
	 * anteriores.
	 * @param parametro
	 */
	public void agregarParametro(String parametro)
	{
		parametrosMetodo.add(parametro);
				
	};
	
	public abstract List<Object> darListaRecursos(Object identificador);
}
