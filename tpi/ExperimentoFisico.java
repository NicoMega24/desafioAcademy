
import java.util.List;

public class ExperimentoFisico extends Experimento {
    private String instrumento;
    private List<Investigador> investigadores;

    public ExperimentoFisico(String nombre, int duracion, boolean exito, String instrumento, List<Investigador> investigadores) {
        super(nombre, duracion, exito);
        this.instrumento = instrumento;
        this.investigadores = investigadores;
        for (Investigador i : investigadores) {
            i.incrementarExperimentos();
        }
    }

    @Override
    public String getTipo() { 
        return "Físico"; 
    }

    public String getInstrumento() {
        return instrumento;
    }

    public List<Investigador> getInvestigadores() {
        return investigadores; 
    }

}
