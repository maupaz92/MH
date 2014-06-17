package struts.acciones;

import modelos.recursos.TorneoModelo;

import org.jboss.resteasy.logging.Logger;
import com.opensymphony.xwork2.ActionSupport;

import comunicacion.servicios.clientes.rest.ClienteRESTTorneos;
import comunicacion.servicios.interfaces.ConsultasTorneos;

public class TorneosAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private final Logger log = Logger.getLogger(TorneosAction.class);
	
	private TorneoModelo torneo;
	private ConsultasTorneos clienteTorneos;
	
	private String esCopaTorneo;
	private String tipoSelecciones;
	private int idTorneo;
	
	
	
	
	public TorneosAction(){
		clienteTorneos = new ClienteRESTTorneos();
	}
	
	/*
	 * llamada tile
	 */
	public String vistaRegistrarTorneo(){
		return "vistaRegistrarTorneo";
	}
	
	/*
	 * llamada tile
	 */
	public String vistaEdicionTorneo(){
		return "vistaEdicionTorneo";
	}

	
	/**
	 * Metodo que obtiene lo datos del formulario de registro de torneo y
	 * lo convierte en un objeto {@link TorneoModelo}. Delega el envio del registro
	 * al cliente del servicio.
	 * @return
	 * Nombre de la vista que se presenta despues de la insercion. Se retorna a la vista de insercion.
	 */
	public String registrarTorneo(){
		//se define los datos ingresados en el formulario
		this.setDatosTorneo();
		//se pasa al cliente 
		boolean envioRegistro = this.getClienteTorneos().enviarRegistroNuevoTorneo(getTorneo());
		if(!envioRegistro){
			this.addActionError(this.getClienteTorneos().getMensajeError());
		}
		this.getTorneo().limpiarDatos();
		return "vistaRegistrarTorneo";
	}
	
	/**
	 * Metodo que obtiene lo datos del formulario de edicion de torneo y
	 * lo convierte en un objeto {@link TorneoModelo}. Delega el envio de la 
	 * actualizacion al cliente del servicio
	 * @return
	 * Nombre de la vista que se presenta despues de la edicion. Se retorna a la vista de edicion
	 */
	public String actualizarTorneo(){
		//se define los datos ingresados en el formulario
		this.setDatosTorneo();
		//se define el id del torneo segun la escogencia del torneo
		this.getTorneo().setId(this.getIdTorneo());	
		//se envia la actualizacion al servicio
		boolean envioActualizacion = this.getClienteTorneos().enviarActualizacionDeTorneo(getTorneo());		
		if(!envioActualizacion){
			this.addActionError(this.getClienteTorneos().getMensajeError());
		}
		this.getTorneo().limpiarDatos();
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


	private ConsultasTorneos getClienteTorneos() {
		return clienteTorneos;
	}
	
	
}
