package org.jose;

/**
 * Esta clase define objetos de la clase ImpresoraDeResultados que se usan para
 * para imprimir un resultado de un calculo.
 */
public class ImpresoraDeResultados implements ResultListener {
    /**
     * Este método imprime el resultado de un cálculo.
     *
     * @param result resultado del calculo.
     */
    @Override
    public void onResult(final int result) {
        System.out.println("El resultado es: " + result);
    }
}
