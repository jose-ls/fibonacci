package org.jose;

public class F {
    /**
     * Entry point.
     * @param args Arguments passed to the program invocation.
     */
    public static void main(final String[] args) {

        int h = 0;
        System.out.println("HOLA,ADIOS");
        final F jl = new F();
        long start = System.currentTimeMillis();
        h = jl.fibonaccirecursivo(Integer.parseInt(args[0]));
        System.out.println("Recursive: " + h + " in " + (System.currentTimeMillis() - start) + "ms");

    }

    private int fibonaccirecursivo(final int n) {
        if (n == 1 || n == 0) {
            return 1;
        } else {
            if (n > 0) {
                return fibonaccirecursivo(n - 1) + fibonaccirecursivo(n - 2);
            } else {
                throw new RuntimeException("Error de calculo con: " + n);
            }
        }
    }

}
