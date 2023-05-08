package com.bolsadeideas.springboot.di.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//Cualquier controlador tiene que ser un componente, por lo que se hace esta notacion
@Controller
public class IndexController {
	
	//Metodo handler, siempre son publicos. Retorna un nombre de vista
	//index es el nombre del metodo y se genera un Model para poder pasar datos a la vista
	//Un metodo handler puede estar mapeado a mas de una ruta, por lo que se usa un arreglo entonces {}
	// "/" mapeado a la ruta base o raiz del proyecto, local host, puerto y diagonal  
	//  "" solo el localhost y el puerto. "/index" al local host, puerto, index
	@GetMapping({"/", "", "/index"})
	public String index(Model model) {
		return "index"; //esta vista "index" se creara en src/main/resources/templates
	}
}
