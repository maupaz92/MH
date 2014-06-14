package logica;

import java.util.ArrayList;
import java.util.List;

import persistencia.implementaciones.actualizaciones.ActualizadorTorneos;
import persistencia.implementaciones.escritura.Registrador;
import persistencia.implementaciones.lectura.LectorTorneos;
import persistencia.interfaces.ActualizadorDAO;
import persistencia.interfaces.LectorTorneosDAO;
import persistencia.interfaces.RegistradorDAO;
import modelos.recursos.TorneoModelo;

/**
 * 
 * @author Mauricio Paz
 *
 */
public class GestorTorneos {

	private LectorTorneosDAO lectorTorneos;
	private RegistradorDAO registradorObjetosBD;
	private ActualizadorDAO actualizadorObjetosBD;
	
	public GestorTorneos()
	{
		lectorTorneos = new LectorTorneos();
		registradorObjetosBD = new Registrador();
		actualizadorObjetosBD = new ActualizadorTorneos();
	}
	
	/**
	 * metodo encargado de verificar y registrar un nuevo torneo.
	 * Se valida que el torneo no haya sido registro previamente.
	 * @param torneo: torneo a ser registrado
	 * @return: true si el torneo pudo ser registrado, false en caso contrario
	 */
	public boolean registrarNuevoTorneo(TorneoModelo torneo){
		boolean respuesta = false;
		
		//se obtiene un objeto tipo torneo para verificar si ya existe
		TorneoModelo torneoPrueba = (TorneoModelo) this.getLectorTorneos().getTorneoPorNombre(torneo.getNombre());
		//si el torneo no existe
		if(torneoPrueba == null){
			//se registra el ingreso
			this.getRegistradorObjetosBD().guardarNuevoRecurso(torneo);			
			respuesta = true;
		}		
		return respuesta;
	}
	
	/**
	 * metodo que actualiza los datos de un torneo existente. Entra como parametro
	 * el torneo que se desea modificar con sus datos actualizados.
	 * @param torneo
	 * @return
	 * True en caso de que el torneo ingresado exista previamente en la BD y ademas
	 * que su nombre no sea igual a otro ya registrado. False en cualquiera de los casos contrarios
	 */
	public boolean modificarTorneo(TorneoModelo torneo)
	{		
		//torneo original, previo a cambios
		TorneoModelo torneoOriginal = (TorneoModelo) this.getLectorTorneos().getTorneoPorId(torneo.getId());
		//torneo prueba para verificar si el nombre ya existe
		TorneoModelo torneoPrueba = (TorneoModelo) this.getLectorTorneos().getTorneoPorNombre(torneo.getNombre());
		
		//no se ppuede obtener el torneo original por el id no existe
		if(torneoOriginal == null){
			return false;
			//tirar excepcion de que no existe
		}	
		//si el torneo modificado cambia a un nombre de otro torneo ocupado
		if(torneoPrueba != null && torneo.getId() != torneoPrueba.getId()){
			//tirar excepcion de que torneo con ese nombre ya existe
			return false;						
		}
		//se reemplazan los datos del torneo actualizado por los viejos
		torneoOriginal.reemplazarDatos(torneo);
		//se efectua el cambio
		this.getActualizadorObjetosBD().actualizarRecurso(torneoOriginal);				
		return true;
	}
	
	
	/**
	 * 
	 * @return
	 * Metodo que retorna una lista con los torneos que han sido registrados
	 * en el sistema. Se retorna una lista con objetos tipo {@link TorneoModelo}
	 */
	public List<TorneoModelo> getTorneosRegistrados(){		
		//se obtiene la lista de la bd
		List<Object> listaSinFormato = this.getLectorTorneos().getTorneosRegistrados();
		//se construye la nueva lista con formato
		List<TorneoModelo> listaTorneos = new ArrayList<TorneoModelo>();
		for (Object object : listaSinFormato) {
			//se castean los objetos de la lista recuperada
			TorneoModelo torneo = (TorneoModelo) object;			
			listaTorneos.add(torneo);
		}
		return listaTorneos;
	}
	
	/**
	 * 
	 * @param deTipoSelecciones
	 * @return
	 * Metodo que retorna una lista de torneos segun el tipo especificado
	 * en el parametro. Si la bandera es true se retornan los de tipo seleccion,
	 * si es false se retornan los torneos de clubes. Se retorna una lista con 
	 * objetos tipo {@link TorneoModelo}
	 */
	public List<TorneoModelo> getTorneosPorTipo(boolean deTipoSelecciones){	
		//se obtiene la lista de la bd
		List<Object> listaSinFormato = this.getLectorTorneos().getTorneosPorTipo(deTipoSelecciones);
		//se construye la nueva lista con formato
		List<TorneoModelo> listaTorneos = new ArrayList<TorneoModelo>();
		for (Object object : listaSinFormato) {
			//se castean los objetos de la lista recuperada
			TorneoModelo torneo = (TorneoModelo) object;			
			listaTorneos.add(torneo);
		}
		return listaTorneos;
	}	

	private LectorTorneosDAO getLectorTorneos() {
		return lectorTorneos;
	}
	

	private RegistradorDAO getRegistradorObjetosBD() {
		return registradorObjetosBD;
	}

	private ActualizadorDAO getActualizadorObjetosBD() {
		return actualizadorObjetosBD;
	}
	
	
}
