package comunicacion.servicios.clientes.rest;

import java.util.List;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.logging.Logger;

import modelos.recursos.EquipoModelo;
import modelos.recursos.PaisModelo;
import comunicacion.servicios.interfaces.ConsultasEquipos;

public class ClienteRESTEquipos implements ConsultasEquipos{

	private final String rootResourceURI = "/equipos";
	private final String ERROR_SERVICIO_NO_DISPONIBLE = "El servicio no se encuentra disponible";
	private final String ERROR_EQUIPO_REPETIDO = "El equipo para dicho pais ya ha sido registrado";
	private final String ServiceURI = "http://localhost:8080/CapaServicioMH";
	private final String paisesURI = "/paises";
	private final String equiposTipoURI = "/tipos";
	
	private Client cliente;		
	private final Logger log = Logger.getLogger(ConsultasEquipos.class);
	private String mensajeErrorCliente = "Error";
	private boolean existeConflicto;
	
	
	public ClienteRESTEquipos(){
		this.setExisteConflicto(false);
		cliente = ClientBuilder.newClient();
	}
	
	public boolean enviarRegistroDeEquipo(EquipoModelo equipo) {
		boolean envioExitoso = true;		
		//se define la url del servicio que se requiere
		WebTarget urlObjetivo = this.getCliente().target(this.getServiceURI()+this.getRootResourceURI());
		//se ejecuta el request con el metodo "post", y se almacena en un objeto "Response"
		Response respuesta = urlObjetivo.request().post(Entity.xml(equipo));
		//si la respuesta es 404(servidor caido)
		if(respuesta.getStatus() == Response.Status.NOT_FOUND.getStatusCode()){
			this.setMensajeErrorCliente(ERROR_SERVICIO_NO_DISPONIBLE);
			envioExitoso = false;
		}else if(respuesta.getStatus() == Response.Status.CONFLICT.getStatusCode()){
			this.setMensajeErrorCliente(ERROR_EQUIPO_REPETIDO);
			this.setExisteConflicto(true);
			envioExitoso = false;
		}
		respuesta.close();
		return envioExitoso;
	}

	public List<EquipoModelo> getEquipoPorTipo(boolean deTipoClubes) {
		//se define la url completa
		String url = getServiceURI()+getRootResourceURI()+getEquiposTipoURI();
		//se construye un "wrapper" generico para recibir la lista
		GenericType<List<EquipoModelo>> equiposWrap = new GenericType<List<EquipoModelo>>(){};
		List<EquipoModelo> lista = null;
		//se procede a obtener la lista del servicio
		try{			
			lista = this.getCliente().target(url).queryParam("tipoClub", deTipoClubes).
					request().accept(MediaType.APPLICATION_XML).get(equiposWrap);			
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
		return lista;
	}

	public boolean enviarActualizacionDeEquipo(EquipoModelo equipoModificado) {
		return false;
	}
	
	public List<PaisModelo> getPaises() {
		//se define la url completa
		String url = getServiceURI()+getRootResourceURI()+getPaisesURI();
		//se construye un "wrapper" generico para recibir la lista
		GenericType<List<PaisModelo>> paisesWrap = new GenericType<List<PaisModelo>>(){};
		List<PaisModelo> lista = null;
		//se procede a obtener la lista del servicio
		try{
			lista = this.getCliente().target(url).request().get(paisesWrap);
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
		return lista;
	}		
	
	public List<EquipoModelo> getEquiposRegistrados() {
		//se define la url completa
		String url = getServiceURI()+getRootResourceURI();
		//se construye un "wrapper" generico para recibir la lista
		GenericType<List<EquipoModelo>> equiposWrap = new GenericType<List<EquipoModelo>>(){};
		List<EquipoModelo> lista = null;
		//se procede a obtener la lista del servicio
		try{
			lista = this.getCliente().target(url).request().accept(MediaType.APPLICATION_XML).get(equiposWrap);
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
		return lista;
	}
	
	public String getMensajeError() {	
		return mensajeErrorCliente;
	}
	
	public boolean existeErrorDeConflicto() {
		return existeConflicto; 
	}
	
	
	//getters y setters
	private String getRootResourceURI() {
		return rootResourceURI;
	}

	private Client getCliente() {
		return cliente;
	}
	
	private void setMensajeErrorCliente(String mensajeErrorCliente) {
		this.mensajeErrorCliente = mensajeErrorCliente;
	}	

	private void setExisteConflicto(boolean existeConflicto) {
		this.existeConflicto = existeConflicto;
	}		

	private String getServiceURI() {
		return ServiceURI;
	}

	private String getPaisesURI() {
		return paisesURI;
	}

	private String getEquiposTipoURI() {
		return equiposTipoURI;
	}
	

}
