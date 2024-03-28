package pe.edu.uni.pedidoapp.prueba;

import pe.edu.uni.pedidoapp.service.PedidoService;

public class Prueba03 {

    public static void main(String[] args) {
        try {
            // Datos
            double importe = -100.0;
            // Proceso
            PedidoService service = new PedidoService();
            double total = service.calcTotal(importe);
            // Reporte
            System.out.println("Importe: " + importe);
            System.out.println("Total: " + total);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
