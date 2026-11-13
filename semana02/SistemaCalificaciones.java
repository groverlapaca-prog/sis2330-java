import java.util.InputMismatchException;
import java.util.Scanner;

public class SistemaCalificaciones {

    static double promedio(double[] notas) {
        double suma = 0;
        for (int i = 0; i < notas.length; i++) {
            suma += notas[i];
        }
        return suma / notas.length;
    }

    static double maximo(double[] notas) {
        double mayor = notas[0];
        for (int i = 1; i < notas.length; i++) {
            if (notas[i] > mayor) {
                mayor = notas[i];
            }
        }
        return mayor;
    }

    static double minimo(double[] notas) {
        double menor = notas[0];
        for (int i = 1; i < notas.length; i++) {
            if (notas[i] < menor) {
                menor = notas[i];
            }
        }
        return menor;
    }

    static String estado(double prom) {
        if (prom >= 51) {
            return "Aprobado";
        } else {
            return "Reprobado";
        }
    }

    static double leerNota(Scanner sc, String mensaje) {
        double nota = -1;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print(mensaje);
                nota = sc.nextDouble();

                if (nota < 0 || nota > 100) {
                    System.out.println("Error: la nota debe estar entre 0 y 100.");
                } else {
                    valido = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: ingrese un numero valido.");
                sc.next();
            }
        }
        return nota;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nombres = new String[5];
        double[][] notas = new double[5][3];

        System.out.println("SISTEMA DE CALIFICACIONES");
        System.out.println("-------------------------");

        for (int i = 0; i < nombres.length; i++) {
            System.out.print("\nIngrese el nombre del estudiante " + (i + 1) + ": ");
            nombres[i] = sc.next();

            for (int j = 0; j < notas[i].length; j++) {
                notas[i][j] = leerNota(sc, "Ingrese la nota " + (j + 1) + ": ");
            }
        }

        System.out.println("\nREPORTE FINAL");
        System.out.println("----------------------------------------------------------------");
        System.out.printf("%-18s %10s %10s %10s %12s%n",
                "Estudiante", "Promedio", "Maximo", "Minimo", "Estado");
        System.out.println("----------------------------------------------------------------");

        for (int i = 0; i < nombres.length; i++) {
            double prom = promedio(notas[i]);
            double mayor = maximo(notas[i]);
            double menor = minimo(notas[i]);

            System.out.printf("%-18s %10.2f %10.2f %10.2f %12s%n",
                    nombres[i], prom, mayor, menor, estado(prom));
        }

        sc.close();
    }
}
