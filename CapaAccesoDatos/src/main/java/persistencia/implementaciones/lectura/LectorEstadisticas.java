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
		System.out.println("Buscando Estadisticas"); 
		Query query = session.createQuery("from EstadisticasJugadorRegularesModelo e where e.jugador = :iJugador AND  e.club = :iClub AND e.ano = :iAno");					
		query.setParameter("iJugador", jugador);
		query.setParameter("iClub", club);
		query.setParameter("iAno", year);
		Object resultado = query.uniqueResult();//se obtiene la lista del query	
		return resultado;
	}

	public Object getEstadisticaSeleccion(JugadorModelo jugador,int torneo, int year) {
		//Se obtiene la sesion
		Session session = HibernateFactory.getSessionFactory().openSession();       
		session.beginTransaction();		
		System.out.println("Buscando Estadisticas"); 
		Query query = session.createQuery("from EstadisticasJugadorSeleccionModelo e where e.jugador = :iJugador AND  e.torneo = :iTorneo AND e.ano = :iAno");					
		query.setParameter("iJugador", jugador);
		query.setParameter("iTorneo", torneo);
		query.setParameter("iAno", year);
		Object resultado = query.uniqueResult();//se obtiene la lista del query	
		return resultado;
		
					
		
	}

	@SuppressWarnings("unchecked")
	public List<Object> getEstadisticasRegularesPorJugador(JugadorModelo jugador) {
		List<Object> lista = null;
		//se obtiene la sesion
		Session session = HibernateFactory.getSessionFactory().openSession();		
		//se define el query
		Query query = session.createQuery("from EstadisticasJugadorRegularesModelo e where e.jugador.Pasaporte = :idJugador");					
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

	@SuppressWarnings("unchecked")
	public Object getPartido(Integer idPartido) {
		List<Object> lista = null;
		//se obtiene la sesion
		Session session = HibernateFactory.getSessionFactory().openSession();		
		//se define el query
		Query query = session.createQuery("from PartidoModelo e where e.id_Partido = :idP");					
		query.setParameter("idP", idPartido);
		//se obtiene la lista del query
		lista = query.list();
		//Se obtiene el objecto Partido resultante
		return lista.get(0);
	}

}
