package org.jose;

/**
 * Entry point.
 */
public final class FibonacciConTiempo implements FibonacciCalculator {

    private final FibonacciCalculator delegate;

    /**
     * Entry point.
     *
     * @param delegateA Objeto
     */
    public FibonacciConTiempo(final FibonacciCalculator delegateA) {
        this.delegate = delegateA;

    }


    /**
     * Entry point.
     *
     * @param numero numero a calcular
     * @return devuelve el resultado del numero
     */
    @Override
    public int calcular(final int numero) {
        long start = System.currentTimeMillis();
        int numeroCalculado = this.delegate.calcular(numero);
        System.out.println("Tiempo de: " + numero + " in "
                + (System.currentTimeMillis() - start) + "ms");
        return numeroCalculado;
    }
}
