package com.bolsadeideas.springboot.di.app.models.domain;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

/* Los distintos contextos o alcance de los componentes conocido como Scope por defecto son del tipo singleton
 * es decir mantiene una sola instancia de ese componente. Cuando es singleton no podemos tener atributos en
 * cl controlador que sean propios del usuario ya que tambien podrian ser modificados por otros usuarios o peticiones
 * La idea es que todos los objetos que inyectemos sean stateless (sin estado) 
*/

@Component
@RequestScope //cambia su ciclo de vida singleton, ahora dura lo que dura una peticion http de usuario. Cada recarga que se haga de la pagina, repetira el nombre del cliente de la factura, se tendria que hacer RequestScope a la clase Cliente para evitar esto
//@SessionScope //Dura lo que una sesion desde que se inicia y se destruye cuando cerramos el navegador (igual si ocurre un timeout o se invalida la sesion) se usa por ejemplo con un carro de compras o sistema de autentificacion
//@ApplicationScope //es muy parecido al singleton, se diferencia en que el singleton se guarda en el contexto servlet y no en el aplication context de Spring
public class Factura implements Serializable{ //se implemente serializable, que es importante para el SessionScope

	/**
	 * Hacemos que el compilador genere un serial version ID, no tiene impacto en nuestro codigo, es un
	 * atributo estatico que se maneja por debajo como un identificador de la serializacion
	 */
	private static final long serialVersionUID = 946004357128146951L;

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
