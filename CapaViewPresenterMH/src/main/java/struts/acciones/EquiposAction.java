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
	private final Logger log = Logger.getLogger(EquiposAction.class);
	
	private List<PaisModelo> listaPaises;	
	private String esClub;
	private String paisDeEquipo;
	
	private EquipoModelo equipo;
	private ConsultasEquipos cliente;
	
	
	
	public EquiposAction(){
		cliente = new ClienteRESTEquipos();
		setListaPaises(new ArrayList<PaisModelo>());
		//se agrega un objeto vacio para evitar los objetos NULL
		this.getListaPaises().add(new PaisModelo());
		log.info("creado un nuevo actionEquipos");
	}
	
	/**
	 * metodo que se llama para cargar inicialmente la vista para registrar un nuevo
	 * equipo. Se encarga de "llenar" el dropdown para seleccionar el pais del equipo
	 * @return
	 * El nombre del "tile" que se debe desplegar
	 */
	public String vistaRegistrarEquipo(){
		//se obtiene la lista de paises
		List<PaisModelo> lista = this.getCliente().getPaises();
		if(lista == null){
			//si se obtiene nulo, se despliega el mensaje de error del cliente
			this.addActionError(this.getCliente().getMensajeError());
		}else{
			setListaPaises(lista);
		}			
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
		//se obtiene el id del pais seleccionado en el dropdown
		int idPais = Integer.parseInt(this.getPaisDeEquipo());
		//se le define el id al objeto pais
		paisSeleccionado.setId_Pais(idPais);
		//se define el objeto pais al objeto equipo
		this.getEquipo().setPais(paisSeleccionado);
		log.info(this.getEquipo().toString());
		
		
		//se envia el registro
		boolean envioRegistro = this.getCliente().enviarRegistroDeEquipo(this.getEquipo());
		//si el registro es fallido
		if(!envioRegistro){
			this.addActionError(this.getCliente().getMensajeError());
		}
		//se limpia el campo para que no aparezca de nuevo el nombre
		this.getEquipo().setNombre("");		
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

	private ConsultasEquipos getCliente() {
		return cliente;
	}

	
}
