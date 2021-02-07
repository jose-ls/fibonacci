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
    private int number;
    /**
     *
     */
    private ResultListener resultListener;

    /**
     * 
     * @param numberToCalculate número a calcular.
     * @param resultsListener .
     */
    public FibonacciRecursivo(final int numberToCalculate,
                              ResultListener resultsListener) {
        this.number = numberToCalculate;
        this.resultListener = resultsListener;
    }

    /**
     * Implementa el método run.
     */
    public void run() {
        if (number == 1 || number == 0) {
            resultListener.onResult(1);
        } else {
            if (number > 0) {
                new FibonacciRecursivo(number - 1, this).run();
                new FibonacciRecursivo(number - 2, this).run();
            } else {
                throw new RuntimeException("Error de calculo con: " + number);
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
