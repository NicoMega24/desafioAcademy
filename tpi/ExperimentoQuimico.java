public class ExperimentoQuimico extends Experimento {
    
    private String tipoReactivo;
    private Investigador investigador;

    public ExperimentoQuimico(String nombre, int duracion, boolean exito, String tipoReactivo, Investigador investigador) {
        super(nombre, duracion, exito);
        this.tipoReactivo = tipoReactivo;
        this.investigador = investigador;
        investigador.incrementarExperimentos();
    }

    @Override
    public String getTipo() { 
        return "Químico"; 
    }

    public Investigador getInvestigador() { 
        return investigador; 
    }
}