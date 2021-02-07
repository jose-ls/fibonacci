package org.jose;

/**
 * Implementa la clase Fibonacci con timepo.
 */
public final class FibonacciConTiempo implements Runnable {
    /**
     *
     */
    private final Runnable delegate;

    /**
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
