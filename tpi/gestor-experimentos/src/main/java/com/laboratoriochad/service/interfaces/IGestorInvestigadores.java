package com.laboratoriochad.service.interfaces;

import java.util.List;

import com.laboratoriochad.dominio.Investigador;

public interface IGestorInvestigadores {
    void registrarInvestigador(String nombre, int edad);
    Investigador buscarPorNombre(String nombre);
    Investigador investigadorMasActivo();
    List<Investigador> getInvestigadores();
}
