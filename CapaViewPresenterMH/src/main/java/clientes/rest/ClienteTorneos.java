package clientes.rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.logging.Logger;
import modelos.recursos.TorneoModelo;

public class ClienteTorneos {

	
	private final String rootResourceURI = "/torneos";
	private Client cliente;
	private final String URI = "http://localhost:8080/CapaServicioMH";
	private final Logger log = Logger.getLogger(ClienteTorneos.class);
	
	
	public ClienteTorneos()
	{
		//se instancia el cliente
		cliente = ClientBuilder.newClient();
	}
	
	/**
	 * metodo que ejecuta la solicitud para registrar un nuevo torneo
	 * en el servicio.
	 * @param torneo: objeto con los datos del nuevo registro
	 * @return: true si el registro es exitoso, false en caso contrario.
	 */
	public boolean enviarRegistroNuevoTorneo(TorneoModelo torneo)
	{
		boolean envioExitoso = true;		
		//se define la url del servicio que se requiere
		WebTarget urlObjetivo = cliente.target(URI+rootResourceURI);
		//se ejecuta el request con el metodo "post", y se almacena en un objeto "Response"
		Response respuesta = urlObjetivo.request().post(Entity.xml(torneo));
		//si la respuesta es distinta de la exitosa, se asume que hay un torneo repetido
		if(respuesta.getStatus() != 204){
			envioExitoso = false;
		}	
		respuesta.close();
		return envioExitoso;
	}
	
	public boolean enviarModificacionTorneo(TorneoModelo torneo){
		//se define la url del servicio que se requiere
		WebTarget urlObjetivo = cliente.target(URI+rootResourceURI);
		//se ejecuta el request con el metodo "put", y se almacena en un objeto "Response"
		Response respuesta = urlObjetivo.request().put(Entity.xml(torneo));
		this.getLog().info("respuesta del servicio "+respuesta.getStatus());
		respuesta.close();		
		return true;
	}

	private Logger getLog() {
		return log;
	}
	
}
