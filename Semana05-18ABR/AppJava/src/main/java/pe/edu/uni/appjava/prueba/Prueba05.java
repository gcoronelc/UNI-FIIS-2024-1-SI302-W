package pe.edu.uni.appjava.prueba;

import pe.edu.uni.appjava.herencia.PersonaAbstract;

public class Prueba05 {

	public static void main(String[] args) {

		PersonaAbstract bean = new PersonaAbstract() {
			@Override
			public void hablar() {
				System.out.println("Habla brother!!!");
			}
		};
		
		bean.hablar();

	}
}
