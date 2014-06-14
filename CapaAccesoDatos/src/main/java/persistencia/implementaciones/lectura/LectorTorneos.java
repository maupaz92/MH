package persistencia.implementaciones.lectura;

import java.util.List;

import modelos.recursos.TorneoModelo;

import org.hibernate.Query;
import org.hibernate.Session;

import persistencia.interfaces.LectorTorneosDAO;
import persistencia.utilidades.hibernate.HibernateFactory;

/**
 * clase que obtiene datos sobre torneos de la BD utilizando
 * el framework Hibernate.
 * @author Mauricio Paz
 *
 */
public class LectorTorneos implements LectorTorneosDAO{

	public LectorTorneos() {
	
	}
	
	public Object getTorneoPorNombre(String nombre) {				
        Session session = HibernateFactory.getSessionFactory().openSession();       
        session.beginTransaction();
        Object torneoResultado = session.get(TorneoModelo.class, nombre);       
        session.getTransaction().commit();     			
		return torneoResultado;
	}

	public Object getTorneoPorId(int id) {
		return null;
	}

	public List<Object> getTorneosRegistrados() {
		//se obtiene la sesion
		Session session = HibernateFactory.getSessionFactory().openSession();
		//se define el query
		Query query = session.createQuery("from TorneoModelo");	
		@SuppressWarnings("unchecked")
		List<Object> list = query.list();//se obtiene la lista del query
		return list;
	}

	public List<Object> getTorneosPorTipo(boolean deTipoSeleccion) {
		//se obtiene la sesion
		Session session = HibernateFactory.getSessionFactory().openSession();
		//se define el query
		Query query = session.createQuery("from TorneoModelo where tipoSelecciones = :tipo ");
		//se especifica los parametros desconocidos del query
		query.setParameter("tipo", deTipoSeleccion);
		@SuppressWarnings("unchecked")
		List<Object> list = query.list();
		return list;		
	}

}
