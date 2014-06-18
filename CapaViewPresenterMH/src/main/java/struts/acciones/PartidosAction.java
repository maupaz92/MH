package struts.acciones;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelos.recursos.EquipoModelo;
import modelos.recursos.PartidoModelo;

import org.jboss.resteasy.logging.Logger;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
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
	
	private String idEquipo1;
	private String idEquipo2;
	private int golesEquipo1;
	private int golesEquipo2;
	private String fechaPartido;
	private String estadisticasEquipo1;
	private String estadisticasEquipo2;
	
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
			this.setTipoTorneoConfigurado(this.getTipoTorneoSeleccionado());
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
	
	
	public String registrarPartido(){						
		//Se obtiene la fecha de nacimiento del textbox correspondiente. 
		DateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
		Date fechaPartidoRegistrado = null;		
		try {
			fechaPartidoRegistrado = formateador.parse(this.getFechaPartido());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.crearEstadisticas();
		PartidoModelo partido = new PartidoModelo();
		partido.setEquipoA(Integer.parseInt(this.getIdEquipo1()));
		partido.setEquipoB(Integer.parseInt(this.getIdEquipo2()));
		partido.setMarcadorA(this.getGolesEquipo1());
		partido.setMarcadorB(this.getGolesEquipo2());
		partido.setFecha(fechaPartidoRegistrado);
		
		this.limpiarCamposPartido();
		return "vistaRegistrarPartido";
	}

	
	/**
	 * metodo que limpia el formulario de partido despues de un 
	 * registro
	 */
	private void limpiarCamposPartido(){
		this.setGolesEquipo1(0);
		this.setGolesEquipo2(0);
		this.setFechaPartido("");
		
	}
	
	
	/**
	 * 
	 */
	private void crearEstadisticas(){
		
		String[] estadisticasJugadoresEquipo1 = this.getEstadisticasEquipo1().split("-");
		for (String string : estadisticasJugadoresEquipo1) {
			this.getLOG().info(string);
			ObjectMapper mapeo = new ObjectMapper();
			mapeo.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		}
		
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

	public String getIdEquipo1() {
		return idEquipo1;
	}

	public void setIdEquipo1(String idEquipo1) {
		this.idEquipo1 = idEquipo1;
	}

	public int getGolesEquipo1() {
		return golesEquipo1;
	}

	public void setGolesEquipo1(int golesEquipo1) {
		this.golesEquipo1 = golesEquipo1;
	}

	public int getGolesEquipo2() {
		return golesEquipo2;
	}

	public void setGolesEquipo2(int golesEquipo2) {
		this.golesEquipo2 = golesEquipo2;
	}

	public String getIdEquipo2() {
		return idEquipo2;
	}

	public void setIdEquipo2(String idEquipo2) {
		this.idEquipo2 = idEquipo2;
	}

	public String getFechaPartido() {
		return fechaPartido;
	}

	public void setFechaPartido(String fechaPartido) {
		this.fechaPartido = fechaPartido;
	}

	public String getEstadisticasEquipo1() {
		return estadisticasEquipo1;
	}

	public void setEstadisticasEquipo1(String estadisticasEquipo1) {
		this.estadisticasEquipo1 = estadisticasEquipo1;
	}

	public String getEstadisticasEquipo2() {
		return estadisticasEquipo2;
	}

	public void setEstadisticasEquipo2(String estadisticasEquipo2) {
		this.estadisticasEquipo2 = estadisticasEquipo2;
	}

}
