package pe.edu.uni.pedidoapp.prueba;

import pe.edu.uni.pedidoapp.service.PedidoService;

public class Prueba02 {

    public static void main(String[] args) {
        // Datos
        double importe  = -100.0;
        // Proceso
        PedidoService service = new PedidoService();
        double impuesto = service.calcImpuesto(importe);
        double total = service.calcTotal(importe);
        // Reporte
        System.out.println("Importe: " + importe);
        System.out.println("Impuesto: " + impuesto);
        System.out.println("Total: " + total);
    }

    
}
