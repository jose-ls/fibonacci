package org.jose;

public class FibonacciRecursivo implements FibonacciConMetodo {
    /**
     * Entry point.
     */

    public int calcular(final int n) {
        if (n == 1 || n == 0) {
            return 1;
        } else {
            if (n > 0) {
                return calcular(n - 1) + calcular(n - 2);
            } else {
                throw new RuntimeException("Error de calculo con: " + n);
            }
        }
    }
}