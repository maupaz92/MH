package modelos.recursos;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class PartidoModelo {

	private Integer id_Partido;
	private Integer id_Torneo;
	private Integer equipoA;
	private Integer equipoB;
	private Integer marcadorA;
	private Integer marcadorB;
	private Date fecha;
	
	public PartidoModelo()
	{
		/*
		id_Partido = new Integer(1);
		id_Torneo = new Integer(1);
		equipoA = new Integer(1);
		equipoB = new Integer(1);
		marcadorA = new Integer(1);
		marcadorB = new Integer(1);
		*/
	}		
	
	@XmlAttribute
	public Integer getId_Partido() {
		return id_Partido;
	}

	public void setId_Partido(int id_Partido) {
		this.id_Partido = id_Partido;
	}
	
	@XmlAttribute	
	public Integer getId_Torneo() {
		return id_Torneo;
	}
	public void setId_Torneo(int id_Torneo) {
		this.id_Torneo = id_Torneo;
	}

	@XmlAttribute
	public Integer getEquipoA() {
		return equipoA;
	}
	public void setEquipoA(int equipoA) {
		this.equipoA = equipoA;
	}
	
	@XmlAttribute
	public Integer getEquipoB() {
		return equipoB;
	}
	public void setEquipoB(int equipoB) {
		this.equipoB = equipoB;
	}
	
	@XmlAttribute
	public Integer getMarcadorA() {
		return marcadorA;
	}
	public void setMarcadorA(int marcadorA) {
		this.marcadorA = marcadorA;
	}

	@XmlAttribute
	public Integer getMarcadorB() {
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
	
	
	@Override
	public String toString() {	
		return "Id partido: "+id_Partido+" id torneo: "+id_Torneo+" id equipo A: "+equipoA+" id equipo B "+equipoB+" marcador A: "+marcadorA+
				" marcador B: "+marcadorB+" fecha: "+fecha;
	}
	
}
