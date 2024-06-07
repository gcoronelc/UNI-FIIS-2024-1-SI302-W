package pe.edu.uni.demo.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.uni.demo.dto.ClienteDto;
import pe.edu.uni.demo.dto.CuentaDto;
import pe.edu.uni.demo.dto.OperacionDto;
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
	
	@GetMapping("/cliente/{codigo}")
	public  ResponseEntity<?>  getCliente(@PathVariable String codigo){
		ClienteDto bean = eurekaService.getCliente(codigo);
		if(bean == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(bean); 
	}
	
	@PostMapping("/cuenta/crear")
	public ResponseEntity<?> crearCuenta(@RequestBody CuentaDto bean){
		try {
			eurekaService.crearCuenta(bean);
			return ResponseEntity.ok(bean); 
		} catch (Exception e) {
			ErrorResponse error;
			error = new ErrorResponse(e.getMessage(), HttpStatus.CONFLICT.value());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
		}
	}
	
	@PostMapping("/cuenta/retiro")
	public ResponseEntity<?> retiroDeCuenta(@RequestBody OperacionDto bean){
		try {
			eurekaService.registrarRetiro(bean);
			return ResponseEntity.ok(bean); 
		} catch (Exception e) {
			ErrorResponse error;
			error = new ErrorResponse(e.getMessage(), HttpStatus.CONFLICT.value());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
		}
	}
}
