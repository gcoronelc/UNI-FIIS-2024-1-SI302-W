package pe.edu.uni.demo01.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Gustavo Coronel
 */
@Data 
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoModel {
	
	private String dni;
	private String nombre;
	private String apellido;
	private String correo;

}
