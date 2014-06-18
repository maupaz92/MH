package comunicacion.servicios.clientes.rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.logging.Logger;

import modelos.recursos.JugadorModelo;
import comunicacion.servicios.interfaces.ConsultasJugadores;

public class ClienteRESTJugadores implements ConsultasJugadores{

	private final String ROOT_RESOURCE_URI = "/jugadores";
	private final String ERROR_SERVICIO_NO_DISPONIBLE = "El servicio no se encuentra disponible";
	private final String ERROR_JUGADOR_REPETIDO = "El jugador ya ha sido registrado";
	private final String SERVICE_URI = "http://localhost:8080/CapaServicioMH";
	
	private Client cliente;		
	private final Logger log = Logger.getLogger(ConsultasJugadores.class);
	private String mensajeErrorCliente = "Error";
	private boolean existeConflicto;
	
	public ClienteRESTJugadores(){
		setCliente(ClientBuilder.newClient());
		setExisteConflicto(false);
	}
	
	
	public boolean enviarRegistroJugador(JugadorModelo jugador) {
		this.getLog().info(jugador.toString());
		boolean envioExitoso = true;		
		//se define la url del servicio que se requiere
		WebTarget urlObjetivo = this.getCliente().target(SERVICE_URI+ROOT_RESOURCE_URI);
		//se ejecuta el request con el metodo "post", y se almacena en un objeto "Response"
		Response respuesta = urlObjetivo.request().post(Entity.xml(jugador));
		//si la respuesta es 404(servidor caido)
		if(respuesta.getStatus() == Response.Status.NOT_FOUND.getStatusCode()){
			this.setMensajeErrorCliente(ERROR_SERVICIO_NO_DISPONIBLE);
			envioExitoso = false;
		}else if(respuesta.getStatus() == Response.Status.CONFLICT.getStatusCode()){
			this.setMensajeErrorCliente(ERROR_JUGADOR_REPETIDO);
			this.setExisteConflicto(true);
			envioExitoso = false;
		}
		respuesta.close();
		return envioExitoso;
	}

	public String getMensajeError() {
		return mensajeErrorCliente;
	}


	public boolean existeErrorDeConflicto() {
		return existeConflicto;
	}

	//getters & setters
	private Client getCliente() {
		return cliente;
	}

	private void setCliente(Client cliente) {
		this.cliente = cliente;
	}

	private void setExisteConflicto(boolean existeConflicto) {
		this.existeConflicto = existeConflicto;
	}

	private void setMensajeErrorCliente(String mensajeErrorCliente){
		this.mensajeErrorCliente = mensajeErrorCliente;
	}

	@SuppressWarnings("unused")
	private Logger getLog() {
		return log;
	}



}
