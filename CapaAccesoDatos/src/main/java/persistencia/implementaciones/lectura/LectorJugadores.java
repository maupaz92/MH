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
		//se obtiene la sesion
		Session session = HibernateFactory.getSessionFactory().openSession();
		//se define el query
		Query query = session.createQuery("from JugadorModelo e where e.equipoActual.id_Equipo = :idEquipo");
		query.setParameter("idEquipo", idEquipo);			
		@SuppressWarnings("unchecked")
		List<Object> list = query.list();//se obtiene la lista del query
		return list;
	}

	public List<Object> getJugadoresPorSeleccion(int idEquipo) {
		int Pais = getIdPaisPorEquipo(idEquipo);
		Session session = HibernateFactory.getSessionFactory().openSession();
		Query queryJugadores = session.createQuery("from JugadorModelo a where a.pais.id_Pais = :idP");
		queryJugadores.setInteger("idP", Pais);	
		@SuppressWarnings("unchecked")
		List<Object> list = queryJugadores.list();//se obtiene la lista del query*/		
		return list;
	}
	
	private Integer getIdPaisPorEquipo(int idEquipo)
	  {
		  	//se obtiene la sesion
			Session session = HibernateFactory.getSessionFactory().openSession();
			//se define el query
			Query query = session.createQuery("Select pais.id_Pais from EquipoModelo e where e.id_Equipo = :idEquipo");
			query.setParameter("idEquipo", idEquipo);	
			//Se obtiene el identificador del Pais al que pertenece el Equipo Consultado. 
			Integer idPais = (Integer) query.list().get(0);	
			return idPais;
		  
	  }
	
	
	public Integer getSeleccionJugador(int pasaporte)
	{
		Session session = HibernateFactory.getSessionFactory().openSession();
		
		//Obtener idPais para el jugador
		Query query = session.createQuery("Select pais.id_Pais from JugadorModelo a where a.Pasaporte = :idJugador");
		query.setInteger("idJugador", pasaporte);	
		@SuppressWarnings("unchecked")
		Integer idPais = (Integer)query.list().get(0);//se obtiene la lista del query*/	
		
		
		//Obtener NombrePais para el idPais
		Query query1 = session.createQuery("Select nombre from PaisModelo e where e.id_Pais = :idP");
		query1.setInteger("idP", idPais);	
		@SuppressWarnings("unchecked")
		String nombrePais = (String) query1.list().get(0);//se obtiene la lista del query*/	
		
		
		//Obtener idEquipo para el pais especifico
		Query query2 = session.createQuery("Select id_Equipo from EquipoModelo d where d.nombre = :name");
		query2.setParameter("name", nombrePais);	
		@SuppressWarnings("unchecked")
		Integer idTeam = (Integer) query2.list().get(0);//se obtiene la lista del query*/	
		return idTeam;
				
	}

}
