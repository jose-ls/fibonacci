package org.jose;

/**
 * Entry point.
 */
public final class FibonacciConTiempo implements Runnable {
    /**
     * Entry point.
     */
    private final Runnable delegate;
    /**
     * Entry point.
     * @param delegateA Objeto
     */
    public FibonacciConTiempo(final Runnable delegateA) {
        this.delegate = delegateA;
    }
    /**
     * Implementación método run.
     */
    public void run() {
        long start = System.currentTimeMillis();
        this.delegate.run();
        System.out.println("Tiempo de calculo: "
                + (System.currentTimeMillis() - start) + "ms");
    }
}
