package com.Pruebas;

import java.util.List;


import accesos.recursos.AccesoDatosTorneos;

public class PruebaMain {

	public static void main(String[] args) {
		AccesoDatosTorneos torneos = new AccesoDatosTorneos();
		List<Object> resultado = torneos.darListaRecursos("clubes");
		System.out.println(resultado.get(0).toString());
	}

}
