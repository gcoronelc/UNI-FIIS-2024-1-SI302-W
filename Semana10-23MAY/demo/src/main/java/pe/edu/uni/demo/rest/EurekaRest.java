package pe.edu.uni.demo.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.uni.demo.service.EurekaService;

@RequestMapping("/eureka")
@RestController
public class EurekaRest {
	
	@Autowired
	private EurekaService eurekaService;
	
	@GetMapping("/clientes")
	public List<Map<String,Object>> listadoClientes(){
		return eurekaService.getClientes();
	}

}
