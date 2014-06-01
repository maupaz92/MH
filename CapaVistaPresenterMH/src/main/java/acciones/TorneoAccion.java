package acciones;

import modelos.recursos.TorneoModelo;
import clientes.ClienteTorneos;

import com.opensymphony.xwork2.ActionSupport;

/**
 * clase encargada de ejecutar las acciones sobre los recursos torneos.
 * obtener datos del formulario de un nuevo torneo, obtener los datos
 * para actualizar un torneo existente
 * @author maupaz92
 *
 */
public class TorneoAccion extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TorneoModelo torneo;
	private String esCopaTorneo;
	private ClienteTorneos clienteTorneos;
	
	/**
	 * metodo encargado de obtener los datos del formulario
	 * para registrar un nuevo torneo.
	 * @return SUCCESS cuando el torneo se registro correctamente
	 */
	public String registrarNuevoTorneo()
	{	
		//se le define al objeto torneo inicialmente la bandera de copa como false
		//debido a que no ha sido iniciado previamente
		this.getTorneo().setCopa(false);
		//se compara si en el formulario se selecciono "si" para el dato de esDeCopa?
		if(this.getEsCopaTorneo().equalsIgnoreCase("si"))			
			this.getTorneo().setCopa(true);	
		clienteTorneos = new ClienteTorneos();
		clienteTorneos.enviarRegistroNuevoTorneo(getTorneo());
		clienteTorneos.enviarSolcitudTorneosRegistrados();
		return SUCCESS;
	}
	
	public void validate()
	{			
	}

	//--------------getters
	
	public TorneoModelo getTorneo() {
		return torneo;
	}	
	
	public String getEsCopaTorneo() {
		return esCopaTorneo;
	}

	//--------------getters
	public void setTorneo(TorneoModelo torneo) {
		this.torneo = torneo;
	}
	
	public void setEsCopaTorneo(String esCopaTorneo) {
		this.esCopaTorneo = esCopaTorneo;
	}	
	
}



















