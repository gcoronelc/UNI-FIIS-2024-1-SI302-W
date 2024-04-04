package pe.edu.uni.aprendiendojava.dos;

import pe.edu.uni.aprendiendojava.uno.ClaseA;

public class ClaseC extends ClaseA{

	public ClaseC() {
		super();
		System.out.println("Hola desde constructor de ClaseC");
	}
	
	
	

	public void metodoC(){
		int n3 = 200;
		ClaseA o = new ClaseA();
		//System.out.println("n1 = " + o.n1);
		//System.out.println("n2 = " + o.n2);
		System.out.println("n3 (local) = " + n3);
		System.out.println("n3 (herancia) = " + super.n3);
		System.out.println("n4 = " + o.n4);
	}
	
}
