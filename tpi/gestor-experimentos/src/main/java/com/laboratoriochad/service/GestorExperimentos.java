package com.laboratoriochad.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.laboratoriochad.dominio.Experimento;

public class GestorExperimentos {
    private List<Experimento> experimentos = new ArrayList<>();

    public void agregarExperimento(Experimento e) {
        experimentos.add(e);
    }

    public long contarExitosos() {
        return experimentos.stream().filter(Experimento::isExito).count();
    }

    public long contarFallidos() {
        return experimentos.size() - contarExitosos();
    }

    public Experimento mayorDuracion() {
        return experimentos.stream()
                .max(Comparator.comparingInt(Experimento::getDuracionMinutos))
                .orElse(null);
    }

    public List<Experimento> getExperimentos() { return experimentos; }
}
