package modelo;

public class AutoElectrico extends Auto implements Electrico {

    private int capacidadBateria;

    public AutoElectrico(String marca, String modelo,
                         double velocidadMax, int numPuertas,
                         int capacidadBateria) {

        super(marca, modelo, velocidadMax, numPuertas);
        this.capacidadBateria = capacidadBateria;
    }

    @Override
    public void cargarBateria() {
        System.out.println("Cargando bateria del auto electrico...");
        System.out.println("Capacidad: " + capacidadBateria + " kWh");
        System.out.println("Bateria cargada correctamente.");
    }

    @Override
    public String describir() {
        return "Auto Electrico: " + marca +
                " " + modelo +
                ", Puertas: " + getNumPuertas() +
                ", Bateria: " + capacidadBateria + " kWh" +
                ", Velocidad maxima: " + velocidadMax + " km/h";
    }
}
