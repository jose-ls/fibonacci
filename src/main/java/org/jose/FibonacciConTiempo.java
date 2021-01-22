package org.jose;
/**
 * Entry point.
 */
public class FibonacciConTiempo implements FibonacciCalculator {

    private final FibonacciCalculator delegate;
    /**
     * Entry point.
     * @param delegateA
     */
    public FibonacciConTiempo(final FibonacciCalculator delegateA) {
        this.delegate = delegateA;

    }

    @Override
    /**
     * Entry point.
     * @param n
     * @return
     */
    public int calcular(int numero) {
        long start = System.currentTimeMillis();
        int numeroCalculado = this.delegate.calcular(numero);
        System.out.println("Tiempo de: " + numero + " in "
                + (System.currentTimeMillis() - start) + "ms");
        return numeroCalculado;
    }
}
