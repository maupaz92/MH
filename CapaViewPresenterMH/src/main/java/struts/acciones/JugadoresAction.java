package struts.acciones;

import java.util.ArrayList;
import java.util.List;

import modelos.recursos.JugadorModelo;
import modelos.recursos.PaisModelo;

import org.jboss.resteasy.logging.Logger;

import com.opensymphony.xwork2.ActionSupport;

import comunicacion.servicios.clientes.rest.ClienteRESTEquipos;
import comunicacion.servicios.interfaces.ConsultasEquipos;

public class JugadoresAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private final Logger log = Logger.getLogger(JugadoresAction.class);
	private JugadorModelo jugador;
	private ConsultasEquipos clienteEquipos;
	
	private String fechaNacimiento;
	private String pais;
	private String equipo;
	private String activo;
	private List<PaisModelo> listaPaises;
	
	public JugadoresAction(){
		//se inicia el cliente de equipos
		setClienteEquipos(new ClienteRESTEquipos());
		//se instancia la lista para los paises
		setListaPaises(new ArrayList<PaisModelo>());
		//se agrega un objeto vacio para evitar los objetos NULL
		this.getListaPaises().add(new PaisModelo());
	}
	
	/**
	 * 
	 * @return
	 */
	public String vistaRegistrarJugador(){
		//log.info(jugador.toString());
		this.cargarListaDePaises();
		return "vistaRegistrarJugador";
	}
	
	public String registrarJugador(){
		log.info(jugador.toString());
		return "vistaRegistrarJugador";
	}
	
	
	
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
	
	
}
