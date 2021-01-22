package org.jose;

public class F {
    /**
     * Entry point.
     *
     * @param args Arguments passed to the program invocation.
     */
    public static void main(final String[] args) {

        F objeto = new F();
        int numero = Integer.parseInt(args[0]);
        objeto.calcularTiempo(numero, new FibonacciBottomUp());
        objeto.calcularTiempo(numero, new FibonacciRecursivo());

    }

    private void calcularTiempo(final int numero,
                                       final FibonacciConMetodo tipo) {

        FibonacciConTiempo calculado = new FibonacciConTiempo(tipo);
        System.out.println("El resultado es: " + calculado.calcular(numero));

    }


}
