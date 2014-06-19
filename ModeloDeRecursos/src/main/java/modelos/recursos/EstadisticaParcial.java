package modelos.recursos;

import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.internal.txw2.annotation.XmlElement;

/**
 * clase que modela los datos que se obtienen cuando
 * se registra manualmente las estadisticas para un partido.
 * @author Mauricio Paz
 *
 */

@XmlRootElement
public class EstadisticaParcial {

	
	private int pasaporteJugador;	
	private int idTorneoEquipo;
	private int ano;	
	private int golesAnotados;	
	private int minutosJugados;
	private int balonesRecuperados;
	private int asistencias;
	private int tirosMarco;
	private int tarjetasAmarillas;
	private int tarjetasRojas;
	private int penalesCometidos;
	private int penalesDetenidos;
	private int rematesSalvados;
	

	public EstadisticaParcial(){
		
	}

	@Override
	public String toString() {
	
		return "Pasaporte Jugador: "+pasaporteJugador+" id TorneoEquipo: "+idTorneoEquipo+" year: "+ano+" goles: "+golesAnotados
				+" minutos jugados: "+minutosJugados+" recuperaciones: "+balonesRecuperados+" asistencias: "+asistencias+" tiros a marcos: "+tirosMarco+" amarillas: "+tarjetasAmarillas+
				" rojas: "+tarjetasRojas+" penal comentidos: "+penalesCometidos+" penales detenidos: "+penalesDetenidos+" remates salvados: "+
				rematesSalvados;
			
	}

	//getters & setters
	
	@XmlElement
	public int getPasaporteJugador() {
		return pasaporteJugador;
	}


	public void setPasaporteJugador(int pasaporteJugador) {
		this.pasaporteJugador = pasaporteJugador;
	}


	@XmlElement
	public int getAno() {
		return ano;
	}


	public void setAno(int ano) {
		this.ano = ano;
	}

	@XmlElement
	public int getGolesAnotados() {
		return golesAnotados;
	}


	public void setGolesAnotados(int golesAnotados) {
		this.golesAnotados = golesAnotados;
	}
	
	@XmlElement
	public int getMinutosJugados() {
		return minutosJugados;
	}


	public void setMinutosJugados(int minutosJugados) {
		this.minutosJugados = minutosJugados;
	}

	@XmlElement
	public int getBalonesRecuperados() {
		return balonesRecuperados;
	}


	public void setBalonesRecuperados(int balonesRecuperados) {
		this.balonesRecuperados = balonesRecuperados;
	}

	@XmlElement
	public int getAsistencias() {
		return asistencias;
	}


	public void setAsistencias(int asistencias) {
		this.asistencias = asistencias;
	}

	@XmlElement
	public int getTirosMarco() {
		return tirosMarco;
	}


	public void setTirosMarco(int tirosMarco) {
		this.tirosMarco = tirosMarco;
	}

	@XmlElement
	public int getTarjetasAmarillas() {
		return tarjetasAmarillas;
	}


	public void setTarjetasAmarillas(int tarjetasAmarillas) {
		this.tarjetasAmarillas = tarjetasAmarillas;
	}

	@XmlElement
	public int getTarjetasRojas() {
		return tarjetasRojas;
	}


	public void setTarjetasRojas(int tarjetasRojas) {
		this.tarjetasRojas = tarjetasRojas;
	}

	@XmlElement
	public int getPenalesCometidos() {
		return penalesCometidos;
	}


	public void setPenalesCometidos(int penalesCometidos) {
		this.penalesCometidos = penalesCometidos;
	}

	@XmlElement
	public int getPenalesDetenidos() {
		return penalesDetenidos;
	}


	public void setPenalesDetenidos(int penalesDetenidos) {
		this.penalesDetenidos = penalesDetenidos;
	}

	@XmlElement
	public int getRematesSalvados() {
		return rematesSalvados;
	}


	public void setRematesSalvados(int rematesSalvados) {
		this.rematesSalvados = rematesSalvados;
	}

	@XmlElement
	public int getIdTorneoEquipo() {
		return idTorneoEquipo;
	}


	public void setIdTorneoEquipo(int idTorneoEquipo) {
		this.idTorneoEquipo = idTorneoEquipo;
	}
	
	
	
	
}
