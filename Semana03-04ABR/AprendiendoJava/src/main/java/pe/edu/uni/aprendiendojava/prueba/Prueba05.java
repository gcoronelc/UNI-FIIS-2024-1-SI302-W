package pe.edu.uni.aprendiendojava.prueba;

import pe.edu.uni.aprendiendojava.dto.ProductoDto;

public class Prueba05 {

	public static void main(String[] args) {
		
		ProductoDto dto = new ProductoDto();
		dto.setNombre("Televisor");
		dto.setPrecio(2800.0);
		dto.setStock(500);
		dto.setActivo(true);
		
		System.out.println("Nombre: " + dto.getNombre());
		System.out.println("Precio: " + dto.getPrecio());
		System.out.println("Stock: " + dto.getStock());
		System.out.println("Activo: " + dto.isActivo());
		
	}
	
	
	
}
