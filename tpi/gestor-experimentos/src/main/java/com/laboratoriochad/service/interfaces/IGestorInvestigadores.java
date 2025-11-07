package com.laboratoriochad.service.interfaces;

import java.util.List;

import com.laboratoriochad.dominio.Investigador;
import com.laboratoriochad.exceptions.DatosInvalidosException;
import com.laboratoriochad.exceptions.InvestigadorNoEncontradoException;

public interface IGestorInvestigadores {
    void registrarInvestigador(String nombre, int edad) throws DatosInvalidosException;
    Investigador buscarPorNombre(String nombre) throws InvestigadorNoEncontradoException;
    Investigador investigadorMasActivo();
    List<Investigador> getInvestigadores();
}
