package org.jose;

/**
 * Implementa la clase Fibonacci con timepo.
 */
public final class FibonacciConTiempo implements Runnable {
    /**
     * Campo de la clase.
     */
    private final Runnable delegate;

    /**
     * Constructor para la clase Fibonacci con tiempo.
     *
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
