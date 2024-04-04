package pe.edu.uni.viaexitos.service;

import pe.edu.uni.viaexitos.dto.PagoDTO;

public class PagoService {

	public PagoDTO procesar(PagoDTO dto) {
		//variables
		double ingreso;
		double renta;
		double neto;
		//proceso
		ingreso = dto.getHorasDia() * dto.getDias() * dto.getPagoHora();
		if (ingreso > 1500) {
			renta = 0.08 * ingreso;
		} else {
			renta = 0;
		}
		neto = ingreso - renta;
		//reporte
		dto.setIngreso(ingreso);
		dto.setRenta(renta);
		dto.setNeto(neto);

		return dto;
	}
}
