package comunicacion.servicios.interfaces;

import java.util.List;

import modelos.recursos.EquipoModelo;
import modelos.recursos.PaisModelo;

/**
 * interface que provee los metodos necesarios para establecer
 * comunicacion con el web service y obtener datos sobre los equipos
 * @author Mauricio Paz
 *
 */
public interface ConsultasEquipos {

	/**
	 * Metodo que debe enviar una solicitud al web service para
	 * registrar un nuevo equipo en el sistema. 
	 * @param equipo
	 * @return
	 * True si el registro fue exitoso, false en caso contrario
	 */
	public boolean enviarRegistroDeEquipo(EquipoModelo equipo);
	/**
	 * metodo que solicita al web service un conjunto de equipos
	 * segun el tipo de equipo, ya sea de seleccion o club.
	 * @param deTipoClubes
	 * @return
	 * Lista de equipos tipo {@link EquipoModelo} segun el tipo especificado
	 * en el parametro.
	 */
	public List<EquipoModelo> getEquipoPorTipo(boolean deTipoClubes);
	/**
	 * metodo que debe enviar una solicitud al web service para actualizar
	 * un equipo que ha sido modificado
	 * @param equipoModificado
	 * @return
	 * True si la actualizacion se efectuo, false en caso contrario.
	 */
	public boolean enviarActualizacionDeEquipo(EquipoModelo equipoModificado);
	
	/**
	 * 
	 * @return
	 * se retorna la lista de paises en lo que se puede registrar un equipo
	 */
	public List<PaisModelo> getPaises();
	
}
