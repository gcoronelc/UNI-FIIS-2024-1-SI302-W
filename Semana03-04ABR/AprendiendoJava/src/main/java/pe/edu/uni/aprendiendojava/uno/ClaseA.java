package pe.edu.uni.aprendiendojava.uno;


public class ClaseA {
	
	private int n1;
	int n2;
	protected int n3;
	public int n4;

	/**
	 * Constructor por defecto.
	 */
	public ClaseA() {
		System.out.println("Hola desde el constructor por defecto.");
		this.n1 = 15;
		this.n2 = 16;
		this.n3 = 13;
		this.n4 = 17;
		
	}

	/**
	 * constructor adicional
	 * @param n1 valor para n1
	 * @param n2 valor para n2
	 * @param n3 valor para n3
	 * @param n4 valor para n4
	 */
	public ClaseA(int n1, int n2, int n3, int n4) {
		this.n1 = n1;
		this.n2 = n2;
		this.n3 = n3;
		this.n4 = n4;
	}
	
	
	
	
	
	public void metodoA(){
		System.out.println("n1 = " + n1);
		System.out.println("n2 = " + n2);
		System.out.println("n3 = " + n3);
		System.out.println("n4 = " + n4);
	}
	
	
}
