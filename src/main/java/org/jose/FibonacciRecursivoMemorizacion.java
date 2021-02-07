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
    private int numero;
    /**
     *
     */
    private ResultListener resultListener;
    /**
     * Mapa que guarda numero calculados.
     */
    private static HashMap<Integer, Integer>
            numerosYaCalculados = new HashMap<Integer, Integer>();

    public FibonacciRecursivoMemorizacion(int numero,
                                          ResultListener resultListener) {
        this.numero = numero;
        this.resultListener = resultListener;
    }

    /**
     * Implementación método run.
     */
    @Override
    public void run() {
        if (numero == 0) {
            resultListener.onResult(1);
        }
        if (numero < 2) {
            resultListener.onResult(1);
        }
        if (numerosYaCalculados.get(numero) != null) {
            resultListener.onResult(numerosYaCalculados.get(numero));
        } else {
            new FibonacciRecursivoMemorizacion(numero - 1, this).run();
            new FibonacciRecursivoMemorizacion(numero - 2, this).run();
        }
    }

    /**
     * Calcula el resultado.
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
            numerosYaCalculados.put(numero, suma);
            pilaDeNumeros.clear();
            resultListener.onResult(suma);
        }
    }
}
