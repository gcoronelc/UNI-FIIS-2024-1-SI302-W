package pe.edu.uni.app01.prueba;

import pe.edu.uni.app01.service.NotasService;

public class Prueba03 {
	
	public static void main(String[] args) {
		// Datos
		int pr = 12;
		// Proceso
		NotasService service = new NotasService();
		String cond = service.calcCondicion(pr);
		// Reporte
		System.out.println("Valor esperado: En proceso");
		System.out.println("Promedio obtenido: " + cond);
	}
	
	
}
