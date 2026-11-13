import java.util.InputMismatchException;
import java.util.Scanner;

public class LectorDatos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nota = -1;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print("Ingrese nota (0-100): ");
                nota = sc.nextInt();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: debe ingresar un numero entero.");
                sc.next(); // descarta el token invalido
            }
        }

        sc.close();
    }
}
