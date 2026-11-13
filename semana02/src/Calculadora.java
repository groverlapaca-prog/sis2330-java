public class Calculadora {

    // Metodo con retorno double
    static double promedio(int[] valores) {
        int suma = 0;
        for (int v : valores) {
            suma += v;
        }
        return (double) suma / valores.length;
    }

    // Sobrecarga: mismo nombre, distintos parametros
    static double promedio(double a, double b) {
        return (a + b) / 2;
    }

    // Metodo void: no retorna nada
    static void imprimirLinea() {
        System.out.println("------------------");
    }

    public static void main(String[] args) {
        int[] notas = {80, 90, 70};
        System.out.println(promedio(notas));
        System.out.println(promedio(5.0, 7.0));
        imprimirLinea();
    }
}
