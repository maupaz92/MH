package com.HibernateUtil;

import java.util.List;

import modelos.recursos.TorneoModelo;
import accesos.recursos.AccesoDatosTorneos;

public class PruebaMain {

	public static void main(String[] args) {
		TorneoModelo torneonuevo= new TorneoModelo();
		torneonuevo.setNombre("Australia 2030");
		torneonuevo.setSede("Australia");
		torneonuevo.setTipoSelecciones(true);
		torneonuevo.setCopa(true);
		AccesoDatosTorneos torneos = new AccesoDatosTorneos();
		torneos.crearRecurso(torneonuevo);
	}

}
