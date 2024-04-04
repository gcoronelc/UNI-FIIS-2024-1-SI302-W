package pe.edu.uni.viaexitos.prueba;

import pe.edu.uni.viaexitos.dto.PagoDTO;
import pe.edu.uni.viaexitos.service.PagoService;

public class Prueba01_1 {

	public static void main(String[] args) {
		// Datos
		PagoDTO dto = new PagoDTO(6, 21, 10);
		// Proceso
		PagoService service = new PagoService();
		dto = service.procesar(dto);
		// Reporte
		System.out.println("Ingresos: " + dto.getIngreso());
		System.out.println("Renta: " + dto.getRenta());
		System.out.println("Neto: " + dto.getNeto());
	}
}
