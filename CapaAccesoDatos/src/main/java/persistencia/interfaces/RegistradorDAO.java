package persistencia.interfaces;

import java.io.Serializable;

/**
 * Interface que describe los metodos para guardar
 * nuevos recursos en la base de datos
 * @author Mauricio Paz
 *
 */
public interface RegistradorDAO {

	/**
	 * definicion base del metodo que se encargara
	 * de guardar un nuevo recurso(objeto) en la base de datos
	 */
	public void guardarNuevoRecurso(Object nuevoRecurso);

	/**
	 * 
	 * @return
	 * Identificar del ultimo objeto que se ha guardado en la base de datos
	 */
	public Serializable getIdentificadorObjeto();
}
