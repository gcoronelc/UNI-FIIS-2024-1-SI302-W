package pe.edu.uni.appjava.herencia;

public class Clase2 extends Clase1 {
	
	private String nombre = "Claudia";

	public Clase2() {
		super( "Gustavo" );
		System.out.println("Hola desde Clase2!!!");
	}

	@Override
	public int sumar(int n1, int n2) {
		return (n1 + n2) * (n1 - n2);
	}

	public long factorial(int n) {
		// Variables
		long f;
		// Proceso
		f = 1;
		for (int i = 2; i <= n; f *= i++);
		// Reporte
		return f;
	}

	public void mostrar(){
		System.out.println("Bien " + super.nombre + " y " + this.nombre + "!!!");
	}
	
	
}
