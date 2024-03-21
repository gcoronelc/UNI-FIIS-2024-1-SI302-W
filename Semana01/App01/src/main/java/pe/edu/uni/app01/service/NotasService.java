package pe.edu.uni.app01.service;

public class NotasService {

	public int calcPromedio(int nota1, int nota2, int nota3) {
		// Variables
		int prom;
		// Proceso
		prom = (nota1 + nota2 + nota3) / 3;
		// Reporte
		return prom;
	}

	public String calcCondicion(int nota) {
		// Variables
		String condicion;
		// Proceso
		condicion = "Nota incorrecta";
		condicion = (nota >= 0 && nota < 10) ? "Desaprobado" : condicion;
		condicion = (nota >= 10 && nota < 14) ? "En proceso" : condicion;
		condicion = (nota >= 14 && nota < 18) ? "Bueno" : condicion;
		condicion = (nota >= 18 && nota <= 20) ? "Excelente" : condicion;
		// Reporte
		return condicion;
	}

}
