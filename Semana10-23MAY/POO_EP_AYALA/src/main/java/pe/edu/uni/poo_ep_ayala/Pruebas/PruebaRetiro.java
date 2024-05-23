
package pe.edu.uni.poo_ep_ayala.Pruebas;

import pe.edu.uni.poo_ep_ayala.Service.RetiroService;


public class PruebaRetiro {
    
    public static void main(String[] args) {
        try {
            //Datos
            String id_codigo = "00200003";
            double retiro = 1000;
            int contra = 123456;
            String empleado = "0004";
            //Proceso
            RetiroService service = new RetiroService();
            service.registro(id_codigo, retiro, contra, empleado);
            System.out.println("Proceso completo.Todo ok.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
