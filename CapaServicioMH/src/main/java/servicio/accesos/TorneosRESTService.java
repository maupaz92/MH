package servicio.accesos;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import logica.GestorTorneos;
import modelos.recursos.ConjuntoDeTorneosModelo;
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
	 * metodo que retorna los torneos registrados en el sistema a traves
	 * del metodo HTTP GET.
	 * Envia el recurso por medio de representaciones en xml o json.
	 * @return
	 */
	@GET	
	@Produces({"application/json", "application/xml"})
	public ConjuntoDeTorneosModelo getTorneosRegistrados()
	{
		/*TorneoModelo t1 = new TorneoModelo();
		t1.setNombre("Brasil 2014");		
		t1.setTipoSelecciones(true);
		t1.setSede("Brasil");
		t1.setCopa(true);
		
		TorneoModelo t2 = new TorneoModelo();		
		t2.setNombre("Russia 2018");
		t2.setTipoSelecciones(true);
		t2.setSede("Russia");
		t2.setCopa(false);
		
		ConjuntoDeTorneosModelo lista = new ConjuntoDeTorneosModelo();
		lista.agregarTorneo(t1);
		lista.agregarTorneo(t2);
		
		return lista;*/
		return this.getGestor().getListaTorneosRegistrados();
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public void registrarNuevoTorneo(TorneoModelo torneo)
	{				
		this.getGestor().registrarNuevoTorneo(torneo);
		log.info("ingresado torneo: "+torneo.getNombre());
		//throw new WebApplicationException(Response.Status.NOT_FOUND);
	}
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_XML)	
	public void modificarTorneo(TorneoModelo torneo)
	{
		this.getGestor().modificarTorneo(torneo);
	}	
	
	
	private GestorTorneos getGestor() {
		return gestor;
	}
	
	
}
