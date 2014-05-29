package servicio.controladores.recursos;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import modelos.recursos.EquipoModelo;


@Path("/equipos")
public class EquiposRecursos {

	public EquiposRecursos(){}
	
	@GET
	@Path("{nombre}")
	@Produces(MediaType.APPLICATION_XML)
	public EquipoModelo getEquipoPorNombre(@PathParam("nombre") String nombre)
	{
		EquipoModelo equipo = new EquipoModelo();
		equipo.setNombre(nombre);
		equipo.setPais("Costa Rica");
		equipo.setTipo(true);
		return equipo;
		
		
		
	}
}
