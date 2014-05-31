package clientes;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import modelos.recursos.TorneoModelo;

public class ClienteTorneos {

	private final String rootResourceURI = "/torneos";
	private Client cliente;
	private final String URI = "http://localhost:8080/CapaServicioMH";
	
	
	public ClienteTorneos()
	{
		//se instancia el cliente
		cliente = ClientBuilder.newClient();
	}
	
	public boolean enviarRegistroNuevoTorneo(TorneoModelo torneo)
	{
		//se define la url del servicio que se requiere
		WebTarget urlObjetivo = cliente.target(URI+rootResourceURI);
		//se ejecuta el request con el metodo "post", y se almacena en un objeto "Response"
		Response respuesta = urlObjetivo.request().post(Entity.xml(torneo));
		System.out.println("respuesta del servicio "+respuesta.getStatus());
		respuesta.close();
		return true;
	}
	
	
}
