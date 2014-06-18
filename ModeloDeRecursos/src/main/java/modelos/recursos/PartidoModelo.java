package modelos.recursos;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PartidoModelo {

	private int id_Partido;
	private int id_Torneo;
	private int equipoA;
	private int equipoB;
	private int marcadorA;
	private int marcadorB;
	private Date fecha;
	
	public PartidoModelo()
	{
		
	}
	
	@XmlAttribute	
	public int getId_Partido() {
		return id_Partido;
	}


	public void setId_Partido(int id_Partido) {
		this.id_Partido = id_Partido;
	}


	
	@XmlAttribute	
	public int getId_Torneo() {
		return id_Torneo;
	}
	public void setId_Torneo(int id_Torneo) {
		this.id_Torneo = id_Torneo;
	}

	@XmlAttribute
	public int getEquipoA() {
		return equipoA;
	}
	public void setEquipoA(int equipoA) {
		this.equipoA = equipoA;
	}
	
	@XmlAttribute

	public int getEquipoB() {
		return equipoB;
	}
	public void setEquipoB(int equipoB) {
		this.equipoB = equipoB;
	}
	
	@XmlAttribute
	public int getMarcadorA() {
		return marcadorA;
	}
	public void setMarcadorA(int marcadorA) {
		this.marcadorA = marcadorA;
	}

	@XmlAttribute

	public int getMarcadorB() {
		return marcadorB;
	}
	public void setMarcadorB(int marcadorB) {
		this.marcadorB = marcadorB;
	}

	@XmlAttribute


	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
	
	
}
