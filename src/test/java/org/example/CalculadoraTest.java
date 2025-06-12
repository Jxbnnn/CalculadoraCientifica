package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {

    @Test
    public void testSumaPositivos() {
        double resultado = OperacionesAritmeticas.sumar(10, 5);
        assertEquals(15, resultado);
    }

    @Test
    public void testSumaNegativos() {
        double resultado = OperacionesAritmeticas.sumar(-3, -7);
        assertEquals(-10, resultado);
    }

    @Test
    public void testDivisionNormal() {
        double resultado = OperacionesAritmeticas.dividir(10, 2);
        assertEquals(5, resultado);
    }

    @Test
    public void testDivisionDecimal() {
        double resultado = OperacionesAritmeticas.dividir(7, 2);
        assertEquals(3.5, resultado);
    }

    @Test
    public void testDivisionPorCero() {
        assertThrows(ArithmeticException.class, () -> {
            OperacionesAritmeticas.dividir(10, 0);
        });
    }

    @Test
    public void testPotenciaPositiva() {
        double resultado = OperacionesAritmeticas.potencia(2, 3);
        assertEquals(8, resultado);
    }

    @Test
    public void testPotenciaCeroExponente() {
        double resultado = OperacionesAritmeticas.potencia(5, 0);
        assertEquals(1, resultado);
    }

    @Test
    public void testPotenciaCeroCero() {
        assertThrows(IllegalArgumentException.class, () -> {
            OperacionesAritmeticas.potencia(0, 0);
        });
    }
}
