package org.jose;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Base {
    /**
     * Entry point.
     * @param args Arguments passed to the program invocation.
     */
    public static void main(final String[] args) {
        Base objeto = new Base();
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        while (!salir) {
            System.out.println("Elige que método usar "
                    + "para calcular fibonacci");
            System.out.println(" ");
            System.out.println("     1. BottomUp ");
            System.out.println("     2. Recursivo ");
            System.out.println("     3. Recursivo con Memoria ");
            System.out.println(" ");
            System.out.println("     4. Salir ");

            try {
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        objeto.calcularTiempo(objeto.escogerNumero(),
                                new FibonacciBottomUp());
                        break;
                    case 2:
                        objeto.calcularTiempo(objeto.escogerNumero(),
                                new FibonacciRecursivo());
                        break;
                    case 3:
                        objeto.calcularTiempo(objeto.escogerNumero(),
                                new FibonacciRecursivoMemorizacion());
                        break;
                    case 4:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo hay cuatro opciones,"
                                + " elige entre 1,2,3 y 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un numero");
                sn.next();
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
        Scanner sn = new Scanner(System.in);
        while (numero < 0) {
            System.out.println("¿Qué número quieres calcular? ");
            numero = sn.nextInt();
            try {
                if (numero < 0) {
                    System.out.println("Inserta un numero mayor que 0");
                    sn.next();
                    numero = sn.nextInt();
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un numero");
                sn.next();
                numero = sn.nextInt();
            }
        }
        return numero;
    }
}
