package com.laboratoriochad;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.laboratoriochad.dominio.Experimento;
import com.laboratoriochad.dominio.ExperimentoFisico;
import com.laboratoriochad.dominio.ExperimentoQuimico;
import com.laboratoriochad.dominio.Investigador;
import com.laboratoriochad.exceptions.DatosInvalidosException;
import com.laboratoriochad.exceptions.ExperimentoNoEncontradoException;
import com.laboratoriochad.exceptions.InvestigadorNoEncontradoException;
import com.laboratoriochad.service.GestorExperimentos;
import com.laboratoriochad.service.GestorInvestigadores;
import com.laboratoriochad.service.ReporteService;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorInvestigadores gestorInv = new GestorInvestigadores();
        GestorExperimentos gestorExp = new GestorExperimentos();
        ReporteService reporte = new ReporteService();

        int opcion;
        do {
            System.out.println("\n=== Laboratorio Chad ===");
            System.out.println("1. Registrar investigador");
            System.out.println("2. Registrar experimento químico");
            System.out.println("3. Registrar experimento físico");
            System.out.println("4. Mostrar experimentos");
            System.out.println("5. Mostrar total de exitosos y fallidos");
            System.out.println("6. Experimento de mayor duración");
            System.out.println("7. Reporte simple");
            System.out.println("8. Mostrar investigador más activo");
            System.out.println("9. Exportar investigadores a CSV");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1 -> {
                    try {
                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();
                        System.out.print("Edad: ");
                        int edad = sc.nextInt();
                        gestorInv.registrarInvestigador(nombre, edad);
                        System.out.println(" Investigador registrado con éxito.");
                    } catch (DatosInvalidosException e) {
                        System.out.println(" Error: " + e.getMessage());
                    }
                }

                case 2 -> {
                    System.out.print("Nombre del experimento: ");
                    String nombre = sc.nextLine();
                    System.out.print("Duración (minutos): ");
                    int duracion = sc.nextInt();
                    sc.nextLine();
                    System.out.print("¿Fue exitoso? (true/false): ");
                    boolean exito = sc.nextBoolean();
                    sc.nextLine();
                    System.out.print("Tipo de reactivo: ");
                    String reactivo = sc.nextLine();
                    System.out.print("Nombre del investigador: ");
                    String invNom = sc.nextLine();

                    try {
                        Investigador inv = gestorInv.buscarPorNombre(invNom); // puede lanzar InvestigadorNoEncontradoException
                        if (inv == null) {
                            throw new InvestigadorNoEncontradoException("El investigador '" + invNom + "' no fue encontrado.");
                        }

                        ExperimentoQuimico eq = new ExperimentoQuimico(nombre, duracion, exito, reactivo, inv);
                        gestorExp.agregarExperimento(eq);
                        System.out.println(" Experimento químico registrado correctamente.");
                        
                    } catch (InvestigadorNoEncontradoException e) {
                        System.out.println(" " + e.getMessage());
                    } catch (DatosInvalidosException e) {
                        System.out.println(" Error en los datos del experimento: " + e.getMessage());
                    }
}

                case 3 -> {
                    System.out.print("Nombre del experimento: ");
                    String nombre = sc.nextLine();
                    System.out.print("Duración (minutos): ");
                    int duracion = sc.nextInt();
                    sc.nextLine();
                    System.out.print("¿Fue exitoso? (true/false): ");
                    boolean exito = sc.nextBoolean();
                    sc.nextLine();
                    System.out.print("Instrumento: ");
                    String instrumento = sc.nextLine();
                    System.out.print("Cantidad de investigadores: ");
                    int cant = sc.nextInt();
                    sc.nextLine();

                    List<Investigador> lista = new ArrayList<>();
                    for (int i = 0; i < cant; i++) {
        System.out.print("Nombre investigador " + (i + 1) + ": ");
        String nombreInv = sc.nextLine();
        try {
            Investigador inv = gestorInv.buscarPorNombre(nombreInv);
            lista.add(inv);
        } catch (InvestigadorNoEncontradoException e) {
            System.out.println("⚠️ " + e.getMessage());
        }
            }

            if (lista.isEmpty()) {
                System.out.println(" No se pudo registrar el experimento (sin investigadores válidos).");
                return; 
            }

            try {
                ExperimentoFisico ef = new ExperimentoFisico(nombre, duracion, exito, instrumento, lista);
                gestorExp.agregarExperimento(ef);
                System.out.println(" Experimento físico registrado correctamente.");
            } catch (DatosInvalidosException e) {
                System.out.println(" Error en los datos del experimento: " + e.getMessage());
            }
        }

                case 4 -> {
                    System.out.println("\n=== Lista de experimentos ===");
                    if (gestorExp.getExperimentos().isEmpty()) {
                        System.out.println("No hay experimentos registrados.");
                    } else {
                        gestorExp.getExperimentos().forEach(System.out::println);
                    }
                }

                case 5 -> {
                    System.out.println("Total exitosos: " + gestorExp.contarExitosos());
                    System.out.println("Total fallidos: " + gestorExp.contarFallidos());
                }

                case 6 -> {
                    try {
                        Experimento mayor = gestorExp.mayorDuracion();
                        System.out.println("Experimento de mayor duración: " + mayor.getNombre() + " (" + mayor.getDuracion() + " min)");
                    } catch (ExperimentoNoEncontradoException e) {
                        System.out.println("⚠️ " + e.getMessage());
                    }
                }

                case 7 -> {
                    System.out.println("Promedio de duración: " + reporte.promedioDuracion(gestorExp.getExperimentos()));
                    System.out.println("Porcentaje de éxito: " + reporte.porcentajeExito(gestorExp.getExperimentos()) + "%");
                }

                case 8 -> {
                    Investigador top = gestorInv.investigadorMasActivo();
                    if (top != null)
                        System.out.println("Investigador más activo: " + top);
                    else
                        System.out.println("No hay investigadores registrados.");
                }

                case 9 -> {
                    reporte.exportarInvestigadoresCSV(gestorInv.getInvestigadores());
                    System.out.println(" Archivo CSV generado correctamente.");
                }

                case 0 -> System.out.println("Hasta luego!");

                default -> System.out.println(" Opción inválida, intente nuevamente.");
            }
        } while (opcion != 0);
     sc.close();
}
}
