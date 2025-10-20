package ejercicios.desafio2.entrega2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Alumno {
    //Atributos:
    private String nombre;
    private List<Integer> notas;

    // Constructor
    public Alumno(String nombre, List<Integer> notas) {
        this.nombre = nombre;
        this.notas = notas;
    }

    // Getters:
    public String getNombre() {
        return nombre;
    }

    public List<Integer> getNotas() {
        return notas;
    }

    // Métodos:
    //punto 1:
    public String resultadoAprobacion() {
    int aprobadas = 0;

    // Contar cuántas notas son 60 o más
        for (int nota : notas) {
            if (nota >= 60) {
                aprobadas++;
            }
        }
        if (aprobadas == notas.size()) {
            return "Aprobaste todas. ¡Backend Sensei!";
        } else if (aprobadas == 0) {
            return "No aprobaste ninguna. ¡Sos un clon de frontend!";
        } else {
            return "Algunas aprobadas. Sos un refactor en progreso.";
        }
    }
   
    //punto 2:
    public int mayorVariacion() {
        int mayorVariacion = 0;
        
        for (int i = 0; i < notas.size() -1; i++) {
            int diferencia = Math.abs(notas.get(i + 1) - notas.get(i));
            if (diferencia > mayorVariacion){
                mayorVariacion = diferencia;
            }
        }
        return  mayorVariacion;
    }
    
    //punto 3:
    public boolean esProgresivo() {
        for (int i = 0; i < notas.size() - 1; i++) {
            if (notas.get(i + 1) <= notas.get(i)) 
            return false;
        }
        return true;
        
    }
    
    //punto 4:
    public List<Integer> notasOrdenadasDescendente() {
        //genero copia de la lista original para no modificarla
        List<Integer> copia = new ArrayList<>(notas);
        List<Integer> ordenadas = new ArrayList<>();
        
        while (!copia.isEmpty()) {
            int max = copia.get(0);
            int pos = 0;
            // Busco el número más alto
            for (int i = 1; i < copia.size(); i++) {
                if (copia.get(i) > max) {
                    max = copia.get(i);
                    pos = i;
                }
            }
            // Agrego el máximo a la nueva lista y lo quito de la copia
            ordenadas.add(max);
            copia.remove(pos);
        }
        return ordenadas;
    }
    
    //punto 5:
    public String nivelFinal() {
        int total = 0;
        for (int n : notas) {
            total += n;
        }
        
        if (total < 250) {
            return "Normie total";
        } else if (total < 350) {
            return "Soft Chad";
        } else if (total < 450) {
            return "Chad";
        } else {
            return "Stone Chad definitivo";
        }
    }
    
    //para el punto 6.1 de curso: calculo el promedio del alumno para calcular el mejor promedio del curso
    public double promedio() {
        int suma = 0;
        for (int n : notas) suma += n;
        return (double) suma / notas.size();
    }
    
    //para el punto 6.2 de curso: calculo diferencia entre la nota mas alta y la mas baja para ver la regularidad del alumno
    public int diferenciaMaxMin() {
        return Collections.max(notas) - Collections.min(notas);
    }
    
}
