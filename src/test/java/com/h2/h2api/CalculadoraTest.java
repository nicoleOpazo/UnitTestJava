package com.h2.h2api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    private Calculadora calculadora = new Calculadora();

    @Test
    void testSuma() {
        int resultado = calculadora.suma(2, 3);
        Assertions.assertEquals(5, resultado);
    }

    @Test
    void testResta() {
        int resultado = calculadora.resta(5, 3);
        Assertions.assertEquals(2, resultado);
    }

    @Test
    void testMultiplicacion() {
        int resultado = calculadora.multiplicacion(2, 3);
        Assertions.assertEquals(6, resultado);
    }

    @Test
    void testDivision() {
        double resultado = calculadora.division(6, 2);
        Assertions.assertEquals(3.0, resultado, 0.01);
    }

    @Test
    void testModulo() {
        int resultado = calculadora.modulo(7, 3);
        Assertions.assertEquals(1, resultado);
    }
}