package pe.edu.uni.pedidoapp.prueba;

import pe.edu.uni.pedidoapp.service.PedidoService;

public class Prueba02 {

    public static void main(String[] args) {
        try {
            // Datos
            double importe = -100.0;
            // Proceso
            PedidoService service = new PedidoService();
            double impuesto = service.calcImpuesto(importe);
            // Reporte
            System.out.println("Importe: " + importe);
            System.out.println("Impuesto: " + impuesto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    
}
