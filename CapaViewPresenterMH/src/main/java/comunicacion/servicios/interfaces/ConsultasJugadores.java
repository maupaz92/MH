package comunicacion.servicios.interfaces;

import modelos.recursos.JugadorModelo;

public interface ConsultasJugadores {
	
	/**
	 * metodo que debe implementarse para enviar el registro
	 * de un nuevo jugador al servicio.
	 * @param jugador
	 * Objeto jugador que se registrara
	 * @return
	 * True en caso de que el envio sea satisfactorio, false en caso contrario
	 */
	public boolean enviarRegistroJugador(JugadorModelo jugador);

	
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
