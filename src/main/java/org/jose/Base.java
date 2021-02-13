package org.jose;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Base {
    /**
     * opcion bottom up.
     */
    static final String MENU_BOTTOM_UP = "1";
    /**
     * opcion recursivo.
     */
    static final String MENU_RECURSIVO = "2";
    /**
     * opcion recursivo con memoria.
     */
    static final String MENU_RECURSIVO_MEMORIA = "3";
    /**
     * opcion salir.
     */
    static final String MENU_SALIR = "4";

    /**
     * @param args Arguments passed to the program invocation.
     */
    public static void main(final String[] args) {
        boolean salir = false;
        String opcion = "-1";
        Base objeto = new Base();
        Scanner sn = new Scanner(System.in);
        while (!salir) {
            System.out.println(" ");
            System.out.println("Elige que método usar "
                    + "para calcular fibonacci");
            System.out.println(" ");
            System.out.println("     " + MENU_BOTTOM_UP + ". BottomUp ");
            System.out.println("     " + MENU_RECURSIVO + ". Recursivo ");
            System.out.println("     " + MENU_RECURSIVO_MEMORIA
                    + ". Recursivo con Memoria ");
            System.out.println(" ");
            System.out.println("     " + MENU_SALIR + ". Salir ");
            opcion = sn.next();
            switch (opcion) {
                case MENU_BOTTOM_UP:
                    objeto.calcularTiempo(
                            new FibonacciBottomUp(objeto.escogerNumero(),
                                    new Impresora()));
                    break;
                case MENU_RECURSIVO:
                    objeto.calcularTiempo(
                            new FibonacciRecursivo(objeto.escogerNumero(),
                                    new Impresora()));
                    break;
                case MENU_RECURSIVO_MEMORIA:
                    objeto.calcularTiempo(
                            new FibonacciRecursivoMemorizacion(
                                    objeto.escogerNumero(), new Impresora()));
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

    private void calcularTiempo(final FibonacciConMetodo tipo) {
        new FibonacciConTiempo(tipo).run();

    }

    private int escogerNumero() {
        int numero = -1;
        Scanner sn = new Scanner(System.in);
        System.out.println("¿Qué número quieres calcular? ");
        while (numero < 0) {
            try {
                numero = sn.nextInt();
                if (numero < 0) {
                    System.out.println("Inserta un numero mayor que 0");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un numero");
                sn.next();
            }
        }
        return numero;
    }
}
