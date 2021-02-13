package org.jose;

import java.util.LinkedList;
import java.util.List;

/**
 * Esta clase define objetos de la clase Fibonacci Recursivo que se usan para
 * calcular la suma de un número por este método.
 */
public class FibonacciRecursivo implements FibonacciConMetodo, ResultListener {
    /**
     * Campo de la clase.
     * Almacena los resultados parciales para su suma.
     */
    private List<Integer> pilaDeNumeros = new LinkedList<>();
    /**
     * Campo de la clase.
     */
    private int number;
    /**
     * Campo de la clase.
     */
    private ResultListener resultListener;

    /**
     * Constructor de la clase Fibonacci Recursivo.
     *
     * @param numberToCalculate número a calcular.
     * @param resultsListener   .
     */
    public FibonacciRecursivo(final int numberToCalculate,
                              final ResultListener resultsListener) {
        this.number = numberToCalculate;
        this.resultListener = resultsListener;
    }

    /**
     * Implementa el método run para el cálculo del número
     * mediante recursividad.
     */
    public void run() {
        if (number < 2) {
            resultListener.onResult(1);
        } else {
            if (number >= 2) {
                new FibonacciRecursivo(number - 1, this).run();
                new FibonacciRecursivo(number - 2, this).run();
            } else {
                throw new RuntimeException("Error de calculo con: " + number);
            }
        }
    }

    /**
     * Resuelve la suma de los resultados de n-1 y n-2.
     *
     * @param result Resultado del calulo.
     */
    @Override
    public void onResult(final int result) {
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
