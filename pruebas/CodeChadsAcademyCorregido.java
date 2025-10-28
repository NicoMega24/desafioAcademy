package ejercicios.desafio2.pruebas;

public class CodeChadsAcademyCorregido {
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

        // print para mostrar notas y chequear que funcione:
        System.out.println("\n Notas finales del estudiante:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Prueba " + (i+1) + ": " + notas[i]);
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
            // Math.abs(devuelve un valor absoluto de un numero, positivo o cero.
            // Se puede aplicar a datos numericos como int, double y float)

        int mayorVariacion = 0;
        int posicion = 0;
        for (int i = 0; i < 4; i++) {
            int variacion = Math.abs(notas[i+1] - notas[i]); // calcula la diferencia absoluta entre 2 pruebas consecutivas.
            if (variacion > mayorVariacion) { //si la diferencia actual es mayor que la maxima guardada
                mayorVariacion = variacion;   //
                posicion = i;                 //actualiza mayorVariacion y guarda i en posicion
            }
        }
        System.out.println("Mayor salto fue de " + mayorVariacion +
                           " puntos entre la prueba " + (posicion+1) +
                           " y la prueba " + (posicion+2) + ".");

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

        int[] ordenadas = notas.clone();
        for (int i = 0; i < ordenadas.length-1; i++) {
            for (int j = 0; j < ordenadas.length-1-i; j++) {
                if (ordenadas[j] < ordenadas[j+1]) {
                    int aux = ordenadas[j];
                    ordenadas[j] = ordenadas[j+1];
                    ordenadas[j+1] = aux;
                }
            }
        }
        System.out.print("Notas ordenadas: ");
        for (int n : ordenadas) {
            System.out.print(n + " ");
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
            System.out.println("Llegaste al rango: Stone Chad definitivo :)");
        } 


        //6. Ranking entre alumnos:

    }
}

