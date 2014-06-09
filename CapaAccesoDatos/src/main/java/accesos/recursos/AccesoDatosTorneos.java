package accesos.recursos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.HibernateUtil.HibernateUtil;

import modelos.recursos.TorneoModelo;

public class AccesoDatosTorneos extends AccesoDatos{

	@Override
	public Object darRecurso(String identificador) {
		 //Get Session
        Session session = HibernateUtil.getSessionFactory().openSession();
        //start transaction
        session.beginTransaction();
        //Save the Model object
        TorneoModelo torneoResultado = (TorneoModelo) session.get(TorneoModelo.class, identificador);
        //Commit transaction
        session.getTransaction().commit();              
        //terminate session factory, otherwise program won't end
       // HibernateUtil.getSessionFactory().close();
		return torneoResultado;
	}

	@Override
	public void modificarRecurso(Object objeto) {
		 //Get Session
        Session session = HibernateUtil.getSessionFactory().openSession();
        //start transaction
        session.beginTransaction();
        //Save the Model object
        session.save(objeto);
        //Commit transaction
        session.getTransaction().commit();              
        //terminate session factory, otherwise program won't end
        //HibernateUtil.getSessionFactory().close();
		
	}

	@Override
	public void crearRecurso(Object objeto) {
		 //Get Session
		System.out.println("CreandoRecurso");
        Session session1 = HibernateUtil.getSessionFactory().openSession();
        //start transaction
        session1.beginTransaction();
        //Save the Model object
        System.out.println("Guardando en DB");
        session1.save(objeto);
        //Commit transaction
        session1.getTransaction().commit();              
        //terminate session factory, otherwise program won't end
        //HibernateUtil.getSessionFactory().close();
		
	}

	@Override
	public List<Object> darListaRecursos(Object identificador) {
		Boolean tipo = (Boolean)identificador;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("from TorneoModelo where tipoSelecciones = :tipo ");
		query.setParameter("tipo", tipo);
		List<Object> list = query.list();
		return list;
	}

	
	


}
