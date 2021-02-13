package org.jose;

public class Impresora implements ResultListener {
    /**
     *
     * @param result .
     */
    @Override
    public void onResult(int result) {
        System.out.println("El resultado es: " + result);
    }
}
