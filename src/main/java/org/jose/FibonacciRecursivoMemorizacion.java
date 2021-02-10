package org.jose;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Esta clase define objetos de la clase Fibonacci Recursivo con memoria que se
 * usan para calcular la suma de un número por este método.
 */
public class FibonacciRecursivoMemorizacion implements FibonacciConMetodo,
        ResultListener {
    /**
     * Campo de la clase.
     * Lista que almacena los resultados del calculo.
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
     * Mapa que guarda numero calculados.
     */
    private static HashMap<Integer, Integer>
            numerosYaCalculados = new HashMap<Integer, Integer>();

    /**
     * Constructor de la clase Fibonacci Recursivo con Memorización.
     *
     * @param numberToCalculate número a calcular.
     * @param resultsListener   .
     */
    public FibonacciRecursivoMemorizacion(
            final int numberToCalculate, final ResultListener resultsListener) {
        this.number = numberToCalculate;
        this.resultListener = resultsListener;
    }

    /**
     * Implementa el método run para el cálculo del número
     * mediante recursividad con memoria.
     */
    @Override
    public void run() {
        if (number < 2) {
            resultListener.onResult(1);
        } else if (numerosYaCalculados.get(number) != null) {
            resultListener.onResult(numerosYaCalculados.get(number));
        } else {
            new FibonacciRecursivoMemorizacion(number - 1, this).run();
            new FibonacciRecursivoMemorizacion(number - 2, this).run();
        }
    }

    /**
     * Resuelve la suma de los resultados de n-1 y n-2.
     *
     * @param result resultado del calculo.
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
