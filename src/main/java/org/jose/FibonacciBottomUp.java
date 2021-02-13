package org.jose;

/**
 * Implementación clase Fibonacci BottomUp.
 */
public class FibonacciBottomUp implements FibonacciConMetodo {
    /**
     *
     */
    private int numero;
    /**
     *
     */
    private ResultListener resultListener;

    /**
     *
     */
    public FibonacciBottomUp(int numero, ResultListener resultListener) {
        this.numero = numero;
        this.resultListener = resultListener;
    }

    /**
     * Implementación método run.
     */
    public void run() {
        int resultado = 1;
        int nmenos1 = 1;
        int nmenos2 = 1;
        if (numero == 1 || numero == 0) {
            resultListener.onResult(1);
        } else {
            if (numero > 0) {
                for (int i = 2; i <= numero; i++) {
                    resultado = nmenos1 + nmenos2;
                    nmenos2 = nmenos1;
                    nmenos1 = resultado;
                }
                resultListener.onResult(resultado);
            } else {
                throw new RuntimeException("Error de calculo con: " + numero);
            }
        }
    }
}
