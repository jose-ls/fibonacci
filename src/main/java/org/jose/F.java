package org.jose;

public class F {
    public static void main(String[] args) {
        System.out.println("HOLA,ADIOS");
    }

    private int fibonacci(int n) {
        if (n == 1 || n == 0) {
            return 1;
        } else {
            if (n > 0) {
                return fibonacci(n - 1) + fibonacci(n - 2);
            } else {
                throw new Exception()            }
        }
    }
}
