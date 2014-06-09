package accesos.recursos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import accesos.dao.TorneosDAO;
import accesos.excepciones.RecursoRepetidoException;
import accesos.excepciones.TorneoRepetidoException;

import com.HibernateUtil.HibernateUtil;

import modelos.recursos.TorneoModelo;

public class AccesoDatosTorneos extends AccesoDatos implements TorneosDAO{

	public List<Object> getTorneosRegistrados() {
		Boolean tipo = new Boolean(true);
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("from TorneoModelo where tipoSelecciones = :tipo ");
		query.setParameter("tipo", tipo);
		@SuppressWarnings("unchecked")
		List<Object> list = query.list();
		return list;
		
	}

	private Boolean existeTorneoRegistrado(String identificador) {
		
		Boolean resultado;
        Session session = HibernateUtil.getSessionFactory().openSession();       
        session.beginTransaction();        
        TorneoModelo torneoResultado = (TorneoModelo) session.get(TorneoModelo.class, identificador);       
        session.getTransaction().commit();     
		if (torneoResultado!=null){
			resultado = true;
			}
		else
		{
			resultado = false;
		}
		return resultado;
	}

	public void modificarTorneo(TorneoModelo torneo) {
		 //Get Session
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaccion = null;
       
        try
        {
        	transaccion = session.beginTransaction();
        	TorneoModelo torneoActual = (TorneoModelo) session.get(TorneoModelo.class, torneo.getNombre());
        	torneoActual.setTipoSelecciones(torneo.getTipoSelecciones());
        	torneoActual.setSede(torneo.getSede());
        	torneoActual.setCopa(torneo.isCopa());
        	session.update(torneoActual);
        	transaccion.commit();       	
        }catch(HibernateException e)
        {      	
        	if(transaccion!=null) transaccion.rollback();
        	e.printStackTrace();
        }     
		
	}
	
	@Override
	public void crearRecurso(Object objeto) throws RecursoRepetidoException {
		TorneoModelo torneo = (TorneoModelo) objeto;
		Boolean existe = existeTorneoRegistrado(torneo.getNombre());
		if(existe)
		{
			throw new TorneoRepetidoException("El torneo: " +torneo.getNombre() +" ya existe en la base de datos");		
		}
		else
		{
			super.crearRecurso(objeto);
		}
	}


	
	/*
	
	@Override
	/*public Object darRecurso(String identificador) {
		 //Get Session
        Session session = HibernateUtil.getSessionFactory().openSession();
        //start transaction
        session.beginTransaction();
        //Save the Model object
        TorneoModelo torneoResultado = (TorneoModelo) session.get(TorneoModelo.class, identificador);
        //Commit transaction
        session.getTransaction().commit();              
      
		return torneoResultado;
	}

		
	*/
	


}
