package com.laboratoriochad.service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.laboratoriochad.dominio.Experimento;
import com.laboratoriochad.dominio.Investigador;

public class ReporteService {
    public void exportarInvestigadoresCSV(List<Investigador> investigadores) {
        try (FileWriter writer = new FileWriter("investigadores.csv")) {
            writer.write("nombre,edad,cantidad_experimentos\n");
            for (Investigador i : investigadores) {
                writer.write(i.getNombre() + "," + i.getEdad() + "," + i.getCantidadExperimentos() + "\n");
            }
            System.out.println("Archivo investigadores.csv generado con éxito!");
        } catch (IOException e) {
            System.out.println("Error al exportar CSV: " + e.getMessage());
        }
    }

    public double promedioDuracion(List<Experimento> exps) {
        return exps.stream().mapToInt(Experimento::getDuracionMinutos).average().orElse(0);
    }

    public double porcentajeExito(List<Experimento> exps) {
        long exitos = exps.stream().filter(Experimento::isExito).count();
        return (double) exitos / exps.size() * 100;
    }

}
