package org.jose;

import java.util.HashMap;

/**
 * Entry point.
 *
 */
public class FibonacciRecursivoMemorizacion implements FibonacciConMetodo {
    /**
     * Mapa que guarda numero calculados
     *
     */
    private HashMap<Integer, Integer> mapa = new HashMap<Integer, Integer>();
    /**
     * Entry point.
     *
     * @param numero numero a calcular
     * @return devuelve el resultado del calculo
     */
    @Override
    public int calcular(final int numero) {
        if (numero == 0) {
            return 1;
        }
        if (numero < 2) {
            return 1;
        }
        if (mapa.get(numero) != null) {
            return mapa.get(numero);
        } else {
            int resultado = calcular(numero - 1) + calcular(numero - 2);
            mapa.put(numero, resultado);
            return resultado;
        }
    }
}
