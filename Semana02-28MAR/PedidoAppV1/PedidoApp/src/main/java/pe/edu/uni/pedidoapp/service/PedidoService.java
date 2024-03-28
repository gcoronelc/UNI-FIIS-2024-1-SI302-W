package pe.edu.uni.pedidoapp.service;

public class PedidoService {
    
    public double calcImpuesto(double importe){
        // Variables
        double impuesto;
        // Proceso
        impuesto = importe * 0.18;
        // Reporte
        return impuesto;
    }
    
    public double calcTotal(double importe){
        // Variables
        double total;
        // Proceso
        total = importe + calcImpuesto(importe);
        // Reporte
        return total;
    }
    
}
