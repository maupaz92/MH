package com.Pruebas;

import java.util.List;

import modelos.recursos.TorneoModelo;
import accesos.recursos.AccesoDatosTorneos;

public class PruebaMain {

	public static void main(String[] args) {
		TorneoModelo torneonuevo= new TorneoModelo();
		torneonuevo.setNombre("Brasil");
		torneonuevo.setSede("Brasil");
		torneonuevo.setTipo("selecciones");
		torneonuevo.setCopa(true);
		AccesoDatosTorneos torneos = new AccesoDatosTorneos();
		torneos.crearRecurso(torneonuevo);
	}

}
