package persistencia.implementaciones.lectura;

import java.util.List;

import modelos.recursos.EquipoModelo;

import org.hibernate.Query;
import org.hibernate.Session;

import persistencia.interfaces.LectorEquiposDAO;
import persistencia.utilidades.hibernate.HibernateFactory;

public class LectorEquipos implements LectorEquiposDAO{

	public Object getEquipo(int idEquipo) {
		Session session = HibernateFactory.getSessionFactory().openSession();       
        session.beginTransaction();
        Object torneoResultado = session.get(EquipoModelo.class, idEquipo);       
        session.getTransaction().commit();     			
		return torneoResultado;
	}

	public Object getEquipo(String nombre, int idPais) {		
		//se obtiene la sesion
		Session session = HibernateFactory.getSessionFactory().openSession();		
		//se define el query
		Query query = session.createQuery("from EquipoModelo e where e.nombre = ? and e.pais.id_Pais = ?");
		query.setParameter(0, nombre);
		query.setParameter(1, idPais);
		@SuppressWarnings("unchecked")
		List<Object> lista = query.list();//se obtiene la lista del query
		Object equipo = null;
		if(!lista.isEmpty()){
			equipo = lista.get(0);
		}			
		return equipo;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Object> getEquiposRegistrados() {
	
		List<Object> lista = null;
		//se obtiene la sesion
		Session session = HibernateFactory.getSessionFactory().openSession();		
		//se define el query
		Query query = session.createQuery("from EquipoModelo");					
		lista = query.list();//se obtiene la lista del query		
		return lista;
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
