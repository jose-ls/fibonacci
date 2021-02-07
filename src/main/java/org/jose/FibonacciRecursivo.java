package org.jose;

import java.util.LinkedList;
import java.util.List;

/**
 * Implementa la clase Fibonacci Recursivo.
 */
public class FibonacciRecursivo implements FibonacciConMetodo, ResultListener {
    /**
     *
     */
    private List<Integer> pilaDeNumeros = new LinkedList<>();
    /**
     *
     */
    private int numero;
    /**
     *
     */
    private ResultListener resultListener;

    public FibonacciRecursivo(int numero, ResultListener resultListener) {
        this.numero = numero;
        this.resultListener = resultListener;
    }

    /**
     * Implementa el método run.
     */
    public void run() {
        if (numero == 1 || numero == 0) {
            resultListener.onResult(1);
        } else {
            if (numero > 0) {
                new FibonacciRecursivo(numero - 1, this).run();
                new FibonacciRecursivo(numero - 2, this).run();
            } else {
                throw new RuntimeException("Error de calculo con: " + numero);
            }
        }
    }

    /**
     * @param result .
     */
    @Override
    public void onResult(int result) {
        pilaDeNumeros.add(result);
        if (pilaDeNumeros.size() == 2) {
            int suma = 0;
            for (int i = 0; i < pilaDeNumeros.size(); i++) {
                suma = suma + pilaDeNumeros.get(i);
            }
            pilaDeNumeros.clear();
            resultListener.onResult(suma);
        }
    }
}
