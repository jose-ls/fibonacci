package org.jose;

public class FibonacciConTiempo implements FibonacciCalculator {
    /**
     * Entry point.
     */
    private final FibonacciCalculator delegate;

    public FibonacciConTiempo(final FibonacciCalculator delegateA) {
        this.delegate = delegateA;

    }

    @Override
    public int calcular(int numero) {
        long start = System.currentTimeMillis();
        int numeroCalculado = this.delegate.calcular(numero);
        System.out.println("Tiempo de: " + numero + " in "
                + (System.currentTimeMillis() - start) + "ms");
        return numeroCalculado;
    }
}
