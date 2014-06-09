package logica;

import accesos.excepciones.RecursoRepetidoException;
import accesos.recursos.AccesoDatosTorneos;
import modelos.recursos.ConjuntoDeTorneosModelo;
import modelos.recursos.TorneoModelo;

public class GestorTorneos {

	
	private AccesoDatosTorneos accesoTorneos;
	
	public GestorTorneos()
	{
		accesoTorneos = new AccesoDatosTorneos();
	}
	
	/**
	 * metodo encargado de verificar y registrar un nuevo torneo.
	 * Se valida que el torneo no haya sido registro previamente.
	 * @param torneo: torneo a ser registrado
	 * @return: true si el torneo pudo ser registrado, false en caso contrario
	 */
	public boolean registrarNuevoTorneo(TorneoModelo torneo){
		boolean respuesta=true;
		
		try {
			this.getAccesoTorneos().crearRecurso(torneo);
		} catch (RecursoRepetidoException e) {
			e.printStackTrace();
			respuesta = false;
		};
		return respuesta;
	}
	
	public boolean modificarTorneo(TorneoModelo torneo)
	{
		this.getAccesoTorneos().modificarTorneo(torneo);
		return true;
	}
	
	public ConjuntoDeTorneosModelo getListaTorneosRegistrados(){
		return new ConjuntoDeTorneosModelo(getAccesoTorneos().getTorneosRegistrados());
	}

	private AccesoDatosTorneos getAccesoTorneos() {
		return accesoTorneos;
	}
	
	
}
