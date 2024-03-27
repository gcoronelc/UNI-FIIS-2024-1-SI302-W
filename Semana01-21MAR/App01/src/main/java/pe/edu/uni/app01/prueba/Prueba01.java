package pe.edu.uni.app01.prueba;

import pe.edu.uni.app01.service.NotasService;

public class Prueba01 {
	
	public static void main(String[] args) {
		// Datos
		int nota1 = 15;
		int nota2 = 16;
		int nota3 = 18;
		// Proceso
		NotasService service = new NotasService();
		int prom = service.calcPromedio(nota1, nota2, nota3);
		// Reporte
		System.out.println("Promedio esperado: 16");
		System.out.println("Promedio obtenido: 16");
	}
	
	
}
