import servicio.SistemaEstudiantes;
import modelo.Estudiante;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        SistemaEstudiantes sistema = new SistemaEstudiantes();
        Scanner sc = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("\n===== SISTEMA DE ESTUDIANTES =====");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Buscar estudiante");
            System.out.println("3. Actualizar promedio");
            System.out.println("4. Mostrar ranking");
            System.out.println("5. Mostrar Top N");
            System.out.println("6. Eliminar estudiante");
            System.out.println("7. Salir");

            System.out.print("Seleccione una opcion: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {

                case 1:
                    System.out.print("Codigo: ");
                    String cod = sc.nextLine();

                    System.out.print("Nombre: ");
                    String nom = sc.nextLine();

                    System.out.print("Promedio: ");
                    double prom = Double.parseDouble(sc.nextLine());

                    Estudiante nuevo =
                        new Estudiante(cod, nom, prom);

                    if (sistema.registrar(nuevo)) {
                        System.out.println("Estudiante registrado correctamente.");
                    } else {
                        System.out.println("No se pudo registrar. Verifique el codigo o promedio.");
                    }
                    break;

                case 2:
                    System.out.print("Ingrese codigo: ");
                    String buscar = sc.nextLine();

                    Estudiante encontrado =
                        sistema.buscarPorCodigo(buscar);

                    if (encontrado != null) {
                        System.out.println(encontrado);
                    } else {
                        System.out.println("Estudiante no encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Codigo del estudiante: ");
                    String c2 = sc.nextLine();

                    System.out.print("Nuevo promedio: ");
                    double np = Double.parseDouble(sc.nextLine());

                    if (sistema.actualizarPromedio(c2, np)) {
                        System.out.println("Promedio actualizado.");
                    } else {
                        System.out.println("No se pudo actualizar.");
                    }
                    break;

                case 4:
                    System.out.println("\n===== RANKING COMPLETO =====");

                    for (Estudiante e : sistema.listarRanking()) {
                        System.out.println(e);
                    }
                    break;

                case 5:
                    System.out.print("Cantidad de estudiantes: ");
                    int n = Integer.parseInt(sc.nextLine());

                    System.out.println("\n===== TOP " + n + " =====");

                    for (Estudiante e : sistema.topN(n)) {
                        System.out.println(e);
                    }
                    break;

                case 6:
                    System.out.print("Codigo a eliminar: ");
                    String eliminar = sc.nextLine();

                    if (sistema.eliminar(eliminar)) {
                        System.out.println("Estudiante eliminado.");
                    } else {
                        System.out.println("Estudiante no encontrado.");
                    }
                    break;

                case 7:
                    System.out.println("Gracias por utilizar el sistema.");
                    break;

                default:
                    System.out.println("Opcion incorrecta.");
            }

        } while (opcion != 7);

        sc.close();
    }
}
