package com.laboratoriochad.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.laboratoriochad.dominio.Investigador;
import com.laboratoriochad.exceptions.DatosInvalidosException;
import com.laboratoriochad.exceptions.InvestigadorNoEncontradoException;
import com.laboratoriochad.service.interfaces.IGestorInvestigadores;

public class GestorInvestigadores implements IGestorInvestigadores {
    private final List<Investigador> investigadores = new ArrayList<>();

    @Override
    public void registrarInvestigador(String nombre, int edad) throws DatosInvalidosException {
        if (nombre == null || nombre.isBlank()) {
            throw new DatosInvalidosException("El nombre no puede estar vacío");
        }
        if (edad <= 0) {
            throw new DatosInvalidosException("La edad debe ser mayor que cero");
        }
        investigadores.add(new Investigador(nombre, edad));
    }
    @Override
    public Investigador buscarPorNombre(String nombre) throws InvestigadorNoEncontradoException {
        return investigadores.stream()
            .filter(i -> i.getNombre().equalsIgnoreCase(nombre))
            .findFirst()
            .orElseThrow(() -> new InvestigadorNoEncontradoException(nombre));
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

