package struts.acciones;

import java.util.ArrayList;
import java.util.List;

import org.jboss.resteasy.logging.Logger;

import com.opensymphony.xwork2.ActionSupport;


/**
 * 
 * @author Mauricio Paz
 *
 */
public class PartidosAction extends ActionSupport{

		
	private static final long serialVersionUID = 1L;
	private List<String> listaEquipos;
	private String identificadorTorneoSeleccionado;	
	private String nombreTorneoSeleccionado;
	private String identificadorTorneoConfigurado;
	private String nombreTorneoConfigurado;
	private String tituloTorneoConfigurado;
	private final Logger LOG = Logger.getLogger(PartidosAction.class);
	
	
	public PartidosAction(){
		listaEquipos = new ArrayList<String>();
		this.setTituloTorneoConfigurado("");
		
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
			this.setNombreTorneoConfigurado(this.getNombreTorneoConfigurado());
			this.setIdentificadorTorneoConfigurado(this.getIdentificadorTorneoSeleccionado());
			this.setTituloTorneoConfigurado(this.getNombreTorneoConfigurado());
			this.
			listaEquipos.add("mauricio");
			listaEquipos.add("joven");
			this.setNombreTorneoSeleccionado("");
			this.setIdentificadorTorneoSeleccionado("");
			
		}else
			LOG.info("No se cargan equipos porque no hay seleccion de torneos");
		return "vistaRegistrarPartido";
	}
	

	
	//getters & setters
	public List<String> getListaEquipos() {
		return listaEquipos;
	}

	public void setListaEquipos(List<String> listaEquipos) {
		this.listaEquipos = listaEquipos;
	}

	public String getIdentificadorTorneoSeleccionado() {
		return identificadorTorneoSeleccionado;
	}

	public void setIdentificadorTorneoSeleccionado(String identificadorTorneoSeleccionado) {
		this.identificadorTorneoSeleccionado = identificadorTorneoSeleccionado;
	}

	public String getNombreTorneoSeleccionado() {
		return nombreTorneoSeleccionado;
	}

	public void setNombreTorneoSeleccionado(String nombreTorneoSeleccionado) {
		this.nombreTorneoSeleccionado = nombreTorneoSeleccionado;
	}

	public String getIdentificadorTorneoConfigurado() {
		return identificadorTorneoConfigurado;
	}

	public void setIdentificadorTorneoConfigurado(
			String identificadorTorneoConfigurado) {
		this.identificadorTorneoConfigurado = identificadorTorneoConfigurado;
	}

	public String getNombreTorneoConfigurado() {
		return nombreTorneoConfigurado;
	}

	public void setNombreTorneoConfigurado(String nombreTorneoConfigurado) {
		this.nombreTorneoConfigurado = nombreTorneoConfigurado;
	}

	public String getTituloTorneoConfigurado() {
		return tituloTorneoConfigurado;
	}

	public void setTituloTorneoConfigurado(String tituloTorneoConfigurado) {
		this.tituloTorneoConfigurado = tituloTorneoConfigurado;
	}
	
}
