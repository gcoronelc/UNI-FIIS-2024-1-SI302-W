
package pe.edu.uni.poo_ep_ayala.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class EmpleadosDto {
    private String codigo;
    private String nombre;
    private String usuario;
    private String fecha;
    private String fec_baja;
}
