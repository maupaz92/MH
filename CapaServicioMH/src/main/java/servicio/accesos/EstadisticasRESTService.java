package servicio.accesos;



import java.util.List;

import javax.ws.rs.Consumes;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import logica.GestorEstadisticas;
import modelos.recursos.ConjuntoEstadisticasParciales;
import modelos.recursos.EstadisticaParcial;
import modelos.recursos.PartidoModelo;

import org.jboss.resteasy.logging.Logger;

@Path("/estadisticas")
public class EstadisticasRESTService {
	
	private final Logger log = Logger.getLogger(EstadisticasRESTService.class);
	private GestorEstadisticas gestor;
	
	public EstadisticasRESTService(){
		setGestor(new GestorEstadisticas());
	}
	
	
	/**
	 * metodo que recibe las solicitudes para registrar nuevos partidos en el sistema. 
	 * @param 
	 * Tipo {@link PartidoModelo}, Nuevo partido que se desea registrar en el sistema.
	 */
	@Path("/partidos")
	@POST
	@Consumes({"application/json", "application/xml"})
	@Produces({"application/json", "application/xml"})
	public Response registrarNuevoPartido(PartidoModelo partido){
				
		int idPartidoCreado = this.getGestor().guardarPartido(partido);
		PartidoModelo partidoCreado = new PartidoModelo();
		partidoCreado.setId_Partido(idPartidoCreado);
		Response res = Response.ok().entity(partidoCreado).build();	
		return res;
	}


	/**
	 * 
	 * @param estadisticas
	 */
	@POST
	@Consumes(MediaType.APPLICATION_XML)	
	public void registrarEstadisticas(ConjuntoEstadisticasParciales estadisticas){				
		
		List<EstadisticaParcial> lista = estadisticas.getListaEstadisticas();				
		for (EstadisticaParcial estadisticaParcial : lista) {
			 this.getLog().info(estadisticaParcial.toString());			 
		}
		
		if(estadisticas.isDeSeleccion())
			this.getGestor().registrarEstadisticasSeleccion(lista, estadisticas.getIdentificadorPartido());
		else
			this.getGestor().registrarEstadisticasRegulares(lista, estadisticas.getIdentificadorPartido());
	}

	//getters & setters
	private Logger getLog() {
		return log;
	}


	private GestorEstadisticas getGestor() {
		return gestor;
	}


	private void setGestor(GestorEstadisticas gestor) {
		this.gestor = gestor;
	}
	
	
}
