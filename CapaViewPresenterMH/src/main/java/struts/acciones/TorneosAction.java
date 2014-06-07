package struts.acciones;

import com.opensymphony.xwork2.ActionSupport;

public class TorneosAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public String registrarTorneo()
	{
		return "registrarTorneo";
	}
	
	public String editarTorneo()
	{
		return "editarTorneo";
	}

}
