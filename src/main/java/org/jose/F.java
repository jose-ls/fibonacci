package org.jose;

public class F {
    /**
     * Entry point.
     * @param args Arguments passed to the program invocation.
     */
    public static void main(final String[] args) {

        int h = 0;
        int j = 0;
        final F jl = new F();
        long start = System.currentTimeMillis();
        h = jl.fibonaccirecursivo(Integer.parseInt(args[0]));
        System.out.println("Recursive: " + h + " in "
                + (System.currentTimeMillis() - start) + "ms");


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

    private int fibonaccibottom_up(int n) {
        int resultado = 1;
        int nmenos1 = 1;
        int nmenos2 = 1;
        if (n == 1 || n == 0) {
            return 1;
        } else {
            if (n > 0) {
                for (int i = 2; i < n; i++) {
                    resultado = nmenos1 + nmenos2;
                    nmenos2 = nmenos1;
                    nmenos1 = resultado;
                }
                return resultado;
            } else {
                throw new RuntimeException("Error de calculo con: " + n);
            }

        }
    }

}