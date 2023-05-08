package com.bolsadeideas.springboot.di.app.models.service;

/* Por convencion los nombres de las interfaces terminan en able o ible (adjetivos) ya que representan
 * comportamientos (ejecutable, imprimible, conversable). Pero si el nombre no aplica con la terminacion
 * se le coloca una I mayuscula al principio
 * Una interfaz contiene metodos sin implementar, ya que las clases concretas que hereden tienen 
 * la obligacion de implementarlos conforme a lo necesiten
*/
public interface IServicio {

	public String operacion();
	
}
