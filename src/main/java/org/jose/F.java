package org.jose;

public class F {
    /**
     * Entry point.
     *
     * @param args Arguments passed to the program invocation.
     */
    public static void main(final String[] args) {


        int numero = Integer.parseInt(args[0]);
        calcularTiempo(numero,new FibonacciBottomUp());
        calcularTiempo(numero,new FibonacciRecursivo());

    }

    private static void calcularTiempo(int numero, FibonacciConMetodo tipo) {

        FibonacciConTiempo calculado = new FibonacciConTiempo(tipo);
        System.out.println("El resultado es: "+calculado.calcular(numero));

    }


}
