package comunicacion.servicios.clientes.rest;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import modelos.recursos.EquipoModelo;
import comunicacion.servicios.interfaces.ConsultasEquipos;

public class ClienteRESTEquipos implements ConsultasEquipos{

	private final String rootResourceURI = "/equipos";
	private Client cliente;
	private final String URI = "http://localhost:8080/CapaServicioMH";
	
	
	public ClienteRESTEquipos(){
		cliente = ClientBuilder.newClient();
	}
	
	public boolean enviarRegistroDeEquipo(EquipoModelo equipo) {
		boolean envioExitoso = true;		
		//se define la url del servicio que se requiere
		WebTarget urlObjetivo = this.getCliente().target(this.getURI()+this.getRootResourceURI());
		//se ejecuta el request con el metodo "post", y se almacena en un objeto "Response"
		Response respuesta = urlObjetivo.request().post(Entity.xml(equipo));
		//si la respuesta es distinta de la exitosa, se asume que hay un torneo repetido
		if(respuesta.getStatus() != 204){
			envioExitoso = false;
		}	
		respuesta.close();
		return envioExitoso;		
	}

	public List<EquipoModelo> getEquipoPorTipo(boolean deTipoClubes) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean enviarActualizacionDeEquipo(EquipoModelo equipoModificado) {
		// TODO Auto-generated method stub
		return false;
	}

	//getters y setters
	private String getRootResourceURI() {
		return rootResourceURI;
	}

	private Client getCliente() {
		return cliente;
	}

	private String getURI() {
		return URI;
	}
	

}
