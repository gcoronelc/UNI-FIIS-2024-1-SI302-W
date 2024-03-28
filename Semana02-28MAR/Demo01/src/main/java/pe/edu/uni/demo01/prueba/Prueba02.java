package pe.edu.uni.demo01.prueba;

import pe.edu.uni.demo01.uno.ClaseA;

/**
 *
 * @author Gustavo Coronel
 * @blog http://desarrollasoftware.com/
 * @cursos https://gcoronelc.github.io/
 */
public class Prueba02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // Variables
		 ClaseA obj1, obj2;
		 // Proceso
		 obj1 = new ClaseA(76,34,87,34);
		 obj2 = new ClaseA(90,12,76,55);
		 // Reporte
		 obj1.metodoA();		 
		 obj2.metodoA();		 
    }

}
