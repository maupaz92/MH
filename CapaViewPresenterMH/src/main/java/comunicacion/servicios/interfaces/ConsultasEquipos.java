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
	 * metodo que solicita al web service el conjunto de equipos
	 * registrados en el sistema
	 * @return
	 * Lista de equipos tipo {@link EquipoModelo} registrados
	 */
	public List<EquipoModelo> getEquiposRegistrados();
	
	
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
	
	/**
	 * Se define para obtener mensajes personalizados de error
	 * segun los diversos errores que pueden surgir con la comunicacion
	 * entre el cliente y el web service
	 * @return
	 * Mensaje personalizado de error.
	 */
	public String getMensajeError();
	
	
	/**
	 * 
	 * @return
	 * True si un recurso que ha sido enviado para registro o actualizacion
	 * presenta conflictos en el servicio, es decir que no puede efectuarse la accion porque
	 * no cumple las reglas segun el tipo de accion. False en caso de que no existan problemas.
	 */
	public boolean existeErrorDeConflicto();
	
	
}
