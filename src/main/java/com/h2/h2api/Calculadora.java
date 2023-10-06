package com.h2.h2api;

public class Calculadora {

    public int suma(int a, int b) {
        return a + b;
    }

    public int resta(int a, int b) {
        return a - b;
    }

    public int multiplicacion(int a, int b) {
        return a * b;
    }

    public double division(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("La división por cero no está permitida");
        }
        return a / b;
    }

    public int modulo(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("El módulo por cero no está permitido");
        }
        return a % b;
    }
}