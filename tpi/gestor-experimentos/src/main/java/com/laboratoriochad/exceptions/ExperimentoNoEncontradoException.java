package com.laboratoriochad.exceptions;

public class ExperimentoNoEncontradoException extends Exception {
    public ExperimentoNoEncontradoException(String nombre) {
        super("No se encontró un experimento con el nombre: " + nombre);
    }
}
