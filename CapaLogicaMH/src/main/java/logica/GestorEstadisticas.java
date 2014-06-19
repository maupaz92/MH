package logica;


import java.io.Serializable;
import java.util.List;

import modelos.recursos.EstadisticaParcial;
import modelos.recursos.EstadisticasJugadorRegularesModelo;
import modelos.recursos.EstadisticasJugadorSeleccionModelo;
import modelos.recursos.JugadorModelo;
import modelos.recursos.PartidoModelo;
import persistencia.implementaciones.actualizaciones.Actualizador;
import persistencia.implementaciones.escritura.Registrador;
import persistencia.implementaciones.lectura.LectorEstadisticas;
import persistencia.implementaciones.lectura.LectorJugadores;
import persistencia.interfaces.ActualizadorDAO;
import persistencia.interfaces.LectorEstadisticasDAO;
import persistencia.interfaces.LectorJugadoresDAO;
import persistencia.interfaces.RegistradorDAO;


public class GestorEstadisticas {
	
	private RegistradorDAO registradorObjetosBD;
	private LectorEstadisticasDAO lectorEstadisticas;
	private ActualizadorDAO actualizadorObjetosBD;
	private LectorJugadoresDAO lectorJugadores;
	
	

	public GestorEstadisticas()
	{
		setRegistradorObjetosBD(new Registrador());
		setLectorEstadisticas(new LectorEstadisticas());
		setActualizadorObjetosBD(new Actualizador());
		setLectorJugadores(new LectorJugadores());
	}

	/**
	 * 
	 * @param partido
	 * @return
	 * Metodo utilizado para registrar un partido y obtener el identificador 
	 */
	public Integer guardarPartido(PartidoModelo partido)
	{
		this.getRegistradorObjetosBD().guardarNuevoRecurso(partido);
		Serializable idPartido = this.getRegistradorObjetosBD().getIdentificadorObjeto();
		
		Integer resultado = (Integer)idPartido;
		return resultado;
	}
		
	/**
	 * 
	 * @param estadisticaNueva
	 * @param partido
	 * @return
	 * Metodo para registrar Estadisticas Regulares de un Jugador en la base de datos.
	 */
	public void registrarEstadisticasRegulares(List<EstadisticaParcial> estadisticasParciales, Integer idPartido)
	{
		PartidoModelo partido = (PartidoModelo) this.getLectorEstadisticas().getPartido(idPartido);
			
		for(int i=0;i<estadisticasParciales.size();i++)
		{
			
			EstadisticaParcial e = estadisticasParciales.get(i);
			System.out.println("pasaporte"+e.getPasaporteJugador());
			JugadorModelo jugador = (JugadorModelo) this.getLectorJugadores().getJugador(e.getPasaporteJugador());
			Boolean existeEstadistica = existeEstadisticaRegularEspecifica(jugador,e.getIdTorneoEquipo(),e.getAno());
			if(existeEstadistica)
			{
				//Obtener EstadisticaEspecifica
				EstadisticasJugadorRegularesModelo estadisticasOld = (EstadisticasJugadorRegularesModelo) this.getLectorEstadisticas().
						getEstadisticaRegular(jugador, e.getIdTorneoEquipo(), e.getAno());
				
				//Sumar campo por campo estadisticasRegistradas + las estadisticas recibidas
				calcularEstadisticasRegulares(estadisticasOld,e);
				
				//Calcular partido ganado, empatado o perdido.
				analizarMarcadorRegulares(partido,jugador,estadisticasOld);
				
				//Calcular NotaXFIFA
				calcularNotaXFIFARegulares(estadisticasOld);
				
				//Hacer update
				this.getActualizadorObjetosBD().actualizarRecurso(estadisticasOld);
			}
			else
			{
				//Crear EstadisticasJugadorRegularesModelo a partir de la EstadisticaParcial
				EstadisticasJugadorRegularesModelo nuevaEstadistica = new EstadisticasJugadorRegularesModelo(e);
				nuevaEstadistica.setJugador(jugador);
				nuevaEstadistica.setClub(e.getIdTorneoEquipo());
				nuevaEstadistica.setAno(e.getAno());
				nuevaEstadistica.setJuegos_Totales(nuevaEstadistica.getJuegos_Totales()+1);
				//Calcular partidoganado, empatado o perdido
				analizarMarcadorRegulares(partido,jugador,nuevaEstadistica);
				//Calcular NotaXFIFA
				calcularNotaXFIFARegulares(nuevaEstadistica);
				//Se hace Save y se guarda la nueva estadistica
				this.getRegistradorObjetosBD().guardarNuevoRecurso(nuevaEstadistica);
				
			}
		}
								
	}
	
	/**
	 * 
	 * @param estadisticasParciales
	 * @param idPartido
	 * Metodo para registrar Estadisticas Regulares de un Jugador en la base de datos.
	 */
	public void registrarEstadisticasSeleccion(List<EstadisticaParcial> estadisticasParciales, Integer idPartido)
	{
		
		PartidoModelo partido = (PartidoModelo) this.getLectorEstadisticas().getPartido(idPartido);	
		System.out.println("TAMAÑO LISTA: "+estadisticasParciales.size());
		
		for(int i=0;i<estadisticasParciales.size();i++)
		{
			
			EstadisticaParcial e = estadisticasParciales.get(i);
			JugadorModelo jugador = (JugadorModelo) this.getLectorJugadores().getJugador(e.getPasaporteJugador());
			System.out.println("Pasaporte: "+e.getPasaporteJugador());
			System.out.println("Año: "+e.getAno());
			Boolean existeEstadistica = existeEstadisticaSeleccionEspecifica(jugador,e.getIdTorneoEquipo(), e.getAno());
			System.out.println(existeEstadistica.toString());
			if(existeEstadistica)
			{
				System.out.println("SI EXISTE");
				//Obtener EstadisticaEspecifica
				EstadisticasJugadorSeleccionModelo estadisticasOld = (EstadisticasJugadorSeleccionModelo) this.getLectorEstadisticas().getEstadisticaSeleccion(jugador, e.getIdTorneoEquipo(), e.getAno());
					
				
				//Sumar campo por campo estadisticasRegistradas + las estadisticas recibidas
				calcularEstadisticasSeleccion(estadisticasOld,e);
				
				//Calcular partido ganado, empatado o perdido.
				analizarMarcadorSeleccion(partido,jugador,estadisticasOld);
				
				//Calcular NotaXFIFA
				calcularNotaXFIFASeleccion(estadisticasOld);
				
				//Hacer update
				this.getActualizadorObjetosBD().actualizarRecurso(estadisticasOld);
			}
			else
			{
				//Crear EstadisticasJugadorRegularesModelo a partir de la EstadisticaParcial
				EstadisticasJugadorSeleccionModelo nuevaEstadistica = new EstadisticasJugadorSeleccionModelo(e);
				nuevaEstadistica.setJugador(jugador);
				nuevaEstadistica.setTorneo(e.getIdTorneoEquipo());
				nuevaEstadistica.setJuegos_Totales(nuevaEstadistica.getJuegos_Totales()+1);
				//Calcular partidoganado, empatado o perdido
				analizarMarcadorSeleccion(partido,jugador,nuevaEstadistica);
				//Calcular NotaXFIFA
				calcularNotaXFIFASeleccion(nuevaEstadistica);
				//Se hace Save y se guarda la nueva estadistica
				this.getRegistradorObjetosBD().guardarNuevoRecurso(nuevaEstadistica);
				
			}
		}
		
	}
	
	
	
	/**
	 * @param jugador
	 * @param equipo
	 * @param year
	 * @return
	 * Metodo para verificar si existe una estadistica regular especifica para una combinacion jugador, equipo y año.
	 */
	private boolean existeEstadisticaRegularEspecifica(JugadorModelo jugador, int equipo, int year)
	{
		Object resultado = this.getLectorEstadisticas().getEstadisticaRegular(jugador, equipo, year);
				
		if(resultado!=null)
		{			
			return true;
		}else{
		
		return false;
		}
		
	}
	
	/**
	 * 
	 * @param jugador
	 * @param torneo
	 * @param year
	 * @return
	 * Metodo para verificar si existe una estadistica registrada para un combinacion jugador, torneo y año.
	 */
	private boolean existeEstadisticaSeleccionEspecifica(JugadorModelo jugador, int torneo, int year)
	{

		Object resultado = new Object();
		resultado = this.getLectorEstadisticas().getEstadisticaSeleccion(jugador, torneo, year);
		
		if(resultado!=null)
		{
			return true;
			
		}else{
			return false;
		
		}	
		
	}
	
	/**
	 * 
	 * @param antiguas
	 * @param nuevas
	 * metodo para realizar la suma de las estadisticas existentes con las nuevas. 
	 */
	private void calcularEstadisticasRegulares(EstadisticasJugadorRegularesModelo antiguas, EstadisticaParcial nuevas)
	{
		antiguas.setAsistencias(antiguas.getAsistencias()+nuevas.getAsistencias());
		antiguas.setBalones_Recuperados(antiguas.getBalones_Recuperados()+nuevas.getBalonesRecuperados());
		antiguas.setGoles_Anotados(antiguas.getGoles_Anotados()+nuevas.getGolesAnotados());
		antiguas.setJuegos_Totales(antiguas.getJuegos_Totales()+1);
		antiguas.setMinutos_Jugados(antiguas.getMinutos_Jugados()+nuevas.getMinutosJugados());
		antiguas.setPenales_Cometidos(antiguas.getPenales_Cometidos()+nuevas.getPenalesCometidos());
		antiguas.setPenales_Detenidos(antiguas.getPenales_Detenidos()+nuevas.getPenalesDetenidos());
		antiguas.setRemates_Salvados(antiguas.getRemates_Salvados()+nuevas.getRematesSalvados());
		antiguas.setTarjetas_Amarillas(antiguas.getTarjetas_Amarillas()+nuevas.getTarjetasAmarillas());
		antiguas.setTarjetas_Rojas(antiguas.getTarjetas_Rojas()+nuevas.getTarjetasRojas());
		antiguas.setTiros_Marco(antiguas.getTiros_Marco()+nuevas.getTirosMarco());
	}

	/**
	 * 
	 * @param antiguas
	 * @param nuevas
	 *  metodo para realizar la suma de las estadisticas existentes con las nuevas.
	 */
	private void calcularEstadisticasSeleccion(EstadisticasJugadorSeleccionModelo antiguas, EstadisticaParcial nuevas)
	{
		antiguas.setAsistencias(antiguas.getAsistencias()+nuevas.getAsistencias());
		antiguas.setBalones_Recuperados(antiguas.getBalones_Recuperados()+nuevas.getBalonesRecuperados());
		antiguas.setGoles_Anotados(antiguas.getGoles_Anotados()+nuevas.getGolesAnotados());
		antiguas.setJuegos_Totales(antiguas.getJuegos_Totales()+1);
		antiguas.setMinutos_Jugados(antiguas.getMinutos_Jugados()+nuevas.getMinutosJugados());
		antiguas.setPenales_Cometidos(antiguas.getPenales_Cometidos()+nuevas.getPenalesCometidos());
		antiguas.setPenales_Detenidos(antiguas.getPenales_Detenidos()+nuevas.getPenalesDetenidos());
		antiguas.setRemates_Salvados(antiguas.getRemates_Salvados()+nuevas.getRematesSalvados());
		antiguas.setTarjetas_amarillas(antiguas.getTarjetas_amarillas()+nuevas.getTarjetasAmarillas());
		antiguas.setTarjetas_rojas(antiguas.getTarjetas_rojas()+nuevas.getTarjetasRojas());
		antiguas.setTiros_Marco(antiguas.getTiros_Marco()+nuevas.getTirosMarco());
	}
	
	/**
	 * 
	 * @param partido
	 * @param jugador
	 * @param antiguas
	 * Metodo utilizado para verificar si sumar uno a Partidos Ganadas, Empatados o Perdidos
	 */
	private void analizarMarcadorRegulares(PartidoModelo partido, JugadorModelo jugador, EstadisticasJugadorRegularesModelo antiguas)
	{
		int equipoJugador = jugador.getEquipoActual().getId_Equipo();
		int equipoA = partido.getEquipoA();
		int equipoB = partido.getEquipoB();
		int marcadorA = partido.getMarcadorA();
		int marcadorB = partido.getMarcadorB();
		
		if(equipoJugador==equipoA && marcadorA>marcadorB)
		{
			antiguas.setJuegos_Ganados(antiguas.getJuegos_Ganados()+1);
			
		}
		if((equipoJugador==equipoA || equipoJugador==equipoB) && marcadorA==marcadorB)
		{
			antiguas.setJuegos_Empatados(antiguas.getJuegos_Empatados()+1);
						
		}
		if(equipoJugador==equipoA && marcadorA<marcadorB)
		{
			antiguas.setJuegos_Perdidos(antiguas.getJuegos_Perdidos()+1);					
		}
		if(equipoJugador==equipoB && marcadorB>marcadorA)
		{
			antiguas.setJuegos_Ganados(antiguas.getJuegos_Ganados()+1);			
		}
		
	}
	
	/**
	 * 
	 * @param partido
	 * @param jugador
	 * @param antiguas
	 * Metodo utilizado para verificar si sumar uno a Partidos Ganadas, Empatados o Perdidos
	 */
	private void analizarMarcadorSeleccion(PartidoModelo partido, JugadorModelo jugador, EstadisticasJugadorSeleccionModelo antiguas)
	{
		int equipoJugador = this.getLectorJugadores().getSeleccionJugador(jugador.getPasaporte());
		int equipoA = partido.getEquipoA();
		int equipoB = partido.getEquipoB();
		int marcadorA = partido.getMarcadorA();
		int marcadorB = partido.getMarcadorB();
		System.out.println("equipoJugador "+equipoJugador);
		System.out.println("EquipoA "+equipoA);
		System.out.println("EquipoB "+equipoB);
		
		if(equipoJugador==equipoA && marcadorA>marcadorB)
		{
			antiguas.setJuegos_Ganados(antiguas.getJuegos_Ganados()+1);
			
		}
		if((equipoJugador==equipoA || equipoJugador==equipoB) && marcadorA==marcadorB)
		{
			antiguas.setJuegos_Empatados(antiguas.getJuegos_Empatados()+1);
						
		}
		if(equipoJugador==equipoA && marcadorA<marcadorB)
		{
			antiguas.setJuegos_Perdidos(antiguas.getJuegos_Perdidos()+1);					
		}
		if(equipoJugador==equipoB && marcadorB>marcadorA)
		{
			antiguas.setJuegos_Ganados(antiguas.getJuegos_Ganados()+1);
			
		}
	}
	
	
	/**
	 * Metodo Utilizado para el calculo de la nota XFIFA segun un conjunto de estadisticas Regulares.
	 * @param estadisticas
	 */
	private void calcularNotaXFIFARegulares(EstadisticasJugadorRegularesModelo estadisticas)
	{
		int goles = (estadisticas.getGoles_Anotados()*25);
		int tirosMarco = (estadisticas.getTiros_Marco()*5);
		int asistencias = (estadisticas.getAsistencias()*15);
		int balonesRecuperados = (estadisticas.getBalones_Recuperados()*10);
		int penalesDetenidos = (estadisticas.getPenales_Detenidos()*25);
		int rematesSalvados = (estadisticas.getRemates_Salvados()*20);
		int totalMinutos = estadisticas.getMinutos_Jugados();
		double coeficienteGanador = (estadisticas.getJuegos_Ganados()/estadisticas.getJuegos_Totales());
		double resultado = (goles+tirosMarco+asistencias+balonesRecuperados+penalesDetenidos+rematesSalvados)/(totalMinutos+coeficienteGanador);
		
		estadisticas.setNota_XFIFA(resultado);
				
				
		
	}
	
	
	/**
	 * Metodo Utilizado para el calculo de la nota XFIFA segun un conjunto de estadisticas de Seleccion.
	 * @param estadisticas
	 */
	private void calcularNotaXFIFASeleccion(EstadisticasJugadorSeleccionModelo estadisticas)
	{
		int goles = (estadisticas.getGoles_Anotados()*25);
		int tirosMarco = (estadisticas.getTiros_Marco()*5);
		int asistencias = (estadisticas.getAsistencias()*15);
		int balonesRecuperados = (estadisticas.getBalones_Recuperados()*10);
		int penalesDetenidos = (estadisticas.getPenales_Detenidos()*25);
		int rematesSalvados = (estadisticas.getRemates_Salvados()*20);
		int totalMinutos = estadisticas.getMinutos_Jugados();
		double coeficienteGanador = (estadisticas.getJuegos_Ganados()/estadisticas.getJuegos_Totales());
		double resultado = (goles+tirosMarco+asistencias+balonesRecuperados+penalesDetenidos+rematesSalvados)/(totalMinutos+coeficienteGanador);
		
		estadisticas.setNota_XFIFA(resultado);
				
				
		
	}
	
	
	
	//getters & settters
	public RegistradorDAO getRegistradorObjetosBD() {
		return registradorObjetosBD;
	}

	public void setRegistradorObjetosBD(RegistradorDAO registradorObjetosBD) {
		this.registradorObjetosBD = registradorObjetosBD;
	}

	public LectorEstadisticasDAO getLectorEstadisticas() {
		return lectorEstadisticas;
	}

	public void setLectorEstadisticas(LectorEstadisticasDAO lectorEstadisticas) {
		this.lectorEstadisticas = lectorEstadisticas;
	}

	public ActualizadorDAO getActualizadorObjetosBD() {
		return actualizadorObjetosBD;
	}

	public void setActualizadorObjetosBD(ActualizadorDAO actualizadorObjetosBD) {
		this.actualizadorObjetosBD = actualizadorObjetosBD;
	}
	
	public LectorJugadoresDAO getLectorJugadores() {
		return lectorJugadores;
	}

	public void setLectorJugadores(LectorJugadoresDAO lectorJugadores) {
		this.lectorJugadores = lectorJugadores;
	}

}
