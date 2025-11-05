package com.laboratoriochad.dominio;

public class ExperimentoQuimico extends Experimento {
    private String tipoReactivo;
    private Investigador investigadorPrincipal;

    public ExperimentoQuimico(String nombre, int duracion, boolean exitoso, String tipoReactivo, Investigador investigadorPrincipal) {
        super(nombre, duracion, exitoso);
        this.tipoReactivo = tipoReactivo;
        this.investigadorPrincipal = investigadorPrincipal;
        this.investigadorPrincipal.incrementarExperimentos();
    }

    public String getTipoReactivo() {
        return tipoReactivo;
    }

    public Investigador getInvestigadorPrincipal() {
        return investigadorPrincipal;
    }

    @Override
    public String getTipo() {
        return "Experimento Químico";
    }

    @Override
    public String toString() {
        return super.toString() + 
               String.format(", reactivo=%s, investigador=%s", tipoReactivo, investigadorPrincipal.getNombre());
    }
}
