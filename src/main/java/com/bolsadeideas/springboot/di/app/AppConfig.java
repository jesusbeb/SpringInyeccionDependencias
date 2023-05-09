package com.bolsadeideas.springboot.di.app;

import java.util.Arrays;
import java.util.List;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.bolsadeideas.springboot.di.app.models.domain.ItemFactura;
import com.bolsadeideas.springboot.di.app.models.domain.Producto;
import com.bolsadeideas.springboot.di.app.models.service.IServicio;
import com.bolsadeideas.springboot.di.app.models.service.MiServicio;
import com.bolsadeideas.springboot.di.app.models.service.MiServicioComplejo;

/*
 * Esta clase nos servira para inyectar los servicios que no estan registrados en Spring
 */
@Configuration
public class AppConfig {
	
	//Si tenemos mas de una implementacion de la interfaz, le ponemos dar nombre
	@Bean("miServicioSimple")
	@Primary
	public IServicio registrarMiServicio() {
		return new MiServicio();
	}
	
	@Bean("miServicioComplejo")
	public IServicio registrarMiServicioComplejo() {
		return new MiServicioComplejo();
	}
	
	//metodo para los items de la factura
	//le damos un nombre de itemsFactura por si llegamos a tener mas Beans del tipo itemFactura
	@Bean("itemsFactura")
	public List<ItemFactura> registrarItems(){
		//Creamos dos objetos de tipo producto, dos objetos ItemFactura, asignamos los productos a
		//las lineas y las lineas las guardamos en un ArrayList
		Producto producto1 = new Producto("Camara Sony", 100);
		Producto producto2 = new Producto("Bicicleta Benotto 26", 200);
		
		ItemFactura linea1 = new ItemFactura(producto1, 2); //un itemFactura esta asocioado a un producto y la cantidad de ese producto
		ItemFactura linea2 = new ItemFactura(producto2, 4);
		
		return Arrays.asList(linea1,linea2);
	}

}
