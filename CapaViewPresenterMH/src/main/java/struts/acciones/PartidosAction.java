package struts.acciones;

import java.util.ArrayList;
import java.util.List;

import modelos.recursos.EquipoModelo;

import org.jboss.resteasy.logging.Logger;

import com.opensymphony.xwork2.ActionSupport;

import comunicacion.servicios.clientes.rest.ClienteRESTEquipos;
import comunicacion.servicios.interfaces.ConsultasEquipos;


/**
 * 
 * @author Mauricio Paz
 *
 */
public class PartidosAction extends ActionSupport{

		
	private static final long serialVersionUID = 1L;
	private List<String> listaEquiposParcial;
	
	private String tipoTorneoSeleccionado;	
	private String nombreTorneoSeleccionado;
	private String idTorneoSeleccionado;
	private String idTorneoConfigurado;
	private String tipoTorneoConfigurado;
	private String nombreTorneoConfigurado;
	
	private ConsultasEquipos clienteEquipos;
	private List<EquipoModelo> listaEquipos;
	
	private final Logger LOG = Logger.getLogger(PartidosAction.class);
	
	
	public PartidosAction(){
		listaEquiposParcial = new ArrayList<String>();
		setListaEquipos(new ArrayList<EquipoModelo>());
		setClienteEquipos(new ClienteRESTEquipos());
		
	}

	/**
	 * metodo para cargar el tile que muestre
	 * la interfaz para registrar un nuevo partido
	 * @return
	 */
	public String vistaRegistrarPartido(){				
		return "vistaRegistrarPartido";
	}
	
	/**
	 * metodo que se encarga de llenar los dropdown
	 * de equipos con los equipos segun el torneo seleccionado
	 * en la pantalla para registrar un nuevo partido
	 * @return
	 */
	public String cargarEquipos(){
		if(!this.getNombreTorneoSeleccionado().isEmpty()){			
			//se define el nombre del torneo a partir del seleccionado
			this.setNombreTorneoConfigurado("Torneo: "+this.getNombreTorneoSeleccionado());
			//se define el tipo del torneo a partir del seleccionado
			this.setIdTorneoConfigurado(this.getIdTorneoSeleccionado());
			//se obtiene el tipo de torneo seleccionado
			Boolean pedirEquiposTipoSeleccion = Boolean.valueOf(this.getTipoTorneoSeleccionado());			
			//se solicitan los equipos, el parametro se niega debido a la especificacion del metodo			 
			this.setListaEquipos(this.getClienteEquipos().getEquipoPorTipo(!pedirEquiposTipoSeleccion));
			
			this.setNombreTorneoSeleccionado("");
			this.setTipoTorneoSeleccionado("");
			this.setIdTorneoSeleccionado("");
			
		}else{
			this.addActionError(this.getText("error.partido.seleccionDeTorneo"));
		}			
		return "vistaRegistrarPartido";
	}
	

	
	//getters & setters
	public List<String> getListaEquiposParcial() {
		return listaEquiposParcial;
	}

	public void setListaEquiposParcial(List<String> listaEquiposParcial) {
		this.listaEquiposParcial = listaEquiposParcial;
	}

	public String getNombreTorneoSeleccionado() {
		return nombreTorneoSeleccionado;
	}

	public void setNombreTorneoSeleccionado(String nombreTorneoSeleccionado) {
		this.nombreTorneoSeleccionado = nombreTorneoSeleccionado;
	}

	public String getNombreTorneoConfigurado() {
		return nombreTorneoConfigurado;
	}

	public void setNombreTorneoConfigurado(String nombreTorneoConfigurado) {
		this.nombreTorneoConfigurado = nombreTorneoConfigurado;
	}

	private ConsultasEquipos getClienteEquipos() {
		return clienteEquipos;
	}

	private void setClienteEquipos(ConsultasEquipos clienteEquipos) {
		this.clienteEquipos = clienteEquipos;
	}

	public String getTipoTorneoSeleccionado() {
		return tipoTorneoSeleccionado;
	}

	public void setTipoTorneoSeleccionado(String tipoTorneoSeleccionado) {
		this.tipoTorneoSeleccionado = tipoTorneoSeleccionado;
	}

	public String getTipoTorneoConfigurado() {
		return tipoTorneoConfigurado;
	}

	public void setTipoTorneoConfigurado(String tipoTorneoConfigurado) {
		this.tipoTorneoConfigurado = tipoTorneoConfigurado;
	}

	
	private Logger getLOG() {
		return LOG;
	}

	public List<EquipoModelo> getListaEquipos() {
		return listaEquipos;
	}

	public void setListaEquipos(List<EquipoModelo> listaEquipos) {
		this.listaEquipos = listaEquipos;
	}

	public String getIdTorneoSeleccionado() {
		return idTorneoSeleccionado;
	}

	public void setIdTorneoSeleccionado(String idTorneoSeleccionado) {
		this.idTorneoSeleccionado = idTorneoSeleccionado;
	}

	public String getIdTorneoConfigurado() {
		return idTorneoConfigurado;
	}

	public void setIdTorneoConfigurado(String idTorneoConfigurado) {
		this.idTorneoConfigurado = idTorneoConfigurado;
	}

}
