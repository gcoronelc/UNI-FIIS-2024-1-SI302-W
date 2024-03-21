package pe.edu.uni.app01.prueba;

import pe.edu.uni.app01.service.NotasService;

public class Prueba02 {
	
	public static void main(String[] args) {
		// Datos
		int pr = 9;
		// Proceso
		NotasService service = new NotasService();
		String cond = service.calcCondicion(pr);
		// Reporte
		System.out.println("Valor esperado: Desaprobado");
		System.out.println("Promedio obtenido: " + cond);
	}
	
	
}
