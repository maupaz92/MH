package com.HibernateUtil;

import java.util.List;

import modelos.recursos.TorneoModelo;
import accesos.recursos.AccesoDatosTorneos;

public class PruebaMain {

	public static void main(String[] args) {		
		AccesoDatosTorneos torneos = new AccesoDatosTorneos();
		List<Object> resultado= torneos.darListaRecursos(false);
		System.out.println(resultado.toString());
	}

}
