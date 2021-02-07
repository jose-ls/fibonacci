package org.jose;

/**
 * Implementación clase Fibonacci BottomUp.
 */
public class FibonacciBottomUp implements FibonacciConMetodo {
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
    public FibonacciBottomUp(final int numberToCalculate,
                             final  ResultListener resultsListener) {
        this.number = numberToCalculate;
        this.resultListener = resultsListener;
    }

    /**
     * Implementación método run.
     */
    public void run() {
        int resultado = 1;
        int nmenos1 = 1;
        int nmenos2 = 1;
        if (number == 1 || number == 0) {
            resultListener.onResult(1);
        } else {
            if (number > 0) {
                for (int i = 2; i <= number; i++) {
                    resultado = nmenos1 + nmenos2;
                    nmenos2 = nmenos1;
                    nmenos1 = resultado;
                }
                resultListener.onResult(resultado);
            } else {
                throw new RuntimeException("Error de calculo con: " + number);
            }
        }
    }
}
