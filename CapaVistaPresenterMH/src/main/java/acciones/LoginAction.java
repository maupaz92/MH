package acciones;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	
	
	private static final long serialVersionUID = 1L;
	
	
	public String perfil()
	{				
		return "perfil";
	}	

	public String login()
	{
		return "login";
	}

}
