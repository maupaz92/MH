package logica;

import accesos.recursos.AccesoDatos;
import accesos.recursos.AccesoDatosTorneos;
import modelos.recursos.ConjuntoDeTorneosModelo;
import modelos.recursos.TorneoModelo;

public class GestorTorneos {

	
	private AccesoDatos accesoTorneos;
	
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
		this.getAccesoTorneos().crearRecurso(torneo);;
		return true;
	}
	
	
	public ConjuntoDeTorneosModelo getListaTorneosRegistrados(Boolean esDeSelecciones){
		return new ConjuntoDeTorneosModelo(getAccesoTorneos().darListaRecursos(esDeSelecciones));
	}

	private AccesoDatos getAccesoTorneos() {
		return accesoTorneos;
	}
	
	
}
