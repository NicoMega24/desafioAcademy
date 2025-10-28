package ejercicios.desafio2.entrega2;

import java.util.List;

public class Curso {

    //Atributos:
    private List<Alumno> alumnos;

    //Constructor:
    public Curso(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    //Getters:
    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    //Métodos:
    //punto 6.1:
    public Alumno mejorPromedio() {
        Alumno mejor = alumnos.get(0);
        for (Alumno a : alumnos) {
            if (a.promedio() > mejor.promedio()) {
                mejor = a;
            }
        }
        return mejor;
    }

    //punto 6.2:
    public Alumno masRegular() {
        Alumno regular = alumnos.get(0);
        int menorDif = regular.diferenciaMaxMin();
        for (Alumno a : alumnos) {
            int dif = a.diferenciaMaxMin();
            if (dif < menorDif) {
                menorDif = dif;
                regular = a;
            }
        }
        return regular;
    }

    //punto 6.3:
    public Alumno peorEnTerceraPrueba() {
        Alumno peor = alumnos.get(0);
        for (Alumno a : alumnos) {
            if (a.getNotas().get(2) < peor.getNotas().get(2)) {
                peor = a;
            }
        }
        return peor;
    }

}

