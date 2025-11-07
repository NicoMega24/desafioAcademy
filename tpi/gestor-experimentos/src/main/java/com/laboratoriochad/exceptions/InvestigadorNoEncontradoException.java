package com.laboratoriochad.exceptions;

public class InvestigadorNoEncontradoException extends Exception {
    public InvestigadorNoEncontradoException(String nombre) {
        super("No se encontró un investigador con el nombre: " + nombre);
    }
}
