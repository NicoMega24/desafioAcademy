package com.laboratoriochad;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.laboratoriochad.dominio.Experimento;
import com.laboratoriochad.dominio.ExperimentoFisico;
import com.laboratoriochad.dominio.ExperimentoQuimico;
import com.laboratoriochad.dominio.Investigador;
import com.laboratoriochad.service.GestorExperimentos;
import com.laboratoriochad.service.GestorInvestigadores;
import com.laboratoriochad.service.ReporteService;
import com.laboratoriochad.service.interfaces.IGestorExperimentos;
import com.laboratoriochad.service.interfaces.IGestorInvestigadores;
import com.laboratoriochad.service.interfaces.IReporteService;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IGestorInvestigadores gestorInv = new GestorInvestigadores();
        IGestorExperimentos gestorExp = new GestorExperimentos();
        IReporteService reporte = new ReporteService();

        int opcion;
        do {
            System.out.println("\n=== Laboratorio Chad ===");
            System.out.println("1. Registrar investigador");
            System.out.println("2. Registrar experimento químico");
            System.out.println("3. Registrar experimento físico");
            System.out.println("4. Mostrar experimentos");
            System.out.println("5. Estadísticas");
            System.out.println("6. Exportar investigadores a CSV");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Edad: ");
                    int edad = sc.nextInt();
                    gestorInv.registrarInvestigador(nombre, edad);
                }
                case 2 -> {
                    System.out.print("Nombre del experimento: ");
                    String nombre = sc.nextLine();
                    System.out.print("Duración (min): ");
                    int duracion = sc.nextInt();
                    System.out.print("¿Fue exitoso? (true/false): ");
                    boolean exito = sc.nextBoolean(); sc.nextLine();
                    System.out.print("Tipo de reactivo: ");
                    String reactivo = sc.nextLine();
                    System.out.print("Nombre del investigador: ");
                    String invNom = sc.nextLine();

                    Investigador inv = gestorInv.buscarPorNombre(invNom);
                    if (inv != null) {
                        gestorExp.agregarExperimento(new ExperimentoQuimico(nombre, duracion, exito, reactivo, inv));
                    } else System.out.println("Investigador no encontrado.");
                }
                case 3 -> {
                    System.out.print("Nombre del experimento: ");
                    String nombre = sc.nextLine();
                    System.out.print("Duración (min): ");
                    int duracion = sc.nextInt();
                    System.out.print("¿Fue exitoso? (true/false): ");
                    boolean exito = sc.nextBoolean(); sc.nextLine();
                    System.out.print("Instrumento: ");
                    String instrumento = sc.nextLine();
                    System.out.print("Cantidad de investigadores: ");
                    int cant = sc.nextInt(); sc.nextLine();

                    List<Investigador> lista = new ArrayList<>();
                    for (int i = 0; i < cant; i++) {
                        System.out.print("Nombre investigador " + (i + 1) + ": ");
                        Investigador inv = gestorInv.buscarPorNombre(sc.nextLine());
                        if (inv != null) lista.add(inv);
                    }
                    gestorExp.agregarExperimento(new ExperimentoFisico(nombre, duracion, exito, instrumento, lista));
                }
                case 4 -> gestorExp.getExperimentos().forEach(System.out::println);
                case 5 -> {
                    System.out.println("Total exitosos: " + gestorExp.contarExitosos());
                    System.out.println("Total fallidos: " + gestorExp.contarFallidos());
                    Experimento mayor = gestorExp.mayorDuracion();
                    if (mayor != null) System.out.println("Mayor duración: " + mayor.getNombre());
                    System.out.println("Promedio duración: " + reporte.promedioDuracion(gestorExp.getExperimentos()));
                    System.out.println("Porcentaje éxito: " + reporte.porcentajeExito(gestorExp.getExperimentos()) + "%");
                    Investigador top = gestorInv.investigadorMasActivo();
                    if (top != null) System.out.println("Investigador más activo: " + top);
                }
                case 6 -> reporte.exportarInvestigadoresCSV(gestorInv.getInvestigadores());
                case 0 -> System.out.println("Hasta luego!");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }
}

