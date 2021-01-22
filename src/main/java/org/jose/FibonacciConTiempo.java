package org.jose;
/**
 * Entry point.
 */
public class FibonacciConTiempo implements FibonacciCalculator {

    private final FibonacciCalculator delegate;

    public FibonacciConTiempo(final FibonacciCalculator delegateA) {
        this.delegate = delegateA;

    }

    @Override
    /**
     * Entry point.
     * @param numero numero a calcular
     * @return devuelve el resultado del numero
     */
    public int calcular(final int numero) {
        long start = System.currentTimeMillis();
        int numeroCalculado = this.delegate.calcular(numero);
        System.out.println("Tiempo de: " + numero + " in "
                + (System.currentTimeMillis() - start) + "ms");
        return numeroCalculado;
    }
}
