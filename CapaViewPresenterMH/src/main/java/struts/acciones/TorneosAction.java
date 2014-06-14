package struts.acciones;

import modelos.recursos.TorneoModelo;

import org.jboss.resteasy.logging.Logger;

import clientes.rest.ClienteTorneos;

import com.opensymphony.xwork2.ActionSupport;

public class TorneosAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private TorneoModelo torneo;
	private String esCopaTorneo;
	private String tipoSelecciones;
	private int idTorneo;
	private ClienteTorneos clienteTorneos;
	private final Logger log = Logger.getLogger(TorneosAction.class);
	
	/*
	 * llamada tile
	 */
	public String vistaRegistrarTorneo()
	{
		return "vistaRegistrarTorneo";
	}
	
	/*
	 * llamada tile
	 */
	public String vistaEdicionTorneo()
	{
		return "vistaEdicionTorneo";
	}

	
	/**
	 * 
	 * @return
	 */
	public String registrarTorneo(){
		//se define los datos ingresados en el formulario
		this.setDatosTorneo();
		clienteTorneos = new ClienteTorneos();
		clienteTorneos.enviarRegistroNuevoTorneo(getTorneo());
		this.setTorneo(null);
		return "vistaRegistrarTorneo";
	}
	
	
	public String actualizarTorneo(){
		//se define los datos ingresados en el formulario
		this.setDatosTorneo();
		this.getTorneo().setId(this.getIdTorneo());
		clienteTorneos = new ClienteTorneos();
		clienteTorneos.enviarModificacionTorneo(getTorneo());
		this.setTorneo(null);
		return "vistaEdicionTorneo";
	}
	
	
	
	/**
	 * metodo encargado de cargar al objeto TorneoModelo de la clase
	 * los valores que fueron ingresados en el formuario de registro y edicion 
	 * de torneos
	 */
	private void setDatosTorneo(){
		//se le define al objeto torneo inicialmente la bandera de copa como false
		//debido a que no ha sido iniciado previamente
		this.getTorneo().setCopa(false);
		this.getTorneo().setTipoSelecciones(false);
		//se compara si en el formulario se selecciono "si" para el dato de esDeCopa?
		if(this.getEsCopaTorneo().equalsIgnoreCase("si"))			
			this.getTorneo().setCopa(true);
		if(this.getTipoSelecciones().equalsIgnoreCase("si"))			
			this.getTorneo().setTipoSelecciones(true);
	}
	
	
	
	//getters y setters
	
	public TorneoModelo getTorneo() {
		return torneo;
	}

	public void setTorneo(TorneoModelo torneo) {
		this.torneo = torneo;
	}

	public String getEsCopaTorneo() {
		return esCopaTorneo;
	}

	public void setEsCopaTorneo(String esCopaTorneo) {
		this.esCopaTorneo = esCopaTorneo;
	}

	public Logger getLog() {
		return log;
	}

	public String getTipoSelecciones() {
		return tipoSelecciones;
	}

	public void setTipoSelecciones(String tipoSelecciones) {
		this.tipoSelecciones = tipoSelecciones;
	}

	public int getIdTorneo() {
		return idTorneo;
	}

	public void setIdTorneo(int idTorneo) {
		this.idTorneo = idTorneo;
	}
	
	
}
