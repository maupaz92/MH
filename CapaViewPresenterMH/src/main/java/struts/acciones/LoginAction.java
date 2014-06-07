package struts.acciones;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String usuario;
	private String password;
	
	public String perfil()
	{		
		/*
		addActionError("algo malo");
		setear las propiedades del usuario a null
		return "loginTile";
		*/
		return "perfil";
	}	
	
	/*
	 * metodo para retornar un tile, retorna el 
	 * nombre tile como esta definido en el tiles.xml, el nombre del metodo
	 * y el string de retorno deben de tener el mismo nombre
	 * @return: nombre del tile para mostrar pantalla de login
	 */
	public String login()
	{
		return "login";
	}
		
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
