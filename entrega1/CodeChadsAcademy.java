package ejercicios.desafio2.entrega1;

public class CodeChadsAcademy {
    public static void main(String[] args) {
       
        // PRIMERA PARTE
        // primeras 3 notas le doy un valor especifico
        int[] notas = new int[5];

        notas[0] = 80;
        notas[1] = 55;  
        notas[2] = 90; 

        // calculo nota 4: si es menor a 60 la nota 4 es igual a 100.
        //                 si es mayor a 60 la nota 4 es igual a nota nro 2 (55)
        if (notas[1] < 60) {
            notas[3] = 100;
        } else {
            notas[3] = notas[1];
        }

        // calculo nota 5: si nota 1 y 3 es mayor a 150 la nota 5 sera de 95
        //                 si nota 1 y 3 es menor a 150 la nota 5 sera de 70   
        if (notas[0] + notas[2] > 150) {
            notas[4] = 95;
        } else {
            notas[4] = 70;
        }


        // SEGUNDA PARTE

        // 1. Verificar si aprobó todas:
        // con for recorro las 5 notas siendo aprobadas las mayores o iguales a 60
        int aprobadas = 0;
        for (int i = 0; i < 5; i++) {
            if (notas[i] >= 60) {
                aprobadas++;
            }
        }
        // if: si las 5 estan aprobadas
        // else if: si niguna esta aprobada
        // else: algunas estan aprobadas
        if (aprobadas == 5) {
            System.out.println("Resultado: Aprobaste todas. ¡Backend Sensei!");
        } else if (aprobadas == 0) {
            System.out.println("Resultado: No aprobaste ninguna. ¡Sos un clon de frontend!");
        } else {
            System.out.println("Resultado: Algunas aprobadas. Sos un refactor en progreso.");
        }

        // 2. Prueba más inconsistente:

        int mayorVariacion = 0;
        int p1 = 1, p2 = 2;

        if (Math.abs(notas[1] - notas[0]) > mayorVariacion) {
            mayorVariacion = Math.abs(notas[1] - notas[0]);
            p1 = 1; p2 = 2;
        }
        if (Math.abs(notas[2] - notas[1]) > mayorVariacion) {
            mayorVariacion = Math.abs(notas[2] - notas[1]);
            p1 = 2; p2 = 3;
        }
        if (Math.abs(notas[3] - notas[2]) > mayorVariacion) {
            mayorVariacion = Math.abs(notas[3] - notas[2]);
            p1 = 3; p2 = 4;
        }
        if (Math.abs(notas[4] - notas[3]) > mayorVariacion) {
            mayorVariacion = Math.abs(notas[4] - notas[3]);
            p1 = 4; p2 = 5;
        }

        System.out.println("Mayor salto fue de " + mayorVariacion +
                           " puntos entre la prueba " + p1 + " y la prueba " + p2 + ".");

        // Math.abs(devuelve un valor absoluto de un numero, positivo o cero.
        // Se puede aplicar a datos numericos como int, double y float)


        // 3. Bonus por progreso:
        boolean progresivo = true;
        for (int i = 0; i < 4; i++) {
            if (notas[i+1] <= notas[i]) {
                progresivo = false;
                // puedo agregar un comentario en caso de que no sea progresivo el nivel
                // System.out.println("Progreso: Tienes altos y bajos, puedes mejorar.");
                break;
            }
        }
        if (progresivo) {
            System.out.println("Progreso: ¡Nivel PROGRESIVO! Sos un Stone Chad en crecimiento 📈");
        }

        // 4. Mostrar notas ordenadas (mayor a menor)
        System.out.println("Notas ordenadas de mayor a menor:");
        int[] copia = {notas[0], notas[1], notas[2], notas[3], notas[4]};

        for (int i = 0; i < copia.length; i++) {
            int max = -1;
            int pos = -1;

            for (int j = 0; j < copia.length; j++) {
                if (copia[j] > max) {
                    max = copia[j];
                    pos = j;
                }
            }

            System.out.print(max + " ");
            copia[pos] = -1; // separa el mas alto para continuar con el siguiente mas alto.
        }
        System.out.println();


        // 5. Evaluación final por nivel
        int total = 0;
        for (int n : notas) {
            total += n;
        }

        if (total < 250) {
            System.out.println("Llegaste al rango: Normie total :(");
        } else if (total < 350) {
            System.out.println("Llegaste al rango: Soft Chad");
        } else if (total < 450) {
            System.out.println("Llegaste al rango: Chad");
        } else {
            System.out.println("Llegaste al rango: Stone Chad definitivo ;)");
        } 


        //6. Ranking entre alumnos:
        System.out.println("\n ****  Ranking de mejores promedios  ****");

        int [][] curso = {
            {80, 55, 90, 100, 95}, //alumno 1
            {70, 60, 65, 60, 70}, //alumno 2
            {100, 95, 98, 100, 97}, //alumno 3
            {40, 50, 45, 50, 55}, // alumno 4
        };
        
            // 1. Mejor promedio
        double mejorPromedio = 0;
        int mejorAlumno = -1;
        for (int i = 0; i < curso.length; i++) {
            int suma = 0;
            for (int j = 0; j < curso[i].length; j++) {
                suma += curso[i][j];
            }
            double promedio = (double) suma / curso[i].length;
            if (promedio > mejorPromedio) {
                mejorPromedio = promedio;
                mejorAlumno = i + 1;
            }
        }
        System.out.println("Alumno con mejor promedio: Alumno " + mejorAlumno +
                           " con promedio " + mejorPromedio);

       
            // 2. Más regular (menor diferencia entre max y min)
        int masRegular = -1;
        int menorDiferencia = Integer.MAX_VALUE;
        for (int i = 0; i < curso.length; i++) {
            int max = curso[i][0];
            int min = curso[i][0];
            for (int j = 1; j < curso[i].length; j++) {
                if (curso[i][j] > max) max = curso[i][j];
                if (curso[i][j] < min) min = curso[i][j];
            }
            int diferencia = max - min;
            if (diferencia < menorDiferencia) {
                menorDiferencia = diferencia;
                masRegular = i + 1;
            }
        }
        System.out.println("Alumno más regular: Alumno " + masRegular +
                           " con diferencia de " + menorDiferencia);


        // 3. Peor en la tercera prueba
        int peorAlumno = -1;
        int peorNota = 101;
        for (int i = 0; i < curso.length; i++) {
            int nota = curso[i][2]; // tercera prueba
            if (nota < peorNota) {
                peorNota = nota;
                peorAlumno = i + 1;
            }
        }
        System.out.println("Peor rendimiento en la tercera prueba: Alumno " + peorAlumno +
                           " con " + peorNota + " puntos");
    }    
}
