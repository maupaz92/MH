package servicio.accesos;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.logging.Logger;

import logica.GestorJugadores;
import modelos.recursos.JugadorModelo;

@Path("/jugadores")
public class JugadoresRESTService {
	
	private final Logger log = Logger.getLogger(EquiposRESTService.class);
	private GestorJugadores gestorJugadores;
	
	public JugadoresRESTService(){
		setGestorJugadores(new GestorJugadores());
	}
	
	/**
	 * metodo que recibe las solicitudes "POST" para el path
	 * de la ruta general. Se encarga de iniciar el proceso de registro
	 * de un nuevo jugador.
	 * @param jugador
	 * Jugador que contiene los datos que se deben de registrar en el sistema
	 */
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public void registrarNuevoJugador(JugadorModelo jugador){		
		boolean registroExitoso = this.getGestorJugadores().registrarJugador(jugador);
		//si el registro no se puede llevar 
		if(!registroExitoso){			
			throw new WebApplicationException(this.getGestorJugadores().getMensajeError(), 
					Response.Status.CONFLICT);
		}
	}

	
	/**
	 * 
	 * @return
	 * Respuesta que encapsula el conjunto de jugadores que esten registrados
	 * en el sistema. La lista de equipos es enviada mediante una entidad generica
	 * {@link GenericEntity} que contiene una lista de objetos {@link JugadorModelo} en una
	 * {@link List}
	 */
	@GET
	@Produces({"application/json", "application/xml"})
	public Response getEquiposRegistrados(){
		//se obtiene la lista de equipos en el sistema
		List<JugadorModelo> jugadores = this.getGestorJugadores().getJugadoresRegistrados();
		//se construye un "wrapper" generico para enviar la lista
		GenericEntity<List<JugadorModelo>> jugadoresWrap = new GenericEntity<List<JugadorModelo>>(jugadores){};
		return Response.ok(jugadoresWrap).build();				
	}
	
	/**
	 * 
	 * @param idClub
	 * @return
	 */
	@Path("/club")
	@GET
	@Produces({"application/json", "application/xml"})
	public Response getJugadoresPorClub(
			@QueryParam("idClub") int idClub){
			
		//se obtiene la lista de equipos en el sistema
		List<JugadorModelo> jugadores = this.getGestorJugadores().getIdentificacionJugadoresPorClub(idClub);
		//se construye un "wrapper" generico para enviar la lista
		GenericEntity<List<JugadorModelo>> jugadoresWrap = new GenericEntity<List<JugadorModelo>>(jugadores){};
		return Response.ok(jugadoresWrap).build();						
	}
	
	
	@Path("/seleccion")
	@GET
	@Produces({"application/json", "application/xml"})
	public Response getJugadoresPorSeleccion(
			@QueryParam("idSeleccion") int idSeleccion){
			
		//se obtiene la lista de equipos en el sistema
		List<JugadorModelo> jugadores = this.getGestorJugadores().
				getIdentificacionJugadoresPorSeleccion(idSeleccion);
		//se construye un "wrapper" generico para enviar la lista
		GenericEntity<List<JugadorModelo>> jugadoresWrap = new GenericEntity<List<JugadorModelo>>(jugadores){};
		return Response.ok(jugadoresWrap).build();						
	}
	
	//getters & setters
	@SuppressWarnings("unused")
	private Logger getLog() {
		return log;
	}

	private GestorJugadores getGestorJugadores() {
		return gestorJugadores;
	}

	private void setGestorJugadores(GestorJugadores gestorJugadores) {
		this.gestorJugadores = gestorJugadores;
	}

}
