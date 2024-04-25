package pe.edu.uni.eurekaapp.prueba;

import java.util.List;
import pe.edu.uni.eurekaapp.dto.MoviDto;
import pe.edu.uni.eurekaapp.service.CuentaService;


public class Prueba03 {

	public static void main(String[] args) {
		try {
			String cuenta = "00100001";
			CuentaService service = new CuentaService();
			List<MoviDto> lista = service.getMovimientos(cuenta);
			if(lista.isEmpty()){
				throw new RuntimeException("Cuenta no existe.");
			}
			for (MoviDto dto : lista) {
				System.out.println(dto.toString());
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
