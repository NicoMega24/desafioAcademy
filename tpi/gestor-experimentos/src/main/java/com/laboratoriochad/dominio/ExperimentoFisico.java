package com.laboratoriochad.dominio;

import java.util.List;

public class ExperimentoFisico extends Experimento {
    private String instrumento;
    private List<Investigador> investigadores;

    public ExperimentoFisico(String nombre, int duracion, boolean exitoso, String instrumento, List<Investigador> investigadores) {
        super(nombre, duracion, exitoso);
        this.instrumento = instrumento;
        this.investigadores = investigadores;

        for (Investigador inv : investigadores) {
            inv.incrementarExperimentos();
        }
    }

    public String getInstrumento() {
        return instrumento;
    }

    public List<Investigador> getInvestigadores() {
        return investigadores;
    }

    @Override
    public String getTipo() {
        return "Experimento Físico";
    }

    @Override
    public String toString() {
        StringBuilder nombres = new StringBuilder();
        for (Investigador inv : investigadores) {
            nombres.append(inv.getNombre()).append(", ");
        }
        if (!investigadores.isEmpty()) {
            nombres.setLength(nombres.length() - 2);
        }

        return super.toString() + 
               String.format(", instrumento=%s, investigadores=[%s]", instrumento, nombres.toString());
    }
}
