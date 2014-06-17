package comunicacion.servicios.interfaces;

import modelos.recursos.TorneoModelo;

public interface ConsultasTorneos {
	
	/**
	 * metodo que ejecuta la solicitud para registrar un nuevo torneo
	 * en el servicio.
	 * @param objeto con los datos del nuevo registro
	 * @return 
	 * True si el registro es exitoso, false en caso contrario.
	 */
	public boolean enviarRegistroNuevoTorneo(TorneoModelo torneo);

	/**
	 * metodo que envia la solicitud para actualizar un torneo que 
	 * ha sido modificado
	 * @param torneo
	 * Torneo con los datos modificados
	 * @return
	 * True si la actualizacion fue exitosa, false en caso contrario
	 */
	public boolean enviarActualizacionDeTorneo(TorneoModelo torneo);
	
	
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
