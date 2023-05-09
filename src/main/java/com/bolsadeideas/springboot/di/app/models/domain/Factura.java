package com.bolsadeideas.springboot.di.app.models.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class Factura {

	@Value("${factura.descripcion}") //inyectamos como valor desde application.properties
	private String descripcion;
	
	@Autowired //inyectamos
	private Cliente cliente;
	
	@Autowired //inyectamos directamente desde AppConfig. Si tuvieramos mas de una implementacion, usariamos Primary o Quialifier
	private List<ItemFactura> items;
	
	//Ciclo de vida del componente: PostConstruct y PreDestroy
	//Por ejemplo con PostConstruct implementamos un metodo para inicializar un componente justo despues
	//de que el contenedor de Spring instancie el objeto. P.e. con el nombre del cliente
	@PostConstruct
	public void inicializar() {
		cliente.setNombre(cliente.getNombre().concat(" ").concat("B")); //mantenemos el nombre original del cliente y le concatenamos algo
		descripcion = descripcion.concat(" del cliente: ").concat(cliente.getNombre()); //aparte de concatenar, asignamos el valor a descripcion
	}
	
	//metodo para destruir. PreDestroy por defecto es singleton y durara lo que dura la aplicacion, se ejecutara hasta que bajemos la app
	//se puede igual cambiar eso
	@PreDestroy
	public void destruir() {
		System.out.println("Factura Destruida: ".concat(descripcion));
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public List<ItemFactura> getItems() {
		return items;
	}
	
	public void setItems(List<ItemFactura> items) {
		this.items = items;
	}
}
