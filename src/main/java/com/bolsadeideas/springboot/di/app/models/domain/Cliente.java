package com.bolsadeideas.springboot.di.app.models.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

//Hacemos esta clase componente de Spring
@Component
@RequestScope //cambiamo su ciclo de vida
public class Cliente {
	
	@Value("${cliente.nombre}") //inyectamos con value ya que es escalar. Se definira en el application.properties
	private String nombre;
	
	@Value("${cliente.apellido}") //definido igual en src/main/resources/application.properties
	private String apellido;
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}
