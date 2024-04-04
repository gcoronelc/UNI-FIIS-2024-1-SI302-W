package pe.edu.uni.viaexitos.prueba;

import pe.edu.uni.viaexitos.dto.PagoDTO;
import pe.edu.uni.viaexitos.service.PagoService;

public class Prueba01 {

	public static void main(String[] args) {
		// Datos
		PagoDTO dto = new PagoDTO(8, 25, 20);

		// Proceso
		PagoService service = new PagoService();
		dto = service.procesar(dto);
		// Reporte
		System.out.println("Ingresos: "+dto.getIngreso());
		System.out.println("Renta: "+dto.getRenta());
		System.out.println("Neto: "+dto.getNeto());
	}
}
