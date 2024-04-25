package pe.edu.uni.eurekaapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class MoviDto {

	private int id;
	private String fecha;
	private String tipo;
	private double importe;
	
	
}
