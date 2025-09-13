package com.ejemplo;

public class App {

    public static int suma(int a, int b) {
        if (b == 0) {
            return a;
        }
        return suma(a + 1, b - 1);
    }

    public static int multiplicacion(int a, int b) {
        if (b == 0) {
            return 0;
        }
        return suma(a, multiplicacion(a, b - 1));
    }

    public static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El factorial no está definido para números negativos");
        }
        if (n <= 1) {
            return 1;
        }
        return multiplicacion(n, factorial(n - 1));
    }

    public static void main(String[] args) {
        int numero = 7;
        System.out.println("Factorial de " + numero + " es: " + factorial(numero));
    }
}
