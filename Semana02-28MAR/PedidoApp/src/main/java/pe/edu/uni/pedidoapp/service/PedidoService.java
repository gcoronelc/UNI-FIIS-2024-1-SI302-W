package pe.edu.uni.pedidoapp.service;

import pe.edu.uni.pedidoapp.exception.ImporteException;

public class PedidoService {

    public double calcImpuesto(double importe) {
        // Validar
        if (importe <= 0.0) {
            throw new ImporteException();
        }
        // Variables
        double impuesto;
        // Proceso
        impuesto = importe * 0.18;
        // Reporte
        return impuesto;
    }

    public double calcTotal(double importe) {
        // Validar
        if (importe <= 0.0) {
            throw new ImporteException();
        }
        // Variables
        double total;
        // Proceso
        total = importe + calcImpuesto(importe);
        // Reporte
        return total;
    }

}
