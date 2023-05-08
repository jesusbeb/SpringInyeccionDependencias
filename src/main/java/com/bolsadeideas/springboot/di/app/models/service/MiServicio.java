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

/*
//Convertimos la clase a componente de Spring con esta anotacion
//Tambien se puede usar la notacion Service, solo para identificar que es un servicio, la funcion es la misma
@Component
public class MiServicio {
	
	public String operacion() {
		
		return "ejecutando algun proceso importante...";
	}
}
*/

//Implementamos el metodo operacion de la interfaz IServicio
//a los componentes le podemos dar un nombre para identificarlo, pero como tenemos una sola implementacion
//no seria necesario ya que inyectara la primera que encuentre
@Component("miServicioSimple")
public class MiServicio implements IServicio {
	
	//Override indica que se esta sobreescribiendo un metodo de una interface de la que se esta heredando
	@Override
	public String operacion() {
		return "ejecutando algun proceso importante";
	}
	
}

//ahora que el servicio implementa de la interfaz se puede inyectar del tipo generico


