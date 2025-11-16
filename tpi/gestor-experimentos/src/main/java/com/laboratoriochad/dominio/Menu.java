package com.laboratoriochad.dominio;

import java.util.ArrayList;
import java.util.List;

import com.laboratoriochad.exceptions.DatosInvalidosException;
import com.laboratoriochad.exceptions.ExperimentoNoEncontradoException;
import com.laboratoriochad.exceptions.InvestigadorNoEncontradoException;
import com.laboratoriochad.service.GestorExperimentos;
import com.laboratoriochad.service.GestorInvestigadores;
import com.laboratoriochad.service.ManejoConsola;
import com.laboratoriochad.service.ReporteService;

public class Menu {

    private final GestorInvestigadores gestorInv;
    private final GestorExperimentos gestorExp;
    private final ReporteService reporte;
    private final ManejoConsola input;

    public Menu(GestorInvestigadores gestorInv, GestorExperimentos gestorExp, ReporteService reporte) {
        this.gestorInv = gestorInv;
        this.gestorExp = gestorExp;
        this.reporte = reporte;
        this.input = new ManejoConsola();
    }

    public void iniciar() {

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
            
            opcion = input.leerEntero("Opción: ");

            switch (opcion) {

                case 1 -> registrarInvestigador();
                case 2 -> registrarExperimentoQuimico();
                case 3 -> registrarExperimentoFisico();
                case 4 -> mostrarExperimentos();
                case 5 -> mostrarTotales();
                case 6 -> experimentoMayorDuracion();
                case 7 -> reporteSimple();
                case 8 -> investigadorMasActivo();
                case 9 -> exportarCSV();
                case 0 -> System.out.println("Hasta luego!");
                default -> System.out.println("Opción inválida, intente nuevamente.");
            }

        } while (opcion != 0);
    }

    private void registrarInvestigador() {
        try {
            String nombre = input.leerTexto("Nombre: ");
            int edad = input.leerEntero("Edad: ");
            
            gestorInv.registrarInvestigador(nombre, edad);
            System.out.println("Investigador registrado con éxito.");
        } catch (DatosInvalidosException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void registrarExperimentoQuimico() {

        String nombre = input.leerTexto("Nombre del experimento: ");
        int duracion = input.leerEntero("Duración (min): ");
        boolean exito = input.leerBoolean("¿Fue exitoso? (true/false): ");
        String reactivo = input.leerTexto("Tipo de reactivo: ");
        String invNom = input.leerTexto("Nombre del investigador: ");

        try {
            Investigador inv = gestorInv.buscarPorNombre(invNom);
            ExperimentoQuimico eq = new ExperimentoQuimico(nombre, duracion, exito, reactivo, inv);
            gestorExp.agregarExperimento(eq);
            System.out.println("Experimento químico registrado correctamente.");
        } 
        catch (InvestigadorNoEncontradoException e) {
            System.out.println("⚠ " + e.getMessage());
        } 
        catch (DatosInvalidosException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void registrarExperimentoFisico() {

        String nombre = input.leerTexto("Nombre del experimento: ");
        int duracion = input.leerEntero("Duración (min): ");
        boolean exito = input.leerBoolean("¿Fue exitoso? (true/false): ");
        String instrumento = input.leerTexto("Instrumento: ");
        int cant = input.leerEntero("Cantidad de investigadores: ");

        List<Investigador> lista = new ArrayList<>();

        for (int i = 0; i < cant; i++) {
            String nombreInv = input.leerTexto("Nombre investigador " + (i + 1) + ": ");
            try {
                Investigador inv = gestorInv.buscarPorNombre(nombreInv);
                lista.add(inv);
            } catch (InvestigadorNoEncontradoException e) {
                System.out.println("⚠ " + e.getMessage());
            }
        }

        if (lista.isEmpty()) {
            System.out.println("No se pudo registrar el experimento (sin investigadores válidos).");
            return;
        }

        try {
            ExperimentoFisico ef = new ExperimentoFisico(nombre, duracion, exito, instrumento, lista);
            gestorExp.agregarExperimento(ef);
            System.out.println("Experimento físico registrado correctamente.");
        } 
        catch (DatosInvalidosException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void mostrarExperimentos() {
        System.out.println("\n=== Lista de experimentos ===");
        
        if (gestorExp.getExperimentos().isEmpty()) {
            System.out.println("No hay experimentos registrados.");
        } else {
            gestorExp.getExperimentos().forEach(System.out::println);
        }
    }

    private void mostrarTotales() {
        System.out.println("Total exitosos: " + gestorExp.contarExitosos());
        System.out.println("Total fallidos: " + gestorExp.contarFallidos());
    }

    private void experimentoMayorDuracion() {
        try {
            Experimento mayor = gestorExp.mayorDuracion();
            System.out.println("Mayor duración: " + mayor.getNombre() + " (" + mayor.getDuracion() + " min)");
        } catch (ExperimentoNoEncontradoException e) {
            System.out.println("⚠ " + e.getMessage());
        }
    }

    private void reporteSimple() {
        System.out.println("Promedio duración: " + reporte.promedioDuracion(gestorExp.getExperimentos()));
        System.out.println("Porcentaje éxito: " + reporte.porcentajeExito(gestorExp.getExperimentos()) + "%");
    }

    private void investigadorMasActivo() {
        Investigador top = gestorInv.investigadorMasActivo();
        
        if (top != null) 
            System.out.println("Investigador más activo: " + top);
        else 
            System.out.println("No hay investigadores registrados.");
    }

    private void exportarCSV() {
        reporte.exportarInvestigadoresCSV(gestorInv.getInvestigadores());
        System.out.println("Archivo CSV generado correctamente.");
    }
}
