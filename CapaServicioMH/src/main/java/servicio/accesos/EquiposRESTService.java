package servicio.accesos;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import modelos.recursos.EquipoModelo;
import modelos.recursos.PaisModelo;

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
		
		PaisModelo CR = new PaisModelo();
		CR.setId_Pais(1);
		CR.setNombre("Costa Rica");
		
		EquipoModelo equipo1 = new EquipoModelo();
		equipo1.setId_Equipo(1);
		equipo1.setNombre("L.D.A");
		equipo1.setPais(CR);
		equipo1.setTipoClub(true);
		
		EquipoModelo equipo2 = new EquipoModelo();
		equipo2.setId_Equipo(2);
		equipo2.setNombre("Saprissa");
		equipo2.setPais(CR);
		equipo2.setTipoClub(true);
		
		EquipoModelo equipo3 = new EquipoModelo();
		equipo3.setId_Equipo(3);
		equipo3.setNombre("Costa Rica");
		equipo3.setPais(CR);
		equipo3.setTipoClub(false);
		
		List<EquipoModelo> lista = new ArrayList<EquipoModelo>();
		lista.add(equipo1);
		lista.add(equipo2);
		lista.add(equipo3);
		
		return lista;
	}
	
}
