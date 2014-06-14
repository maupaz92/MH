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
        Query query = session.createQuery("from TorneoModelo where nombre = :nombreTorneo");	
        query.setParameter("nombreTorneo", nombre);
		@SuppressWarnings("unchecked")
		List<Object> list = query.list();//se obtiene la lista del query
		Object objeto = null;
		//se verifica que la lista no este nula si el torneo no existe
		if(list.size() != 0)
			objeto = list.get(0);
		return objeto;
	}

	public Object getTorneoPorId(int id) {
		Session session = HibernateFactory.getSessionFactory().openSession();       
        session.beginTransaction();
        Object torneoResultado = session.get(TorneoModelo.class, id);       
        session.getTransaction().commit();     			
		return torneoResultado;
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
