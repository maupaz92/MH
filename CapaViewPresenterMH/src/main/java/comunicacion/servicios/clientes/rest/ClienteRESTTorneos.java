package comunicacion.servicios.clientes.rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.logging.Logger;

import modelos.recursos.TorneoModelo;
import comunicacion.servicios.interfaces.ConsultasTorneos;

public class ClienteRESTTorneos implements ConsultasTorneos{

	
	private final String rootResourceURI = "/torneos";
	private final String URI = "http://localhost:8080/CapaServicioMH";private Client cliente;
	private final String errorServicioNoDisponible = "El servicio no se encuentra disponible";
	private final String errorTorneoExistente = "Error: ya existe un torneo registrado con dicho nombre";
	private final Logger log = Logger.getLogger(ClienteRESTTorneos.class);
	
	private String mensajeErrorCliente = "Error";
	private boolean existeConflicto;
		
	public ClienteRESTTorneos(){
		this.setExisteConflicto(false);
	}
	

	public boolean enviarRegistroNuevoTorneo(TorneoModelo torneo) {
		boolean envioExitoso = true;	
		//se define la url del servicio que se requiere
		WebTarget urlObjetivo = cliente.target(URI+rootResourceURI);
		//se ejecuta el request con el metodo "post", y se almacena en un objeto "Response"
		Response respuesta = urlObjetivo.request().post(Entity.xml(torneo));
		//si la respuesta es 404(servidor caido)
		if(respuesta.getStatus() == Response.Status.NOT_FOUND.getStatusCode()){
			this.setMensajeErrorCliente(errorServicioNoDisponible);
			envioExitoso = false;
		}else if(respuesta.getStatus() == Response.Status.CONFLICT.getStatusCode()){
			this.setMensajeErrorCliente(errorTorneoExistente);
		}	
		respuesta.close();
		return envioExitoso;
	}

	public boolean enviarActualizacionDeTorneo(TorneoModelo torneo) {
		boolean actualizacionExitosa = true;
		//se define la url del servicio que se requiere
		WebTarget urlObjetivo = cliente.target(URI+rootResourceURI);
		//se ejecuta el request con el metodo "put", y se almacena en un objeto "Response"
		Response respuesta = urlObjetivo.request().put(Entity.xml(torneo));
		if(respuesta.getStatus() == Response.Status.NOT_FOUND.getStatusCode()){
			this.setMensajeErrorCliente(errorServicioNoDisponible);
			actualizacionExitosa = false;
			log.info("Codigo retornado de la respuesta: "+Integer.toString(respuesta.getStatus()));
		}else if(respuesta.getStatus() == Response.Status.CONFLICT.getStatusCode()){		
			this.setMensajeErrorCliente(errorTorneoExistente);
		}
		respuesta.close();		
		return actualizacionExitosa;
	}

	public String getMensajeError() {
		return mensajeErrorCliente;
	}
	
	public boolean existeErrorDeConflicto() {	
		return false;
	}
	
	//getters & setters
	private void setMensajeErrorCliente(String mensajeErrorCliente) {
		this.mensajeErrorCliente = mensajeErrorCliente;
	}

	public boolean getExisteConflicto() {
		return existeConflicto;
	}

	private void setExisteConflicto(boolean existeConflicto) {
		this.existeConflicto = existeConflicto;
	}	

}
