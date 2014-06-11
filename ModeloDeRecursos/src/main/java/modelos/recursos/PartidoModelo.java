package modelos.recursos;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PartidoModelo {

	private String torneo;
	private int equipoA;
	private int equipoB;
	private int marcadorA;
	private int marcadorB;
	private Date fecha;
	
	public PartidoModelo()
	{
		
	}
	@XmlAttribute
	public String getTorneo() {
		return torneo;
	}

	public void setTorneo(String torneo) {
		this.torneo = torneo;
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
