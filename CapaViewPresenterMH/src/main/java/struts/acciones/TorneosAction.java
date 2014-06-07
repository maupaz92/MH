package struts.acciones;

import modelos.recursos.TorneoModelo;

import org.jboss.resteasy.logging.Logger;

import clientes.rest.ClienteTorneos;

import com.opensymphony.xwork2.ActionSupport;

public class TorneosAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private TorneoModelo torneo;
	private String esCopaTorneo;
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

	
	public String registrarTorneo(){
		
		
		//se le define al objeto torneo inicialmente la bandera de copa como false
		//debido a que no ha sido iniciado previamente
		this.getTorneo().setCopa(false);
		//se compara si en el formulario se selecciono "si" para el dato de esDeCopa?
		if(this.getEsCopaTorneo().equalsIgnoreCase("si"))			
			this.getTorneo().setCopa(true);		
		clienteTorneos = new ClienteTorneos();
		clienteTorneos.enviarRegistroNuevoTorneo(getTorneo());
		this.setTorneo(null);
		return "vistaRegistrarTorneo";
	}

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
	
}
