package servicio.accesos;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import modelos.recursos.EquipoModelo;

/**
 * 
 * @author Mauricio Paz
 *
 */

@Path("/equipos")
public class EquiposRESTService {

	@GET
	@Produces({"application/json", "application/xml"})
	public List<EquipoModelo> getEquiposPorTipo(){
		
		EquipoModelo equipo1 = new EquipoModelo();
		equipo1.setNombre("L.D.A");
		equipo1.setPais("Costa Rica");
		equipo1.setTipo(false);
		
		EquipoModelo equipo2 = new EquipoModelo();
		equipo2.setNombre("Saprissa");
		equipo2.setPais("Costa Rica");
		equipo2.setTipo(false);
		
		EquipoModelo equipo3 = new EquipoModelo();
		equipo3.setNombre("Costa Rica");
		equipo3.setPais("Costa Rica");
		equipo3.setTipo(true);
		
		
		return null;
	}
	
}
