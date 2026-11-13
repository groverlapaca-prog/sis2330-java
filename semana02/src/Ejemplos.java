import java.util.Scanner;

public class Ejemplos{
   public static void main(String[] args){
    int edad =20;
   double promedio = 85.5;
   char inicial ='J';
   boolean aprobado = true;

   System.out.println("Edad: "+ edad);
   System.out.println("Promedio: "+ promedio);
   System.out.println("Aprobado: "+ aprobado);
   System.out.println("Inicial: "+ inicial);

System.out.println(7 / 2);
System.out.println(7.0 / 2);
System.out.println(7 / 2.0);
System.out.println((double) 7 / 2);
System.out.println(7 / 3);
System.out.println((double) 7 / 3);

int a = 17, b = 5;

System.out.println(a / b);
System.out.println(a % b);

boolean mayorDeEdad = a >= 18;
boolean tieneCedula = true;
boolean puedeVotar = mayorDeEdad && tieneCedula;
boolean esMenorOInvalido = !mayorDeEdad || !tieneCedula;

System.out.println("Puede votar: " + puedeVotar);
//estructura de control


int nota = 78;
String letra;

if (nota >= 90) {
    letra = "A";
} else if (nota >= 80) {
    letra = "B";
} else if (nota >= 70) {
    letra = "C";
} else {
    letra = "F";
}

System.out.println("Calificacion: " + letra);

//switch clasico
int dia = 3;

switch (dia) {
    case 1:
    case 7:
        System.out.println("Fin de semana");
        break;
    default:
        System.out.println("Dia habil");
}
String nombre = switch (dia) {
    case 1 -> "Lunes";
    case 2 -> "Martes";
    case 3 -> "Miercoles";
    default -> "Otro dia";
};

System.out.println(nombre);

// repeticiones for while do-while

for (int i = 1; i <= 5; i++) {
    System.out.println("Iteracion " + i);
}
int intentos = 0;

while (intentos < 3) {
    intentos++;
}

int opcion;
Scanner sc = new Scanner(System.in);

do {
    System.out.print("Ingrese 0 para salir: ");
    opcion = sc.nextInt();
} while (opcion != 0);

//Arrays
// Declaracion e inicializacion
int[] notas = {85, 90, 78, 92, 88};

// Recorrido clasico
for (int i = 0; i < notas.length; i++) {
    System.out.println("Nota " + i + ": " + notas[i]);
}

// Recorrido for-each (no da el indice)
for (int n : notas) {
    System.out.println(n);
}

// Array 2D: 5 estudiantes x 3 notas
double[][] calificaciones = new double[5][3];

calificaciones[0][0] = 8.5;

for (int i = 0; i < calificaciones.length; i++) {
    for (int j = 0; j < calificaciones[i].length; j++) {
        System.out.print(calificaciones[i][j] + " ");
    }
    System.out.println();
}


   }
}
