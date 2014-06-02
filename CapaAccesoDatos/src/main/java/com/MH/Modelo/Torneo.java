package com.MH.Modelo;

public class Torneo {
	
		
		private String nombre;
		
		
		private String tipo;
		private String sede;
		private Boolean copa;
		
		public Torneo(){}
		
		//----------getters & setters
		
		
		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

	
		public String getTipo() {
			return tipo;
		}

		public void setTipo(String tipo) {
			this.tipo = tipo;
		}

		
		public String getSede() {
			return sede;
		}

		public void setSede(String sede) {
			this.sede = sede;
		}

	
		public Boolean isCopa() {
			return copa;
		}

		public void setCopa(Boolean copa) {
			this.copa = copa;
		}

		
		
}
