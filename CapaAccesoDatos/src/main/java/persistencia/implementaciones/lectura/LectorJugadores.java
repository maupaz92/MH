package persistencia.implementaciones.lectura;

import java.util.List;



import modelos.recursos.JugadorModelo;

import org.hibernate.Query;
import org.hibernate.Session;

import persistencia.interfaces.LectorJugadoresDAO;
import persistencia.utilidades.hibernate.HibernateFactory;

public class LectorJugadores implements LectorJugadoresDAO{

	public Object getJugador(int pasaporte) {
		Session session = HibernateFactory.getSessionFactory().openSession();       
        session.beginTransaction();
        Object torneoResultado = session.get(JugadorModelo.class, pasaporte);       
        session.getTransaction().commit();     			
		return torneoResultado;
	}

	public List<Object> getJugadoresRegistrados() {
		//se obtiene la sesion
		Session session = HibernateFactory.getSessionFactory().openSession();
		//se define el query
		Query query = session.createQuery("from JugadorModelo");			
		@SuppressWarnings("unchecked")
		List<Object> list = query.list();//se obtiene la lista del query		
		return list;
	}

	public List<Object> getJugadoresPorClub(int idEquipo) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Object> getJugadoresPorSeleccion(int idPais) {
		// TODO Auto-generated method stub
		return null;
	}

}
