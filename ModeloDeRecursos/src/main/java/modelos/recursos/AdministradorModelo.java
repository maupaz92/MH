package modelos.recursos;

import java.io.Serializable;

public class AdministradorModelo implements Serializable{

		/**
	 * 
	 */
	private static final long serialVersionUID = 2942086991978961492L;
	private int id_Administrador;
	private String userName;
	private String password;
	
	public int getId_Administrador() {
		return id_Administrador;
	}
	public void setId_Administrador(int id_Administrador) {
		this.id_Administrador = id_Administrador;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
