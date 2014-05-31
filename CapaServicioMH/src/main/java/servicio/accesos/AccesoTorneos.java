package servicio.accesos;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;

import modelos.recursos.TorneoModelo;

@Path("/torneos")
public class AccesoTorneos {

	public AccesoTorneos()
	{
		
	}
	
	@GET	
	@Produces(MediaType.TEXT_HTML)
	public String holaMundi()
	{
		return "holaMau";
	}
	
	
	@GET
	@Path("/{nombre}")
	@Produces(MediaType.APPLICATION_XML)
	public TorneoModelo getTorneoPorNombre(@PathParam("nombre") String nombre)
	{
		return null;
	}
	
	@GET
	@Path("/torneos")
	@Produces(MediaType.APPLICATION_JSON)
	public void getTorneosPorTipo(@PathParam("tipo") String tipoTorneo)
	{
		
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public void registrarNuevoTorneo(TorneoModelo torneo)
	{		
		System.out.println(torneo.getNombre());
	}
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public void modificarTorneo(@PathParam("nombre") String nombreTorneo, TorneoModelo torneo)
	{
		
	}
	
	
	
	
	
	
	
	
	
	
}
