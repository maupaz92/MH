package servicio.accesos;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.logging.Logger;

import logica.GestorEquipos;
import modelos.recursos.EquipoModelo;
import modelos.recursos.PaisModelo;

/**
 * 
 * @author Mauricio Paz
 *
 */

@Path("/equipos")
public class EquiposRESTService {

	private GestorEquipos gestor;
	private final Logger log = Logger.getLogger(EquiposRESTService.class);
	
	
	public EquiposRESTService(){
		gestor = new GestorEquipos();
	}
	
	
	@GET
	@Produces({"application/json", "application/xml"})
	public Response getEquiposRegistrados(){
						
		List<EquipoModelo> equipos = this.getGestor().getListaEquiposRegistrados();
		//se construye un "wrapper" generico para enviar la lista
		GenericEntity<List<EquipoModelo>> equiposWrap = new GenericEntity<List<EquipoModelo>>(equipos){};
		return Response.ok(equiposWrap).build();				
		
		//return this.getGestor().getListaEquiposRegistrados();
	}
	
	@GET
	@Path("/paises")
	@Produces({"application/xml", "application/json"})
	public Response getPaises(){
		//se obtiene la lista de paises validos
		List<PaisModelo> paises = this.getGestor().getPaisesValidos();
		//se construye un "wrapper" generico para enviar la lista
		GenericEntity<List<PaisModelo>> paisesWrap = new GenericEntity<List<PaisModelo>>(paises){};
		//se retorna la respuesta
		return Response.ok(paisesWrap).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public void registrarNuevoEquipo(EquipoModelo equipo){
		log.info(equipo.toString());
		this.getGestor().registrarNuevoEquipo(equipo);
	}
	

	//getters & setters
	private GestorEquipos getGestor() {				
		return gestor;
	}

	
	
}
