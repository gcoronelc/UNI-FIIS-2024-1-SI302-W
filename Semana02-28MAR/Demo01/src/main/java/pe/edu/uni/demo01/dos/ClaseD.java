package pe.edu.uni.demo01.dos;

import pe.edu.uni.demo01.uno.ClaseA;

/**
 *
 * @author Gustavo Coronel
 */
public class ClaseD{
	

	/**
	 * Metodo que muestra el valor de las variables.
	 */
	public void metodoD(){
		// Variables
		ClaseA obj = new ClaseA();
		// Reporte
		System.out.println("DESDE EL METODO C");
		// System.out.println("n1: " + obj.n1); No se tiene acceso, por que es privado
		// System.out.println("n2: " + obj.n2); La variable n2 se encuentra en un paquete diferente.
		// System.out.println("n3: " + super.n3); La variable n3 esta protegida
		System.out.println("n4: " + obj.n4);
	}
	
	
}
