package servicio.accesos;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.logging.Logger;

import modelos.recursos.ConjuntoDeTorneosModelo;
import modelos.recursos.TorneoModelo;


/**
 * clase encargada de recibir las solicitudes http para
 * la direccion relativa "/torneos". Maneja el acceso de los recursos
 * relacionados con entidades torneo del sistema.
 * @author maupaz92
 *
 */
@Path("/torneos")
public class AccesoTorneos {
	
	private final Logger log = Logger.getLogger(AccesoTorneos.class);
	

	public AccesoTorneos()
	{
		
	}		
	
	/**
	 * metodo que retorna los torneos registrados en el sistema a traves
	 * del metodo HTTP GET.
	 * Envia el recurso por medio de representaciones en xml o json.
	 * @return
	 */
	@GET	
	@Produces({"application/json", "application/xml"})
	public ConjuntoDeTorneosModelo getTorneosRegistrados()
	{
		TorneoModelo t1 = new TorneoModelo();
		t1.setNombre("Brasil 2014");		
		t1.setTipo("selecciones");
		t1.setSede("Brasil");
		t1.setCopa(true);
		
		TorneoModelo t2 = new TorneoModelo();		
		t2.setNombre("Russia 2018");
		t2.setTipo("clubes");
		t2.setSede("Russia");
		t2.setCopa(false);
		
		ConjuntoDeTorneosModelo lista = new ConjuntoDeTorneosModelo();
		lista.agregarTorneo(t1);
		lista.agregarTorneo(t2);		
		//return Response.ok(lista).build();
		return lista;
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public void registrarNuevoTorneo(TorneoModelo torneo)
	{		
		log.info("ingresado torneo: "+torneo.getNombre());
		//throw new WebApplicationException(Response.Status.NOT_FOUND);
	}
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_XML)	
	public void modificarTorneos2(@PathParam("nombre") String nombreTorneo, TorneoModelo torneo)
	{
		
	}	
	
	
	
	
	
	
	
	
}
