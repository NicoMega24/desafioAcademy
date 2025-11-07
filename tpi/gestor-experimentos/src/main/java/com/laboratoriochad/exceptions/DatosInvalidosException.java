package com.laboratoriochad.exceptions;

public class DatosInvalidosException extends Exception {
    public DatosInvalidosException(String mensaje) {
        super("Error en los datos ingresados: " + mensaje);
    }
}
