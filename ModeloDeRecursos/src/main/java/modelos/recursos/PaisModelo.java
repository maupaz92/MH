package modelos.recursos;

import java.io.Serializable;

public class PaisModelo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1097810009845723069L;
	private int id_Pais;
	private String nombre;
	
	public PaisModelo(){}
	
	public int getId_Pais() {
		return id_Pais;
	}

	public void setId_Pais(int id_Pais) {
		this.id_Pais = id_Pais;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
