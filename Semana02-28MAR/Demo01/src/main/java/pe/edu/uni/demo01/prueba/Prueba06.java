package pe.edu.uni.demo01.prueba;

import pe.edu.uni.demo01.dos.ClaseD;
import pe.edu.uni.demo01.model.ProductoModel;

/**
 *
 * @author Gustavo Coronel
 * @blog http://desarrollasoftware.com/
 * @cursos https://gcoronelc.github.io/
 */
public class Prueba06 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // Variables
		 ProductoModel prod1 = new ProductoModel();
		 // Reporte
		 System.out.println("Nombre: " + prod1.getNombre());
		 System.out.println("Precio: " + prod1.getPrecio());
		 System.out.println("Stock: " + prod1.getStock());
		 System.out.println("Activo: " + prod1.isEstado());
    }

}
