package persistencia.implementaciones.lectura;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import persistencia.interfaces.LectorEquiposDAO;
import persistencia.utilidades.hibernate.HibernateFactory;

public class LectorEquipos implements LectorEquiposDAO{

	public Object getEquipoPorId(int idTorneo) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Object> getEquiposRegistrados() {
		// TODO Auto-generated method stub
		return null;
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
