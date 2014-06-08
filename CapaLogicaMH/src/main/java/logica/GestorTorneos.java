package logica;

import accesos.recursos.AccesoDatosTorneos;
import modelos.recursos.TorneoModelo;

public class GestorTorneos {

	public GestorTorneos()
	{
		
	}
	
	/**
	 * metodo encargado de verificar y registrar un nuevo torneo.
	 * Se valida que el torneo no haya sido registro previamente.
	 * @param torneo: torneo a ser registrado
	 * @return: true si el torneo pudo ser registrado, false en caso contrario
	 */
	public boolean registrarNuevoTorneo(TorneoModelo torneo){
		AccesoDatosTorneos acceso = new AccesoDatosTorneos();
		acceso.crearRecurso(torneo);;
		return true;
	}
	
}
