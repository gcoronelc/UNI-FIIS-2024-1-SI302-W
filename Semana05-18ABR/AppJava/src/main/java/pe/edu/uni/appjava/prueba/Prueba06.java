package pe.edu.uni.appjava.prueba;

import pe.edu.uni.appjava.herencia.Factura;
import pe.edu.uni.appjava.herencia.PersonaAbstract;

public class Prueba06 {

	public static void main(String[] args) {
		PersonaAbstract bean = new Factura();
		bean.hablar();
		System.out.println("5^3 = " + bean.potencia(5, 3));
	}

}
