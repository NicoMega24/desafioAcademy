package com.laboratoriochad.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.laboratoriochad.dominio.Investigador;

public class CSVExporter {
    public static void exportar(List<Investigador> investigadores) {
        try (FileWriter writer = new FileWriter("investigadores.csv")) {
            writer.write("Nombre,Edad,Experimentos\n");
            for (Investigador i : investigadores) {
                writer.write(i.getNombre() + "," + i.getEdad() + "," + i.getCantidadExperimentos() + "\n");
            }
            System.out.println("Archivo CSV generado con éxito.");
        } catch (IOException e) {
            System.out.println("Error exportando CSV: " + e.getMessage());
        }
    }
}
