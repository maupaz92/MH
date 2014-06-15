package struts.acciones;

import java.util.ArrayList;
import java.util.List;

import org.jboss.resteasy.logging.Logger;

import com.opensymphony.xwork2.ActionSupport;

import comunicacion.servicios.clientes.rest.ClienteRESTEquipos;
import comunicacion.servicios.interfaces.ConsultasEquipos;
import modelos.recursos.EquipoModelo;
import modelos.recursos.PaisModelo;


public class EquiposAction extends ActionSupport{


	private static final long serialVersionUID = 1L;

	private List<PaisModelo> listaPaises;
	private EquipoModelo equipo;
	private String esClub;
	private String paisDeEquipo;
	private final Logger log = Logger.getLogger(EquiposAction.class);
	
	
	public EquiposAction(){
		setListaPaises(new ArrayList<PaisModelo>());
	}
	
	/**
	 * metodo que se llama para cargar inicialmente la vista para registrar un nuevo
	 * equipo. Se encarga de "llenar" el dropdown para seleccionar el pais del equipo
	 * @return
	 * El nombre del "tile" que se debe desplegar
	 */
	public String vistaRegistrarEquipo(){
		
		PaisModelo CR = new PaisModelo();
		CR.setId_Pais(1);
		CR.setNombre("Costa Rica");
		PaisModelo brasil = new PaisModelo();
		brasil.setId_Pais(2);
		brasil.setNombre("Brasil");
		this.getListaPaises().add(brasil);
		this.getListaPaises().add(CR);
		return "vistaRegistrarEquipo";
	}
	
	/**
	 * metodo que se invoca cuando el usuario confirma el registro
	 * de un nuevo equipo. Se obtienen los datos ingresados por el usuario y 
	 * se delega el trabajo a la parte de comunicacion para que envie el nuevo registro.
	 * @return
	 * Nombre de la vista que debe de desplegarse despues del registro. Se vuelve
	 * a retornar a la vista de registros para agregar equipos
	 */
	public String registrarEquipo(){
		
		//se inicia el valor por defecto
		this.getEquipo().setTipoClub(false);
		//se valida si es de clubes o seleccion
		if(this.getEsClub().equalsIgnoreCase("si"))			
			this.getEquipo().setTipoClub(true);
				
		//se crea una representacion de pais
		PaisModelo paisSeleccionado = new PaisModelo();
		//se obtiene el id del pais seleccionado
		int idPais = Integer.parseInt(this.getPaisDeEquipo());
		paisSeleccionado.setId_Pais(idPais);		
		this.getEquipo().setPais(paisSeleccionado);		
		log.info(this.getEquipo().toString());
		//se crea el cliente y se delega el trabajo
		ConsultasEquipos consulta = new ClienteRESTEquipos();
		consulta.enviarRegistroDeEquipo(this.getEquipo());
		return "vistaRegistrarEquipo";
	}
	

	//getters & setters
	public List<PaisModelo> getListaPaises() {
		return listaPaises;
	}

	public void setListaPaises(List<PaisModelo> listaPaises) {
		this.listaPaises = listaPaises;
	}

	public EquipoModelo getEquipo() {
		return equipo;
	}

	public void setEquipo(EquipoModelo equipo) {
		this.equipo = equipo;
	}

	public String getEsClub() {
		return esClub;
	}

	public void setEsClub(String esClub) {
		this.esClub = esClub;
	}

	public String getPaisDeEquipo() {
		return paisDeEquipo;
	}

	public void setPaisDeEquipo(String paisDeEquipo) {
		this.paisDeEquipo = paisDeEquipo;
	}
}
