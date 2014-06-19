package servicio.accesos;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;








import modelos.recursos.ConjuntoEstadisticasParciales;
import modelos.recursos.EstadisticaParcial;
import modelos.recursos.PartidoModelo;

import org.jboss.resteasy.logging.Logger;

@Path("/estadisticas")
public class EstadisticasRESTService {
	
	private final Logger log = Logger.getLogger(EstadisticasRESTService.class);

	public EstadisticasRESTService(){
		
	}
	
	
	/**
	 * metodo que recibe las solicitudes para registrar nuevos partidos en el sistema. 
	 * @param 
	 * Tipo {@link PartidoModelo}, Nuevo partido que se desea registrar en el sistema.
	 */

	@Path("/partidos")
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public Response registrarNuevoPartido(PartidoModelo partido){
		
		Integer idPartido = 1;
		
		return Response.ok(idPartido).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public void registrarEstadisticas(ConjuntoEstadisticasParciales estadisticas){				
		List<EstadisticaParcial> lista = estadisticas.getListaEstadisticas();		
		 for (EstadisticaParcial estadisticaParcial : lista) {
			 this.getLog().info(estadisticaParcial.toString());
		}					
	}

	
	private Logger getLog() {
		return log;
	}
	
	
}
