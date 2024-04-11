package pe.edu.uni.appjava.service;

import java.util.List;
import pe.edu.uni.appjava.dto.ContactoDto;

public class ContactoService {
		
	public List<ContactoDto> getContactos(){
		return Datos.contactos;
	}
	
	public void add(ContactoDto bean){
		Datos.contactos.add(bean);
	}

}
