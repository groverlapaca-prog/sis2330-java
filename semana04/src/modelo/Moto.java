package modelo;

public class Moto extends Vehiculo {

    private int cilindrada;

    public Moto(String marca, String modelo,
                double velocidadMax, int cilindrada) {

        super(marca, modelo, velocidadMax);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    @Override
    public String describir() {
        return "Moto: " + marca +
                " " + modelo +
                ", Cilindrada: " + cilindrada + " cc" +
                ", Velocidad maxima: " + velocidadMax + " km/h";
    }
}
