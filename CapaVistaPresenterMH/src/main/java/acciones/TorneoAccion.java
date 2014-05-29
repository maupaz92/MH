package acciones;

import modelos.recursos.TorneoModelo;

import com.opensymphony.xwork2.ActionSupport;


public class TorneoAccion extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TorneoModelo torneo;
	
		
	public String registrarNuevoTorneo()
	{
			
		
		return SUCCESS;
	}


	public TorneoModelo getTorneo() {
		return torneo;
	}

	public void setTorneo(TorneoModelo torneo) {
		this.torneo = torneo;
	}
	
	
}
