package app;

import modelo.Tarea;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GestorTareas {

    private static ArrayList<Tarea> tareas = new ArrayList<>();

    // Agregar tarea
    private static void agregar(String descripcion) {

        if (descripcion == null || descripcion.trim().isEmpty()) {
            System.out.println("La descripcion no puede estar vacia.");
            return;
        }

        tareas.add(new Tarea(descripcion));

        System.out.println("Tarea agregada correctamente.");
    }

    // Listar tareas
    private static void listar() {

        if (tareas.isEmpty()) {
            System.out.println("No hay tareas registradas.");
            return;
        }

        System.out.println("\n===== LISTA DE TAREAS =====");

        for (Tarea t : tareas) {
            System.out.println(t);
        }
    }

    // Completar tarea por ID
    private static void completar(int id) {

        for (Tarea t : tareas) {

            if (t.getId() == id) {

                t.marcarCompletada();

                System.out.println(
                    "Tarea " + id + " marcada como completada."
                );

                return;
            }
        }

        System.out.println("No existe una tarea con ID " + id);
    }

    // Eliminar tarea por ID
    private static void eliminar(int id) {

        boolean eliminado = tareas.removeIf(
            t -> t.getId() == id
        );

        if (eliminado) {
            System.out.println("Tarea eliminada correctamente.");
        } else {
            System.out.println("No existe una tarea con ID " + id);
        }
    }

    // Leer numeros evitando errores
    private static int leerEntero(Scanner sc, String mensaje) {

        while (true) {

            System.out.print(mensaje);

            try {

                int numero = sc.nextInt();
                sc.nextLine();

                return numero;

            } catch (InputMismatchException e) {

                System.out.println("Ingrese un numero valido.");
                sc.nextLine();
            }
        }
    }

    // Metodo principal
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcion = 0;

        do {

            System.out.println("\n===== GESTOR DE TAREAS =====");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Listar tareas");
            System.out.println("3. Completar tarea");
            System.out.println("4. Eliminar tarea");
            System.out.println("5. Salir");

            opcion = leerEntero(sc, "Seleccione una opcion: ");

            switch (opcion) {

                case 1:

                    System.out.print("Ingrese la descripcion: ");
                    String descripcion = sc.nextLine();

                    agregar(descripcion);

                    break;

                case 2:

                    listar();

                    break;

                case 3:

                    int idCompletar = leerEntero(
                        sc, "Ingrese el ID a completar: "
                    );

                    completar(idCompletar);

                    break;

                case 4:

                    int idEliminar = leerEntero(
                        sc, "Ingrese el ID a eliminar: "
                    );

                    eliminar(idEliminar);

                    break;

                case 5:

                    System.out.println("Saliendo del programa...");

                    break;

                default:

                    System.out.println("Opcion invalida.");

                    break;
            }

        } while (opcion != 5);

        sc.close();
    }
}
