package com.laboratoriochad.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.laboratoriochad.dominio.Investigador;
import com.laboratoriochad.service.interfaces.IGestorInvestigadores;

public class GestorInvestigadores implements IGestorInvestigadores {
    private final List<Investigador> investigadores = new ArrayList<>();

    @Override
    public void registrarInvestigador(String nombre, int edad) {
        investigadores.add(new Investigador(nombre, edad));
    }

    @Override
    public Investigador buscarPorNombre(String nombre) {
        return investigadores.stream()
                .filter(i -> i.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Investigador investigadorMasActivo() {
        return investigadores.stream()
                .max(Comparator.comparingInt(Investigador::getCantidadExperimentos))
                .orElse(null);
    }

    @Override
    public List<Investigador> getInvestigadores() {
        return investigadores;
    }
}

