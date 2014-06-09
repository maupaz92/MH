package com.HibernateUtil;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import modelos.recursos.JugadorModelo;
import modelos.recursos.TorneoModelo;
import accesos.recursos.AccesoDatos;
import accesos.recursos.AccesoDatosTorneos;

public class PruebaMain {

	public static void main(String[] args) {	
		JugadorModelo jugador= new JugadorModelo();
		jugador.setPasaporte(1);
		jugador.setAltura(173.4);
		jugador.setEquipoActual(3);
		jugador.setEstado(true);
		jugador.setFechaNacimiento("Hola");
		jugador.setNombre("Ronaldo");
		jugador.setPeso(65.4);
		jugador.setPosicion("Delantero");
		
		
		
		
		
	
		 

}
}