package app;

import modelo.*;
import java.util.ArrayList;

public class GestionVehiculos {

    public static void main(String[] args) {

        ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        // Crear los vehiculos
        Auto auto = new Auto(
                "Toyota", "Corolla", 180, 4);

        Moto moto = new Moto(
                "Yamaha", "FZ", 150, 150);

        Camion camion = new Camion(
                "Volvo", "FH", 120, 20);

        AutoElectrico electrico = new AutoElectrico(
                "Tesla", "Model 3", 225, 4, 75);

        // Agregar a la lista
        vehiculos.add(auto);
        vehiculos.add(moto);
        vehiculos.add(camion);
        vehiculos.add(electrico);

        // Recorrido polimorfico
        System.out.println("================================");
        System.out.println("     GESTION DE VEHICULOS");
        System.out.println("================================");

        for (Vehiculo v : vehiculos) {

            System.out.println(v.describir());

            // Verificar si es electrico
            if (v instanceof Electrico) {

                Electrico e = (Electrico) v;

                e.cargarBateria();
            }

            System.out.println("--------------------------------");
        }

        System.out.println("Total de vehiculos: " + vehiculos.size());

    }
}
