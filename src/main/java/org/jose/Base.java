package org.jose;

public class Base {
    /**
     * Entry point.
     * @param args Arguments passed to the program invocation.
     */
    public static void main(final String[] args) {
        Base objeto = new Base();
        int numero = Integer.parseInt(args[0]);
        objeto.calcularTiempo(numero, new FibonacciBottomUp());
        objeto.calcularTiempo(numero, new FibonacciRecursivo());
        objeto.calcularTiempo(numero, new FibonacciRecursivoMemorizacion());
    }

    private void calcularTiempo(final int numero,
                                final FibonacciConMetodo tipo) {
        FibonacciConTiempo calculado = new FibonacciConTiempo(tipo);
        System.out.println("El resultado es: " + calculado.calcular(numero));
    }
}
