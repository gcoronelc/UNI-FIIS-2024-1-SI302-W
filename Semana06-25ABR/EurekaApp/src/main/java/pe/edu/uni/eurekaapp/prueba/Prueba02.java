package pe.edu.uni.eurekaapp.prueba;

import pe.edu.uni.eurekaapp.service.CuentaService;

public class Prueba02 {

	public static void main(String[] args) {
		
		try {
			// Datos
			String cuenta = "00100001";
			double importe = 2000;
			String empleado = "0075";
			// Proceso
			CuentaService service = new CuentaService();
			service.deposito(cuenta, importe, empleado);
			System.out.println("Proceso Ok.");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}
}
