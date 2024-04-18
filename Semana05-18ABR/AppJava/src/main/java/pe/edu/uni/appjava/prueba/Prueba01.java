package pe.edu.uni.appjava.prueba;

import pe.edu.uni.appjava.dto.ContactoDto;
import pe.edu.uni.appjava.service.ContactoService;

public class Prueba01 {
	
	public static void main(String[] args) {
		
		ContactoService service = new ContactoService();
		
		service.add(new ContactoDto("Crystal", "crystal@gmail.com", "945678345"));
		
		for (ContactoDto bean : service.getContactos()) {
			System.out.println(bean.getNombre() + " - " 
			+ bean.getEmail() + " - " + bean.getTelefono());
		}
		
		
	}

}
