package pe.edu.uni.appjava.herencia;

public class Clase1 {
	
	protected String nombre = "Gustavo";

	public Clase1() {
		System.out.println("Chequea y aprende!!");
	}
	
	public Clase1(String nombre) {
		System.out.println("Hola " + nombre + "!!!");
	}
	
	public int sumar(int n1, int n2){
		return (n1+n2);
	}

}
