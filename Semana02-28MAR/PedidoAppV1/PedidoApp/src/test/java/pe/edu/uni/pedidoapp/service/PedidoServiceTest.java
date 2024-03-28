package pe.edu.uni.pedidoapp.service;

import static junit.framework.Assert.assertEquals;
import org.junit.Test;

public class PedidoServiceTest {
    
     @Test
    public void testCalcImpuesto() {
        // Arrange
        PedidoService pedidoService = new PedidoService();
        double importe = 100.0;
        double expectedImpuesto = 18.0;
        // Act
        double impuesto = pedidoService.calcImpuesto(importe);
        // Assert
        assertEquals(expectedImpuesto, impuesto, 0.01); // Se utiliza un delta pequeño para manejar errores de redondeo
    }

    @Test
    public void testCalcTotal() {
        // Arrange
        PedidoService pedidoService = new PedidoService();
        double importe = 100.0;
        double expectedTotal = 118.0;
        // Act
        double total = pedidoService.calcTotal(importe);
        // Assert
        assertEquals(expectedTotal, total, 0.01); // Se utiliza un delta pequeño para manejar errores de redondeo
    }
}
