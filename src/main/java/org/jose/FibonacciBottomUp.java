package org.jose;

/**
 * Esta clase define objetos de la clase Fibonacci BottomUp que se usan para
 * calcular la suma de un número por este método.
 */
public class FibonacciBottomUp implements FibonacciConMetodo {
    /**
     * Campo de la clase.
     */
    private int number;
    /**
     * Campo de la clase.
     */
    private ResultListener resultListener;

    /**
     * Constructor para Fibonacci BottomUp.
     *
     * @param numberToCalculate número a calcular.
     * @param resultsListener   .
     */
    public FibonacciBottomUp(final int numberToCalculate,
                             final ResultListener resultsListener) {
        this.number = numberToCalculate;
        this.resultListener = resultsListener;
    }

    /**
     * Implementación método run, para el cálculo del número mediante el método
     * BottomUp.
     */
    public void run() {
        int resultado = 1;
        int nmenos1 = 1;
        int nmenos2 = 1;
        for (int i = 2; i <= number; i++) {
            resultado = nmenos1 + nmenos2;
            nmenos2 = nmenos1;
            nmenos1 = resultado;
        }
        resultListener.onResult(resultado);
    }
}
