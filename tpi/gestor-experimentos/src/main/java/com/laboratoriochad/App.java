package com.laboratoriochad;

import com.laboratoriochad.dominio.Menu;
import com.laboratoriochad.service.GestorExperimentos;
import com.laboratoriochad.service.GestorInvestigadores;
import com.laboratoriochad.service.ReporteService;

public class App {
    public static void main(String[] args) {

        GestorInvestigadores gestorInv = new GestorInvestigadores();
        GestorExperimentos gestorExp = new GestorExperimentos();
        ReporteService reporte = new ReporteService();

        Menu menu = new Menu(gestorInv, gestorExp, reporte);
        menu.iniciar();
    }
}