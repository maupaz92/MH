package struts.acciones;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelos.recursos.EquipoModelo;
import modelos.recursos.JugadorModelo;
import modelos.recursos.PaisModelo;

import org.jboss.resteasy.logging.Logger;

import com.opensymphony.xwork2.ActionSupport;

import comunicacion.servicios.clientes.rest.ClienteRESTEquipos;
import comunicacion.servicios.clientes.rest.ClienteRESTJugadores;
import comunicacion.servicios.interfaces.ConsultasEquipos;
import comunicacion.servicios.interfaces.ConsultasJugadores;

public class JugadoresAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private final Logger log = Logger.getLogger(JugadoresAction.class);
	private JugadorModelo jugador;
	private ConsultasEquipos clienteEquipos;
	private ConsultasJugadores clienteJugadores;
	
	private String fechaNacimiento;
	private String pais;
	private String equipo;
	private String activo;
	private List<PaisModelo> listaPaises;
	private List<EquipoModelo> listaEquipos;
	
	public JugadoresAction(){
		//se inicia el cliente de equipos
		setClienteEquipos(new ClienteRESTEquipos());
		setClienteJugadores(new ClienteRESTJugadores());
		//se instancia la lista para los paises y equipos
		setListaPaises(new ArrayList<PaisModelo>());
		setListaEquipos(new ArrayList<EquipoModelo>());
		//se agrega un objeto vacio para evitar los objetos NULL
		this.getListaPaises().add(new PaisModelo());
		this.getListaEquipos().add(new EquipoModelo());
	}
	
	/**
	 * 
	 * @return
	 * Nombre de la vista que se debe mostrar, retorna
	 * el nombre del formulario para agregar torneo
	 */
	public String vistaRegistrarJugador(){
		//log.info(jugador.toString());
		this.cargarListaDePaises();
		this.cargarListaDeEquipos();
		return "vistaRegistrarJugador";
	}
	
	/**
	 * 
	 * @return
	 */
	public String registrarJugador(){
		
		//se cargan los datos del jugador
		this.cargarDatosJugador();
		this.getLog().info(this.getJugador().toString());
		boolean envioRegistro = this.getClienteJugadores().enviarRegistroJugador(this.getJugador());
		if(envioRegistro)
			this.limpiarCampos();	
		//si el registro es fallido
		if(!envioRegistro){
			//se despliega el mensaje de error
			this.addActionError(this.getClienteJugadores().getMensajeError());			
		}
		
		this.cargarListaDePaises();
		this.cargarListaDeEquipos();
		return "vistaRegistrarJugador";
	}
	
	/**
	 * metodo que obtiene los datos del formulario y los carga
	 * en el objeto jugador.
	 */
	private void cargarDatosJugador(){
		//se valida si el jugador es inactivo, por default es activo
		if(this.getActivo().equalsIgnoreCase("no"))
			this.getJugador().setEstado(false);			
		//se crea una representacion de pais
		PaisModelo paisSeleccionado = new PaisModelo();
		//se obtiene el id del pais seleccionado en el dropdown
		int idPais = Integer.parseInt(this.pais);
		paisSeleccionado.setId_Pais(idPais);
		//se define el objeto pais al objeto Jugador
		this.getJugador().setPais(paisSeleccionado);
		
		//Se obtiene la fecha de nacimiento del textbox correspondiente. 
		DateFormat formateador;
		Date fechaNacimientoJugador = null;
		formateador = new SimpleDateFormat("dd-MM-yyyy");
		try {
			fechaNacimientoJugador = formateador.parse(this.fechaNacimiento);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//Se define al objeto jugador la fecha de nacimiento.
		this.jugador.setFechaNacimiento(fechaNacimientoJugador);
		//Se crea una representacion de equipo
		EquipoModelo equipoJugador = new EquipoModelo();
		//Se obtiene el id del equipo seleccionado en el dropdown
		int idEquipo = Integer.parseInt(equipo);
		equipoJugador.setId_Equipo(idEquipo);
		//Se define el objeto equipo al objeto Jugador
		this.getJugador().setEquipoActual(equipoJugador);		
	}
	
	
	
	/**
	 * metodo que carga en la lista temporal de la lista
	 * de paises validos del sistema
	 */
	private void cargarListaDePaises(){
		//se obtiene la lista de paises
		List<PaisModelo> lista = this.getClienteEquipos().getPaises();
		if(lista == null){
			//si se obtiene nulo, se despliega el mensaje de error del cliente
			this.addActionError(this.getClienteEquipos().getMensajeError());
		}else{
			setListaPaises(lista);
		}
	}
	/**
	 * metodo que carga en la lista temporal de equipos
	 * los equipos tipo club registrados en el sistema
	 */
	private void cargarListaDeEquipos(){
		//se obtiene la lista de paises
		List<EquipoModelo> lista = this.getClienteEquipos().getEquipoPorTipo(true);
		if(lista == null){
			//si se obtiene nulo, se despliega el mensaje de error del cliente
			this.addActionError(this.getClienteEquipos().getMensajeError());
		}else{
			this.setListaEquipos(lista);
		}
	}
	
	/**
	 * metodo que limpia los campos del formulario luego 
	 * de una insercion o edicion exitosa
	 */
	private void limpiarCampos(){
		this.setJugador(null);
		this.setFechaNacimiento("");
	}
	
	
	//getters & setters
	public JugadorModelo getJugador() {
		return jugador;
	}
	public void setJugador(JugadorModelo jugador) {
		this.jugador = jugador;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public List<PaisModelo> getListaPaises() {
		return listaPaises;
	}

	public void setListaPaises(List<PaisModelo> listaPaises) {
		this.listaPaises = listaPaises;
	}

	private ConsultasEquipos getClienteEquipos() {
		return clienteEquipos;
	}

	private void setClienteEquipos(ConsultasEquipos clienteEquipos) {
		this.clienteEquipos = clienteEquipos;
	}

	public List<EquipoModelo> getListaEquipos() {
		return listaEquipos;
	}

	public void setListaEquipos(List<EquipoModelo> listaEquipos) {
		this.listaEquipos = listaEquipos;
	}

	private ConsultasJugadores getClienteJugadores() {
		return clienteJugadores;
	}

	private void setClienteJugadores(ConsultasJugadores clienteJugadores) {
		this.clienteJugadores = clienteJugadores;
	}

	private Logger getLog() {
		return log;
	}


	
}
