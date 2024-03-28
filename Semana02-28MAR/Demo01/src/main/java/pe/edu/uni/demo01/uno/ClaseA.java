package pe.edu.uni.demo01.uno;

/**
 *
 * @author Gustavo Coronel
 */
public class ClaseA {
	
	private int n1;
	int n2;
	protected int n3;
	public int n4;
	private String constructor = "";

	/**
	 * Constructor por defecto
	 */
	public ClaseA() {
		this.constructor = "CONSTRUCTOR POR DEFECTO";
		this.n1 = 10;
		this.n2 = 20;
		this.n3 = 30;
		this.n4 = 40;
	}

	/**
	 * Constructor adicional parametrizado
	 * @param n1 Valor de la variable n1
	 * @param n2 Valor de la variable n2
	 * @param n3 Valor de la variable n3
	 * @param n4 Valor de la variable n4
	 */
	public ClaseA(int n1, int n2, int n3, int n4) {
		this.constructor = "CONSTRUCTOR ADICIONAL";
		this.n1 = n1;
		this.n2 = n2;
		this.n3 = n3;
		this.n4 = n4;
	}
	
	/**
	 * Metodo que muestra el valor de las variables.
	 */
	public void metodoA(){
		System.out.println("DESDE EL METODO A");
		System.out.println("DESDE " + this.constructor);
		System.out.println("n1: " + this.n1);
		System.out.println("n2: " + this.n2);
		System.out.println("n3: " + this.n3);
		System.out.println("n4: " + this.n4);
	}
	

}
