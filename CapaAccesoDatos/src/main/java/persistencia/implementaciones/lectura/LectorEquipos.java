package persistencia.implementaciones.lectura;

import java.util.List;

import modelos.recursos.EquipoModelo;

import org.hibernate.Query;
import org.hibernate.Session;

import persistencia.interfaces.LectorEquiposDAO;
import persistencia.utilidades.hibernate.HibernateFactory;

public class LectorEquipos implements LectorEquiposDAO{

	public Object getEquipoPorId(int idEquipo) {
		Session session = HibernateFactory.getSessionFactory().openSession();       
        session.beginTransaction();
        Object torneoResultado = session.get(EquipoModelo.class, idEquipo);       
        session.getTransaction().commit();     			
		return torneoResultado;
	}

	public List<Object> getEquiposRegistrados() {
		//se obtiene la sesion
		Session session = HibernateFactory.getSessionFactory().openSession();
		//se define el query
		Query query = session.createQuery("from EquipoModelo");			
		@SuppressWarnings("unchecked")
		List<Object> list = query.list();//se obtiene la lista del query		
		return list;
	}

	public List<Object> getPaisesDeOrigen() {
		//se obtiene la sesion
		Session session = HibernateFactory.getSessionFactory().openSession();
		//se define el query
		Query query = session.createQuery("from PaisModelo");			
		@SuppressWarnings("unchecked")
		List<Object> list = query.list();//se obtiene la lista del query		
		return list;
	}

}
