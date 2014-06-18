package persistencia.implementaciones.lectura;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;


import modelos.recursos.EstadisticasJugadorRegularesModelo;
import modelos.recursos.EstadisticasJugadorSeleccionModelo;
import modelos.recursos.JugadorModelo;

import persistencia.interfaces.LectorEstadisticasDAO;
import persistencia.utilidades.hibernate.HibernateFactory;

public class LectorEstadisticas implements LectorEstadisticasDAO{

	
	public Object getEstadisticaRegular(JugadorModelo jugador,int club, int year) {
		//Se obtiene la sesion
		Session session = HibernateFactory.getSessionFactory().openSession();       
        session.beginTransaction();
        
        //Se crea un objeto de Estadisticas que sera utilizado para realizar la busqueda segun los parametros de ingreso.
		EstadisticasJugadorRegularesModelo estadisticasBusqueda = new EstadisticasJugadorRegularesModelo();
		estadisticasBusqueda.setJugador(jugador);
		estadisticasBusqueda.setClub(club);
		estadisticasBusqueda.setAno(year);
		
		//Se realiza la busqueda utilizando el objeto de Estadisticas creado anteriormente.
		Object estadisticasResultado = session.get(EstadisticasJugadorRegularesModelo.class, estadisticasBusqueda);
			
		return estadisticasResultado;
	}

	public Object getEstadisticaSeleccion(JugadorModelo jugador,int torneo, int year) {
		//Se obtiene la sesion
		Session session = HibernateFactory.getSessionFactory().openSession();       
		session.beginTransaction();
		        
		//Se crea un objeto de Estadisticas que sera utilizado para realizar la busqueda segun los parametros de ingreso.
		EstadisticasJugadorSeleccionModelo estadisticasBusqueda = new EstadisticasJugadorSeleccionModelo();
		estadisticasBusqueda.setJugador(jugador);
		estadisticasBusqueda.setTorneo(torneo);
		estadisticasBusqueda.setAno(year);
				
		//Se realiza la busqueda utilizando el objeto de Estadisticas creado anteriormente.
		Object estadisticasResultado = session.get(EstadisticasJugadorRegularesModelo.class, estadisticasBusqueda);
					
		return estadisticasResultado;
	}

	@SuppressWarnings("unchecked")
	public List<Object> getEstadisticasRegularesPorJugador(JugadorModelo jugador) {
		List<Object> lista = null;
		//se obtiene la sesion
		Session session = HibernateFactory.getSessionFactory().openSession();		
		//se define el query
		Query query = session.createQuery("from EstadisticasJugadorRegularesModelo e where e.jugador.pasaporte = :idJugador");					
		Integer identificacion = jugador.getPasaporte();
		query.setParameter("idJugador", identificacion);
		lista = query.list();//se obtiene la lista del query		
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<Object> getEstadisticasSeleccionPorJugador(JugadorModelo jugador) {
		List<Object> lista = null;
		//se obtiene la sesion
		Session session = HibernateFactory.getSessionFactory().openSession();		
		//se define el query
		Query query = session.createQuery("from EstadisticasJugadorSeleccionModelo e where e.jugador.pasaporte = :idJugador");					
		Integer identificacion = jugador.getPasaporte();
		query.setParameter("idJugador", identificacion);
		lista = query.list();//se obtiene la lista del query		
		return lista;
	}

}
