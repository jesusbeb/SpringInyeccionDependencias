package com.bolsadeideas.springboot.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bolsadeideas.springboot.di.app.models.service.IServicio;


//Cualquier controlador tiene que ser un componente, por lo que se hace esta notacion
@Controller
public class IndexController {
	
	//Implementamos como atributo MiServicio sin inyeccion de dependencia
	//objeto servicio de la clase MiServicio
	/*private MiServicio servicio = new MiServicio();*/
	
	//quitamos la parte de = new MiServicio
	//inyectamos con Autowired, que inyecta un objeto registrado en el contenedor de Spring de tipo MiServicio
	/*@Autowired
	private MiServicio servicio;*/
	
	//Ahora en vez de la clase concreta MiServicio usamos la interfaz
	//Ahora depende de algo generico y no concreto, la manutencion es mas simple
	//Tenemos dos clases concretas que implementan el metodo operacion. Como estamos injectando por
	//interface, no estamos especificando que clase concreta se ejecutara. Una de las clases concretas
	//debe estar especificada como la primaria
	/*@Autowired
	@Qualifier("miServicioComplejo") //con @Qualifier especificamos el nombre del servicio que queremos inyectar
	private IServicio servicio;*/
	
	//Se registran componentes usando clase de Configuracion (AppConfig) y la notacion @Bean
	@Autowired
	private IServicio servicio;
	
	//Metodo handler, siempre son publicos. Retorna un nombre de vista
	//index es el nombre del metodo y se genera un Model para poder pasar datos a la vista
	//Un metodo handler puede estar mapeado a mas de una ruta, por lo que se usa un arreglo entonces {}
	// "/" mapeado a la ruta base o raiz del proyecto, local host, puerto y diagonal  
	//  "" solo el localhost y el puerto. "/index" al local host, puerto, index
	@GetMapping({"/", "", "/index"})
	public String index(Model model) {
		//pasamos a la vista. "objeto" es el nombre de variable que identificara la vista (html)
		//y se ejecuta el metodo operacion con el objeto servicio que se instancio de MiServicio
		model.addAttribute("objeto", servicio.operacion());
		return "index"; //esta vista "index" se creara en src/main/resources/templates
	}


	
	
	
}
