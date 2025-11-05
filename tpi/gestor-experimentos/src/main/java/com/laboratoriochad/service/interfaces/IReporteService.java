package com.laboratoriochad.service.interfaces;

import java.util.List;

import com.laboratoriochad.dominio.Experimento;
import com.laboratoriochad.dominio.Investigador;

public interface IReporteService {
    double promedioDuracion(List<Experimento> experimentos);
    double porcentajeExito(List<Experimento> experimentos);
    void exportarInvestigadoresCSV(List<Investigador> investigadores);
}
