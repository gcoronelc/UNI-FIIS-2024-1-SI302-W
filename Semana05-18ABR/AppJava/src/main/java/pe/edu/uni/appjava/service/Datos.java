package pe.edu.uni.appjava.service;

import java.util.ArrayList;
import java.util.List;
import pe.edu.uni.appjava.dto.ContactoDto;

class Datos {

	private Datos() {
	}
	
	static List<ContactoDto> contactos;
	
	static {
		contactos = new ArrayList<>();
		contactos.add(new ContactoDto("Edward", "edward@gmail.com", "987678465"));
		contactos.add(new ContactoDto("Alejandra", "alejandra@gmail.com", "984567543"));
		contactos.add(new ContactoDto("Pedro", "pedro@gmail.com", "987634565"));
		contactos.add(new ContactoDto("Matias", "matias@gmail.com", "987622465"));
		contactos.add(new ContactoDto("Delia", "delia@gmail.com", "987777465"));
		contactos.add(new ContactoDto("Jorge", "jorge@gmail.com", "987678885"));
		contactos.add(new ContactoDto("Thalia", "7halia@gmail.com", "987123465"));
	}
	
}
