package com.laboratoriochad.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.laboratoriochad.dominio.Investigador;

public class GestorInvestigadores {
    private List<Investigador> investigadores = new ArrayList<>();

    public Investigador registrarInvestigador(String nombre, int edad) {
        Investigador inv = new Investigador(nombre, edad);
        investigadores.add(inv);
        return inv;
    }

    public Investigador buscarPorNombre(String nombre) {
        for (Investigador i : investigadores) {
            if (i.getNombre().equalsIgnoreCase(nombre)) return i;
        }
        return null;
    }

    public Investigador investigadorMasActivo() {
        return investigadores.stream()
                .max(Comparator.comparingInt(Investigador::getCantidadExperimentos))
                .orElse(null);
    }

    public List<Investigador> getInvestigadores() { return investigadores; }

}
