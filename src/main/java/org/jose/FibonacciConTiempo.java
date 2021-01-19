package org.jose;

public class FibonacciConTiempo implements FibonacciCalculator{
    private final FibonacciCalculator delegate;

    public FibonacciConTiempo(FibonacciCalculator _delegate) {
        this.delegate = _delegate;

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
