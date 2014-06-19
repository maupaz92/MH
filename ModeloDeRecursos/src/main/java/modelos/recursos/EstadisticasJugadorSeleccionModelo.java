package modelos.recursos;

import java.io.Serializable;

/**
 * Clase que modela una entidad Estadisticas
 *  de Jugador en Selección por año y torneo. 
 * @author DiegoJ
 *
 */

public class EstadisticasJugadorSeleccionModelo implements Serializable{
	
	/**
	 * 
	 */
	
	/**
	 * Se hace referencia al jugador al que pertenece el objeto EstadisticaJugadorSelecciónModelo.
	 * Actúa como una FK a nivel de base de datos. 
	 *  */
	
	private static final long serialVersionUID = 8289733517215125165L;
	private JugadorModelo jugador;

	private int torneo;
	
	private double nota_XFIFA;


	
	private int juegos_Totales;
	private int juegos_Ganados;	
	private int juegos_Perdidos;
	private int juegos_Empatados;
	
	private int goles_Anotados;	
	private int minutos_Jugados;
	private int balones_Recuperados;	
	private int asistencias;
	private int tiros_Marco;
	private int tarjetas_amarillas;
	private int tarjetas_rojas;
	private int penales_Cometidos;
	private int penales_Detenidos;
	private int remates_Salvados;
	private int ano;
	
	public EstadisticasJugadorSeleccionModelo(){}
	
	
	public EstadisticasJugadorSeleccionModelo(EstadisticaParcial estadistica)
	{
		this.goles_Anotados = estadistica.getGolesAnotados();
		this.minutos_Jugados = estadistica.getMinutosJugados();
		this.balones_Recuperados = estadistica.getBalonesRecuperados();
		this.asistencias = estadistica.getAsistencias();
		this.tiros_Marco = estadistica.getTirosMarco();
		this.tarjetas_amarillas = estadistica.getTarjetasAmarillas();
		this.tarjetas_rojas = estadistica.getTarjetasRojas();
		this.penales_Cometidos = estadistica.getPenalesCometidos();
		this.penales_Detenidos = estadistica.getPenalesDetenidos();
		this.remates_Salvados = estadistica.getRematesSalvados();
		this.ano = estadistica.getAno();
		this.setJuegos_Empatados(0);
		this.setJuegos_Ganados(0);
		this.setJuegos_Perdidos(0);
		this.setJuegos_Totales(0);
		
	}
	
	//----------getters & setters
	

	public JugadorModelo getJugador() {
		return jugador;
	}
	public void setJugador(JugadorModelo jugador) {
		this.jugador = jugador;
	}
	public int getTorneo() {
		return torneo;
	}
	public void setTorneo(int torneo) {
		this.torneo = torneo;

	}
	
	public double getNota_XFIFA() {
		return this.nota_XFIFA;
	}	
	
	public void setNota_XFIFA(double nota_XFIFA) {
		this.nota_XFIFA = nota_XFIFA;
	}
	public int getJuegos_Totales() {
		return juegos_Totales;
	}
	public void setJuegos_Totales(int juegos_Totales) {
		this.juegos_Totales = juegos_Totales;
	}
	public int getGoles_Anotados() {
		return goles_Anotados;
	}
	public void setGoles_Anotados(int goles_Anotados) {
		this.goles_Anotados = goles_Anotados;
	}
	public int getJuegos_Ganados() {
		return juegos_Ganados;
	}
	public void setJuegos_Ganados(int juegos_Ganados) {
		this.juegos_Ganados = juegos_Ganados;
	}
	public int getJuegos_Perdidos() {
		return juegos_Perdidos;
	}
	public void setJuegos_Perdidos(int juegos_Perdidos) {
		this.juegos_Perdidos = juegos_Perdidos;
	}
	public int getJuegos_Empatados() {
		return juegos_Empatados;
	}
	public void setJuegos_Empatados(int juegos_Empatados) {
		this.juegos_Empatados = juegos_Empatados;
	}
	public int getMinutos_Jugados() {
		return minutos_Jugados;
	}
	public void setMinutos_Jugados(int minutos_Jugados) {
		this.minutos_Jugados = minutos_Jugados;
	}
	public int getBalones_Recuperados() {
		return balones_Recuperados;
	}
	public void setBalones_Recuperados(int balones_Recuperados) {
		this.balones_Recuperados = balones_Recuperados;
	}
	public int getAsistencias() {
		return asistencias;
	}
	public void setAsistencias(int asistencias) {
		this.asistencias = asistencias;
	}
	public int getTiros_Marco() {
		return tiros_Marco;
	}
	public void setTiros_Marco(int tiros_Marco) {
		this.tiros_Marco = tiros_Marco;
	}
	
	public int getTarjetas_amarillas() {
		return tarjetas_amarillas;
	}

	public void setTarjetas_amarillas(int tarjetas_amarillas) {
		this.tarjetas_amarillas = tarjetas_amarillas;
	}

	public int getTarjetas_rojas() {
		return tarjetas_rojas;
	}

	public void setTarjetas_rojas(int tarjetas_rojas) {
		this.tarjetas_rojas = tarjetas_rojas;
	}

	public int getPenales_Cometidos() {
		return penales_Cometidos;
	}
	public void setPenales_Cometidos(int penales_Cometidos) {
		this.penales_Cometidos = penales_Cometidos;
	}
	public int getPenales_Detenidos() {
		return penales_Detenidos;
	}
	public void setPenales_Detenidos(int penales_Detenidos) {
		this.penales_Detenidos = penales_Detenidos;
	}
	public int getRemates_Salvados() {
		return remates_Salvados;
	}
	public void setRemates_Salvados(int remates_Salvados) {
		this.remates_Salvados = remates_Salvados;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	
}
