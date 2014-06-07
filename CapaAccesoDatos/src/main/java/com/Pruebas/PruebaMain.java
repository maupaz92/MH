package com.Pruebas;

import org.hibernate.Session;

import modelos.recursos.TorneoModelo;

public class PruebaMain {

	public static void main(String[] args) {
		
		TorneoModelo torneo1= new TorneoModelo();
		torneo1.setNombre("Liga Española");
		torneo1.setSede("España");
		torneo1.setTipo("Clubes");
		torneo1.setCopa(true);
		
		 //Get Session
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        //start transaction
        session.beginTransaction();
        //Save the Model object
        session.save(torneo1);
        //Commit transaction
        session.getTransaction().commit();
        System.out.println("Torneo ID="+torneo1.getNombre());
         
        //terminate session factory, otherwise program won't end
        HibernateUtil.getSessionFactory().close();

	}

}
