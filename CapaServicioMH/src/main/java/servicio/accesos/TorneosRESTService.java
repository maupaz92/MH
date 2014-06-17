package servicio.accesos;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import logica.GestorTorneos;
import modelos.recursos.TorneoModelo;

import org.jboss.resteasy.logging.Logger;


/**
 * clase encargada de recibir las solicitudes http para
 * la direccion relativa "/torneos". Maneja el acceso de los recursos
 * relacionados con entidades torneo del sistema.
 * @author maupaz92
 *
 */
@Path("/torneos")
public class TorneosRESTService {

	
	private final Logger log = Logger.getLogger(TorneosRESTService.class);
	private GestorTorneos gestor;


	public TorneosRESTService()
	{
		gestor = new GestorTorneos();
	}		
	
	/**
	 * metodo encargado de recibir las solicitudes de cuando
	 * se quiere obtener los torneos segun el tipo de selecciones mediante el URI
	 * "/torneos/tipos?deTipoSelecciones=true", si no se especifica el tipo
	 * por defecto se envian los tipo torneo
	 * @param esDeSelecciones
	 * @return
	 * Una lista con los torneos segun el tipo en el parametro.
	 */
	@GET
	@Path("/tipos")
	@Produces({"application/json", "application/xml"})
	public List<TorneoModelo> getTorneosPorTipo(
			@DefaultValue("true") 
			@QueryParam("deTipoSelecciones") Boolean esDeSelecciones)
	{	
		this.log.info(new Boolean(esDeSelecciones).toString());
		return this.getGestor().getTorneosPorTipo(esDeSelecciones);		
	}
	
	
	
	/**
	 * metodo que recibe las solicitudes para el URI
	 * "/torneos"
	 * @return
	 * La lista completa de torneos que han sido registrados en el sistema
	 */
	@GET	
	@Produces({"application/json", "application/xml"})
	public List<TorneoModelo> getTorneosRegistrados()
	{
		return this.getGestor().getTorneosRegistrados();		
	}	
	
	
	/**
	 * metodo que se encarga de registrar un nuevo torneo en el sistema.
	 * Si el torneo ya existe en el sistema retorna un respuesta 409
	 * igual a conflicto, debido a que hay registros repetidos.
	 * @param torneo
	 */
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public void registrarNuevoTorneo(TorneoModelo torneo)
	{						
		boolean registroExitoso = this.getGestor().registrarNuevoTorneo(torneo);
		//si el registro no se puede llevar 
		if(!registroExitoso){
			throw new WebApplicationException(this.getGestor().getMensajeError(), Response.Status.CONFLICT);
		}	
	}
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_XML)	
	public void modificarTorneo(TorneoModelo torneo)
	{
		log.info(torneo.toString()+" id: "+Integer.toString(torneo.getId()));
		boolean modificacionExitosa = this.getGestor().modificarTorneo(torneo);
		if(!modificacionExitosa){
			throw new WebApplicationException(this.getGestor().getMensajeError(), Response.Status.CONFLICT);
		}
	}	
	
	
	private GestorTorneos getGestor() {
		return gestor;
	}
	
	
}
