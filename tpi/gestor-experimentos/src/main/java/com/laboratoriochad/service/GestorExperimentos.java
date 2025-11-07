package com.laboratoriochad.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.laboratoriochad.dominio.Experimento;
import com.laboratoriochad.exceptions.DatosInvalidosException;
import com.laboratoriochad.exceptions.ExperimentoNoEncontradoException;
import com.laboratoriochad.service.interfaces.IGestorExperimentos;

public class GestorExperimentos implements IGestorExperimentos {
    private final List<Experimento> experimentos = new ArrayList<>();

    @Override
    public void agregarExperimento(Experimento e) throws DatosInvalidosException {
        if (e == null) {
            throw new DatosInvalidosException("El experimento no puede ser nulo");
        }
        experimentos.add(e);
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
    public Experimento mayorDuracion() throws ExperimentoNoEncontradoException {
        return experimentos.stream()
            .max(Comparator.comparingInt(Experimento::getDuracion))
            .orElseThrow(() -> new ExperimentoNoEncontradoException("No hay experimentos registrados"));
    }
}

