package com.laboratoriochad.service;

import java.util.List;

import com.laboratoriochad.dominio.Experimento;
import com.laboratoriochad.dominio.Investigador;
import com.laboratoriochad.service.interfaces.IReporteService;
import com.laboratoriochad.utils.CSVExporter;

public class ReporteService implements IReporteService {

    @Override
    public double promedioDuracion(List<Experimento> experimentos) {
        return experimentos.stream().mapToInt(Experimento::getDuracion).average().orElse(0);
    }

    @Override
    public double porcentajeExito(List<Experimento> experimentos) {
        if (experimentos.isEmpty()) return 0;
        long exitosos = experimentos.stream().filter(Experimento::isExitoso).count();
        return (double) exitosos / experimentos.size() * 100;
    }

    @Override
    public void exportarInvestigadoresCSV(List<Investigador> investigadores) {
        CSVExporter.exportar(investigadores);
    }
}
