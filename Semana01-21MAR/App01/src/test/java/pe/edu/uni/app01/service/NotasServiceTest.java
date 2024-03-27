package pe.edu.uni.app01.service;

import org.junit.Assert;
import org.junit.Test;

public class NotasServiceTest {

	@Test
	public void testCalcPromedio() {
		NotasService notasService = new NotasService();

		// Caso de prueba 1: Notas positivas
		int promedio = notasService.calcPromedio(14, 15, 16);
		Assert.assertEquals("El promedio no es el esperado", 15, promedio);

		// Caso de prueba 2: Notas negativas
		promedio = notasService.calcPromedio(-5, -6, -7);
		Assert.assertEquals("El promedio no es el esperado", -6, promedio);
	}

	@Test
	public void testCalcCondicion() {
		NotasService notasService = new NotasService();

		// Caso de prueba 1: Nota incorrecta
		String condicion = notasService.calcCondicion(-5);
		Assert.assertEquals("Nota incorrecta", condicion, "Nota incorrecta");

		// Caso de prueba 2: Desaprobado
		condicion = notasService.calcCondicion(7);
		Assert.assertEquals("La condición no es la esperada", "Desaprobado", condicion);

		// Caso de prueba 3: En proceso
		condicion = notasService.calcCondicion(12);
		Assert.assertEquals("La condición no es la esperada", "En proceso", condicion);

		// Caso de prueba 4: Bueno
		condicion = notasService.calcCondicion(16);
		Assert.assertEquals("La condición no es la esperada", "Bueno", condicion);

		// Caso de prueba 5: Excelente
		condicion = notasService.calcCondicion(20);
		Assert.assertEquals("La condición no es la esperada", "Excelente", condicion);
	}
}
