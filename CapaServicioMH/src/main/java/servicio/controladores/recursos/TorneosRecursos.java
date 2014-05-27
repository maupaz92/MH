package servicio.controladores.recursos;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import servicio.modelos.recursos.TorneoModelo;

@Path("/torneos")
public class TorneosRecursos {

	
	public TorneosRecursos(){}
	
	@GET
	@Path("/{nombre}")
	@Produces(MediaType.APPLICATION_XML)
	public TorneoModelo getTorneoPorNombre(@PathParam("nombre") String nombre)
	{
		return null;
	}
	
	/*
	@GET
	@Path("/tipos/{tipo}")
	@Produces(MediaType.APPLICATION_XML)
	
	¿que tipo de objeto-representacion vamos a retornar?
	
	*/
	
	
	
	
}
