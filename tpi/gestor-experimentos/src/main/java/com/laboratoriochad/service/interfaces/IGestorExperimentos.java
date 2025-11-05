package com.laboratoriochad.service.interfaces;

import java.util.List;

import com.laboratoriochad.dominio.Experimento;

public interface IGestorExperimentos {
    void agregarExperimento(Experimento experimento);
    List<Experimento> getExperimentos();
    long contarExitosos();
    long contarFallidos();
    Experimento mayorDuracion();
}
