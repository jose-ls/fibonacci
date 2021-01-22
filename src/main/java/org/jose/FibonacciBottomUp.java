package org.jose;
/**
 * Entry point.
 */
public class FibonacciBottomUp implements FibonacciConMetodo {
    /**
     * Entry point.
     * @param n numero a calcular
     * @return devuelve el resultado del calculo
     */
    public int calcular(final int n) {
        int resultado = 1;
        int nmenos1 = 1;
        int nmenos2 = 1;
        if (n == 1 || n == 0) {
            return 1;
        } else {
            if (n > 0) {
                for (int i = 2; i <= n; i++) {
                    resultado = nmenos1 + nmenos2;
                    nmenos2 = nmenos1;
                    nmenos1 = resultado;
                }
                return resultado;
            } else {
                throw new RuntimeException("Error de calculo con: " + n);
            }

        }
    }

}
