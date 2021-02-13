package org.jose;

/**
 * Implementa la clase Impresora.
 */
public class Impresora implements ResultListener {
    /**
     *
     * @param result resultado del calculo.
     */
    @Override
    public void onResult(final int result) {
        System.out.println("El resultado es: " + result);
    }
}
