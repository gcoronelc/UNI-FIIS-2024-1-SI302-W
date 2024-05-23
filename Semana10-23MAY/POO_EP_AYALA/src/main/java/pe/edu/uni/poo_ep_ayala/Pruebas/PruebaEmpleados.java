
package pe.edu.uni.poo_ep_ayala.Pruebas;

import java.util.List;
import pe.edu.uni.poo_ep_ayala.Dto.EmpleadosDto;
import pe.edu.uni.poo_ep_ayala.Service.EmpleadosService;


public class PruebaEmpleados {
    
    public static void main(String[] args) {
        
        try {
            String id_sucursal = "001";
            EmpleadosService service = new EmpleadosService();
            List<EmpleadosDto> list = service.getEmpleados(id_sucursal);
            for (EmpleadosDto dto : list) {
                System.out.println(dto.toString());
            }
            
        } catch (Exception e) {
        }
    }
}
