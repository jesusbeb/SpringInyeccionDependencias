package com.bolsadeideas.springboot.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.di.app.models.domain.Factura;

@Controller //notacion para ser manejado por Spring
@RequestMapping("/factura")//damos ruta mapeada a factura
public class FacturaController {

	//inyectamos la factura
	@Autowired
	private Factura factura;
	
	//Ruta para ver el detalle
	@GetMapping("/ver")
	//metodo 
	public String ver(Model model) {
		//pasamos a la vista, la variable factura con el objeto factura
		model.addAttribute("factura", factura);
		//pasamos a la vista, la variable titulo a la vista con su valor
		model.addAttribute("titulo", "Ejemplo Factura con inyeccion de dependencia");
		return "factura/ver"; //retornamos donde sera visible
	}
}
