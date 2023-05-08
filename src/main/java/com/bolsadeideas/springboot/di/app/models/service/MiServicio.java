package com.bolsadeideas.springboot.di.app.models.service;

import org.springframework.stereotype.Component;

/*
//Por ahora no usamos inyeccion de independencias, por lo tanto no haremos anotacion para que sea manejado por Spring
public class MiServicio {
	
	public String operacion() {
		
		return "ejecutando algun proceso importante...";
	}
}
*/

//Convertimos la clase a componente de Spring con esta anotacion
//Tambien se puede usar la notacion Service, solo para identificar que es un servicio, la funcion es la misma
@Component
public class MiServicio {
	
	public String operacion() {
		
		return "ejecutando algun proceso importante...";
	}
}