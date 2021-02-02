package org.jose;

import java.util.Scanner;

public class Base {
    /**
     * Entry point.
     * @param MENU_BOTTOM_UP
     * @param MENU_RECURSIVO
     * @param MENU_RECURSIVO_MEMORIA
     * @param MENU_SALIR
     * @param salir
     * @param opcion almacena la opcion elegida
     */
    static final String MENU_BOTTOM_UP = "1";
    static final String MENU_RECURSIVO = "2";
    static final String MENU_RECURSIVO_MEMORIA = "3";
    static final String MENU_SALIR = "4";
    static boolean salir = false;
    static String opcion = "-1";
    /**
     * Entry point.
     * @param args Arguments passed to the program invocation.
     */
    public static void main(final String[] args) {
        Base objeto = new Base();
        Scanner sn = new Scanner(System.in);
        while (!salir) {
            System.out.println(" ");
            System.out.println("Elige que método usar "
                    + "para calcular fibonacci");
            System.out.println(" ");
            System.out.println("     1. BottomUp ");
            System.out.println("     2. Recursivo ");
            System.out.println("     3. Recursivo con Memoria ");
            System.out.println(" ");
            System.out.println("     4. Salir ");
            opcion = sn.next();
            switch (opcion) {
                case MENU_BOTTOM_UP:
                    objeto.calcularTiempo(objeto.escogerNumero(),
                            new FibonacciBottomUp());
                    break;
                case MENU_RECURSIVO:
                    objeto.calcularTiempo(objeto.escogerNumero(),
                            new FibonacciRecursivo());
                    break;
                case MENU_RECURSIVO_MEMORIA:
                    objeto.calcularTiempo(objeto.escogerNumero(),
                            new FibonacciRecursivoMemorizacion());
                    break;
                case MENU_SALIR:
                    salir = true;
                    break;
                default:
                    System.out.println(" ");
                    System.out.println("Solo hay cuatro opciones,"
                            + " elige entre 1,2,3 y 4");
            }
        }
    }

    private void calcularTiempo(final int numero,
                                final FibonacciConMetodo tipo) {
        FibonacciConTiempo calculado = new FibonacciConTiempo(tipo);
        System.out.println("El resultado es: " + calculado.calcular(numero));
    }

    private int escogerNumero() {
        int numero = -1;
        String scanNumber;
        int auxNumber;
        Scanner sn = new Scanner(System.in);
        System.out.println("¿Qué número quieres calcular? ");
        while (numero < 0) {
            try {
                scanNumber = sn.next();
                auxNumber = Integer.parseInt(scanNumber);
                if (auxNumber > 0) {
                    numero = auxNumber;
                }
            } catch (NumberFormatException e) {
                System.out.println("Introduce un numero valido");
            }
        }
        return numero;
    }
}
