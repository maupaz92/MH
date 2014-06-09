package accesos.recursos;



import org.hibernate.Session;

import com.HibernateUtil.HibernateUtil;

public abstract class AccesoDatos {

	
	
	/**
	 * Metodo común para crear un nuevo registro en la base
	 * de datos.
	 */
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
	}
	
	private Boolean existeTorneoRegistrado(String identificador)
	{
		return true;
		
	}
	
	
}