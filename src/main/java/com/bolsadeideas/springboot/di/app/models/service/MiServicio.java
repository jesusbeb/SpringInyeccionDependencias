package com.bolsadeideas.springboot.di.app.models.service;

//Por ahora no usamos inyeccion de independencias, por lo tanto no haremos anotacion para que sea manejado por Spring
public class MiServicio {
	
	public String operacion() {
		
		return "ejecutando algun proceso importante...";
	}

}
