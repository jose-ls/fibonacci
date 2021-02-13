package org.jose;

import java.util.HashMap;

/**
 * Entry point.
 *
 */
public class FibonacciRecursivoMemorizacion implements FibonacciConMetodo {
    /**
     * Mapa que guarda numero calculados.
     *
     */
    private int numero;
    private HashMap<Integer, Integer>
            numerosYaCalculados = new HashMap<Integer, Integer>();
    public FibonacciRecursivoMemorizacion(int numero){
        this.numero = numero;
    }
    /**
     * Implementación método run.
     */
    @Override
    public void run() {
        if (numero == 0) {
            return 1;
        }
        if (numero < 2) {
            return 1;
        }
        if (numerosYaCalculados.get(numero) != null) {
            return numerosYaCalculados.get(numero);
        } else {
            int resultado = run(numero - 1) + run(numero - 2);
            numerosYaCalculados.put(numero, resultado);
            return resultado;
        }
    }
}
