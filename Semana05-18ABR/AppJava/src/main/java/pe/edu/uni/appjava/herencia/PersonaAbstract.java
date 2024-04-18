package pe.edu.uni.appjava.herencia;

public abstract class PersonaAbstract {

	public long potencia(int base, int exponente) {
		// Variable
		long p;
		// Proceso
		p = 1;
		for (int i = 1; i <= exponente; i++) {
			p *= base;			
		}
		// Reporte
		return p;
	}

	public abstract void hablar();

}
