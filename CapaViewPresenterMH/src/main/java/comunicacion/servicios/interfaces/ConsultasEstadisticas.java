package comunicacion.servicios.interfaces;



import modelos.recursos.ConjuntoEstadisticasParciales;
import modelos.recursos.PartidoModelo;

public interface ConsultasEstadisticas {
	
	/**
	 * Metodo que debe implementarse para enviar un conjunto de estadisticas
	 * al servicio para que sean registradas
	 * @param listaEstadisticas
	 * Lista que contiene las estadisticas de los jugadores
	 * @return
	 * True en caso de que el registro haya sido exitoso, false en caso contrario
	 */
	public boolean enviarRegistroDeEstadisticas(ConjuntoEstadisticasParciales estadisticas);
	
	
	/**
	 * Se define para obtener mensajes personalizados de error
	 * segun los diversos errores que pueden surgir con la comunicacion
	 * entre el cliente y el web service
	 * @return
	 * Mensaje personalizado de error.
	 */
	public String getMensajeError();

	
	/**
	 * metodo que debe implementarse para definir el envio
	 * de un nuevo partido al servicio para su registro
	 * @param partido
	 * Objeto tipo {@link PartidoModelo} que se registrara en el servicio
	 * @return
	 * id del torneo que se registra
	 */
	public int enviarRegistroDePartido(PartidoModelo partido);
	
}
