package org.jose;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Entry point.
 */
public class FibonacciRecursivoMemorizacion implements FibonacciConMetodo,
        ResultListener {
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
     * Mapa que guarda numero calculados.
     */
    private static HashMap<Integer, Integer>
            numerosYaCalculados = new HashMap<Integer, Integer>();

    /**
     * @param numberToCalculate número a calcular.
     * @param resultsListener   .
     */
    public FibonacciRecursivoMemorizacion(
            final int numberToCalculate, final ResultListener resultsListener) {
        this.number = numberToCalculate;
        this.resultListener = resultsListener;
    }

    /**
     * Implementación método run.
     */
    @Override
    public void run() {
        if (number == 0) {
            resultListener.onResult(1);
        }
        if (number < 2) {
            resultListener.onResult(1);
        }
        if (numerosYaCalculados.get(number) != null) {
            resultListener.onResult(numerosYaCalculados.get(number));
        } else {
            new FibonacciRecursivoMemorizacion(number - 1, this).run();
            new FibonacciRecursivoMemorizacion(number - 2, this).run();
        }
    }

    /**
     * Calcula el resultado.
     *
     * @param result .
     */
    @Override
    public void onResult(final int result) {
        pilaDeNumeros.add(result);
        if (pilaDeNumeros.size() == 2) {
            int suma = 0;
            for (int i = 0; i < pilaDeNumeros.size(); i++) {
                suma = suma + pilaDeNumeros.get(i);
            }
            numerosYaCalculados.put(number, suma);
            pilaDeNumeros.clear();
            resultListener.onResult(suma);
        }
    }
}
