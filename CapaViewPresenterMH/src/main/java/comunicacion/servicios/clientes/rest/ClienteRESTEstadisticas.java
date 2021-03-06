package comunicacion.servicios.clientes.rest;



import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.logging.Logger;
import modelos.recursos.ConjuntoEstadisticasParciales;
import modelos.recursos.PartidoModelo;
import comunicacion.servicios.interfaces.ConsultasEquipos;
import comunicacion.servicios.interfaces.ConsultasEstadisticas;

public class ClienteRESTEstadisticas implements ConsultasEstadisticas{

	
	private final String ROOT_URI = "/estadisticas";
	private final String ERROR_SERVICIO_NO_DISPONIBLE = "El servicio no se encuentra disponible";	
	private final String SERVICE_URI = "http://localhost:8080/CapaServicioMH";
	private final String PARTIDO_REGISTER_URI = "/partidos";
	
	private String mensajeErrorCliente;
	private Client cliente;		
	private final Logger log = Logger.getLogger(ConsultasEquipos.class);
	
	public ClienteRESTEstadisticas(){
		setCliente(ClientBuilder.newClient());
		mensajeErrorCliente = "";
	}
	
	
	public boolean enviarRegistroDeEstadisticas(
			ConjuntoEstadisticasParciales estadisticas) {
		
		//se define la url completa
		String url = SERVICE_URI+ROOT_URI;						
				
		//se procede a obtener la lista del servicio
		try{						
			this.getCliente().target(url).request().post(Entity.xml(estadisticas));
		}catch(WebApplicationException excepcion){
			//codigo de la respuesta
			int codigoWeb = excepcion.getResponse().getStatus();
			//codigo cuando el servicio no esta disponible
			int codigoServicioNoEncontrado = Response.Status.NOT_FOUND.getStatusCode();
			if(codigoWeb == codigoServicioNoEncontrado){
				this.setMensajeErrorCliente(ERROR_SERVICIO_NO_DISPONIBLE);
				log.info("Codigo retornado de la respuesta: "+Integer.toString(codigoWeb));		
			}
		}
		
		return false;
	}


	public int enviarRegistroDePartido(PartidoModelo partido) {
		//se define la url completa
		String url = SERVICE_URI+ROOT_URI+PARTIDO_REGISTER_URI;						
		Response respuesta = null;	
		//se procede a obtener la lista del servicio
		this.log.info(partido.toString());
		try{						
			respuesta = this.getCliente().target(url).request().post(Entity.entity(partido, "application/json"));
		}catch(WebApplicationException excepcion){
			//codigo de la respuesta
			int codigoWeb = excepcion.getResponse().getStatus();
			//codigo cuando el servicio no esta disponible
			int codigoServicioNoEncontrado = Response.Status.NOT_FOUND.getStatusCode();
			if(codigoWeb == codigoServicioNoEncontrado){
				this.setMensajeErrorCliente(ERROR_SERVICIO_NO_DISPONIBLE);
				log.info("Codigo retornado de la respuesta: "+Integer.toString(codigoWeb));		
			}
		}				
		PartidoModelo partidoRecibido = respuesta.readEntity(PartidoModelo.class);
		this.getLog().info("Id del partido creado: "+partidoRecibido.getId_Partido());
		return partidoRecibido.getId_Partido();
	}

	public String getMensajeError() {
		return mensajeErrorCliente;
	}
	
	private void setMensajeErrorCliente(String mensajeErrorCliente){
		this.mensajeErrorCliente = mensajeErrorCliente;
	}


	public Client getCliente() {
		return cliente;
	}


	private void setCliente(Client cliente) {
		this.cliente = cliente;
	}
	
	private Logger getLog(){
		return log;
	}

	/*
	public static void main(String[] args){
		
		ClienteRESTEstadisticas c = new ClienteRESTEstadisticas();
		Response r = c.getCliente().target("http://localhost:8080/CapaServicioMH/estadisticas/partidosX").
				request().post(Entity.text(new String("hola")));
		String s = r.readEntity(String.class);
		c.log.info(s);
	}
	*/
}
