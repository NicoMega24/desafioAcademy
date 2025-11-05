package com.laboratoriochad.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.laboratoriochad.dominio.Experimento;
import com.laboratoriochad.service.interfaces.IGestorExperimentos;

public class GestorExperimentos implements IGestorExperimentos {
    private final List<Experimento> experimentos = new ArrayList<>();

    @Override
    public void agregarExperimento(Experimento experimento) {
        experimentos.add(experimento);
    }

    @Override
    public List<Experimento> getExperimentos() {
        return experimentos;
    }

    @Override
    public long contarExitosos() {
        return experimentos.stream().filter(Experimento::isExitoso).count();
    }

    @Override
    public long contarFallidos() {
        return experimentos.stream().filter(e -> !e.isExitoso()).count();
    }

    @Override
    public Experimento mayorDuracion() {
        return experimentos.stream().max(Comparator.comparingInt(Experimento::getDuracion)).orElse(null);
    }
}

