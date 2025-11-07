package com.laboratoriochad.service.interfaces;

import java.util.List;

import com.laboratoriochad.dominio.Experimento;
import com.laboratoriochad.exceptions.DatosInvalidosException;
import com.laboratoriochad.exceptions.ExperimentoNoEncontradoException;

public interface IGestorExperimentos {
    void agregarExperimento(Experimento experimento) throws DatosInvalidosException;
    List<Experimento> getExperimentos();
    long contarExitosos();
    long contarFallidos();
    Experimento mayorDuracion() throws ExperimentoNoEncontradoException;
}
