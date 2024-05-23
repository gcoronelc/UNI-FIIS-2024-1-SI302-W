
package pe.edu.uni.poo_ep_ayala.Pruebas;

import java.util.List;
import pe.edu.uni.poo_ep_ayala.Dto.CuentasDto;
import pe.edu.uni.poo_ep_ayala.Service.CuentasService;


public class PruebaCuentas {
    
    public static void main(String[] args) {
        
        try {
            String id_cliente = "00005";
            CuentasService service = new CuentasService();
            List<CuentasDto> list = service.getCuentas(id_cliente);
            for (CuentasDto dto : list) {
                System.out.println(dto.toString());
            }
            
        } catch (Exception e) {
        }
    }
}
