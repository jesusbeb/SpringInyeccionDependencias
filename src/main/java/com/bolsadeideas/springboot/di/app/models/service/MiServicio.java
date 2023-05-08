package com.bolsadeideas.springboot.di.app.models.service;

import org.springframework.context.annotation.Primary;
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
//a los componentes le podemos dar un nombre para identificarlo de otras clases concretas que esten
//implementando el metodo operacion. Con @Primary especificamos cual es la principal a ejecutarse si no
//se especifica cuando llaman a la interface desde el controlador.
//Se puede prescindir de Primary y usar Qualifier desde el controlador para indicar que servicio llamar
@Component("miServicioSimple")
@Primary
public class MiServicio implements IServicio {
	
	//Override indica que se esta sobreescribiendo un metodo de una interface de la que se esta heredando
	@Override
	public String operacion() {
		return "ejecutando algun proceso importante simple...";
	}
	
}

//ahora que el servicio implementa de la interfaz se puede inyectar del tipo generico


