package ejercicios.desafio2.entrega2;

import java.util.Arrays;

public class CodeChadsAcademy {
     public static void main(String[] args) {

        Alumno a1 = new Alumno(" Ariel ", Arrays.asList(80, 55, 90, 100, 95));
        Alumno a2 = new Alumno(" Pedro ", Arrays.asList(70, 60, 65, 60, 70));
        Alumno a3 = new Alumno(" Talía ", Arrays.asList(100, 95, 98, 100, 97));
        Alumno a4 = new Alumno(" Sofía ", Arrays.asList(40, 50, 45, 50, 55));

        Curso curso = new Curso(Arrays.asList(a1, a2, a3, a4));

        System.out.println("\n=== CHEQUEO INDIVIDUAL ===\n"); 
        for (Alumno a : curso.getAlumnos()) {                                         
            System.out.println("  Alumno: " + a.getNombre().trim());
            System.out.println("  Resultado: " + a.resultadoAprobacion());
            System.out.println("  Diferencia máxima entre 2 notas: " + a.mayorVariacion() + " puntos");
            System.out.println("  Progresivo: " + (a.esProgresivo() ? "Sí" : "No"));
            System.out.println("  Notas ordenadas (desc): " + a.notasOrdenadasDescendente());
            System.out.println("  Nivel final: " + a.nivelFinal());
            System.out.println("  Promedio: " + a.promedio());
            System.out.println("──────────────────────────────────────────────");
        }

        System.out.println("=== RANKING DE CODECHADS ACADEMY ===");
        System.out.println("Mejor promedio:" + curso.mejorPromedio().getNombre());
        System.out.println("Más regular:" + curso.masRegular().getNombre());
        System.out.println("Peor en tercera prueba:" + curso.peorEnTerceraPrueba().getNombre());
        
    }
}

