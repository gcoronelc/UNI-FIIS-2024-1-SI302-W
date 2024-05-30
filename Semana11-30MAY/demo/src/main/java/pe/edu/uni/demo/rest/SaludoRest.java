package pe.edu.uni.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/saludos")
@RestController
public class SaludoRest {

	@GetMapping
	public String saludo() {
		return "Hola, te saluda Gustavo Coronel";
	}
	
	@GetMapping("/{nombre}")
	public String saludo(@PathVariable("nombre") String nombre) {
		return "Hola " + nombre + ", te saluda Gustavo Coronel.";
	}
	
}
