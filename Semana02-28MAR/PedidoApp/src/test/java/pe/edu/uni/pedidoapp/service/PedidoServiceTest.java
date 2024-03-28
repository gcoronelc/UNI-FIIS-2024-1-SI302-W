package pe.edu.uni.pedidoapp.service;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Test;
import pe.edu.uni.pedidoapp.exception.ImporteException;

public class PedidoServiceTest {

    @Test
    public void testCalcImpuesto_ValidImporte() {
        // Arrange
        PedidoService pedidoService = new PedidoService();
        double importe = 100.0;
        double expectedImpuesto = 18.0;
        // Act
        double impuesto = pedidoService.calcImpuesto(importe);
        // Assert
        assertEquals(expectedImpuesto, impuesto, 0.01); // A small delta is used to handle rounding errors
    }

    @Test
    public void testCalcImpuesto_InvalidImporte() {
        // Arrange
        PedidoService pedidoService = new PedidoService();
        double importe = -100.0;
        // Act & Assert
        assertThrows(ImporteException.class, () -> pedidoService.calcImpuesto(importe));
    }

    @Test
    public void testCalcTotal_ValidImporte() {
        // Arrange
        PedidoService pedidoService = new PedidoService();
        double importe = 100.0;
        double expectedTotal = 118.0;
        // Act
        double total = pedidoService.calcTotal(importe);
        // Assert
        assertEquals(expectedTotal, total, 0.01); // A small delta is used to handle rounding errors
    }

    @Test
    public void testCalcTotal_InvalidImporte() {
        // Arrange
        PedidoService pedidoService = new PedidoService();
        double importe = -100.0;
        // Act & Assert
        assertThrows(ImporteException.class, () -> pedidoService.calcTotal(importe));
    }
}
