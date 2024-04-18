package pe.edu.uni.appjava.prueba;

import pe.edu.uni.appjava.herencia.Clase1;
import pe.edu.uni.appjava.herencia.Clase2;
import pe.edu.uni.appjava.herencia.Clase3;

public class Prueba07 {

	public static void main(String[] args) {
		Clase1 bean1 = new Clase2();
		Clase2 bean2 = (Clase2) bean1;
		Clase3 bean3;
		if (bean1 instanceof Clase3) {
			bean3 = (Clase3) bean1;
		}
		System.out.println("Todo bien");
	}

}
