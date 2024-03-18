package pe.edu.uni.ventapasajes.pruebas;

import pe.edu.uni.ventapasajes.model.ClienteModel;
import pe.edu.uni.ventapasajes.service.CrudClienteImpl;

/**
 *
 * @author Gustavo Coronel
 */
public class Prueba06 {

   public static void main(String[] args) {
      try {
         ClienteModel model = new ClienteModel();
         model.setId(19);
         model.setApellido("TORRES");
         model.setNombre("CARLOS");
         model.setCorreo("javalos@gmail.com");
         model.setDistrito("LOS OLIVOS");
         model.setDni("65782345");
         model.setTelefono("989856341");
         CrudClienteImpl crudCliente = new CrudClienteImpl();
         crudCliente.update(model);
         System.out.println("ID: " + model.getId());
      } catch (Exception e) {
         System.err.println(e.getMessage());
      }
   }

}
