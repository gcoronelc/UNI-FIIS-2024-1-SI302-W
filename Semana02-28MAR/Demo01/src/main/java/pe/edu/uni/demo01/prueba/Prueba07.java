package pe.edu.uni.demo01.prueba;

import pe.edu.uni.demo01.model.EmpleadoModel;

/**
 *
 * @author Gustavo Coronel
 * @blog http://desarrollasoftware.com/
 * @cursos https://gcoronelc.github.io/
 */
public class Prueba07 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // Variables
		 EmpleadoModel model = new EmpleadoModel("54679823", "Perico", "Calderon", "perico@loco.com");
		 // Reporte
		 System.out.println("DNI: " + model.getDni());
		 System.out.println("Nombre: " + model.getNombre());
		 System.out.println("Apellido: " + model.getApellido());
		 System.out.println("Correo: " + model.getCorreo());
    }

}
