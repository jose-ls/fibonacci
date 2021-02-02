package org.jose;

import java.util.Scanner;

public class Base {
    /**
     * Entry point.
     *
     * @param args Arguments passed to the program invocation.
     */
    public static void main(final String[] args) {
        Base objeto = new Base();
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        String opcion = "-1";
        final String menuBottomUp = "1";
        final String menuRecursivo = "2";
        final String menuRecursivoMemoria = "3";
        final String menuSalir = "4";
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
                case menuBottomUp:
                    objeto.calcularTiempo(objeto.escogerNumero(),
                            new FibonacciBottomUp());
                    break;
                case menuRecursivo:
                    objeto.calcularTiempo(objeto.escogerNumero(),
                            new FibonacciRecursivo());
                    break;
                case menuRecursivoMemoria:
                    objeto.calcularTiempo(objeto.escogerNumero(),
                            new FibonacciRecursivoMemorizacion());
                    break;
                case menuSalir:
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
        while (numero < 0) {
            System.out.println("¿Qué número quieres calcular? ");
            try {
                scanNumber = sn.next();
                auxNumber = Integer.parseInt(scanNumber);
                if (auxNumber > 0) {
                    numero = auxNumber;
                } else {
                    System.out.println("Inserta un numero valido");
                    scanNumber = sn.next();
                }
            } catch (NumberFormatException e) {
                System.out.println("Introduce un numero valido");
            }
        }
        return numero;
    }
}
