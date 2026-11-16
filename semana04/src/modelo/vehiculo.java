package modelo;

public abstract class Vehiculo {

    protected String marca;
    protected String modelo;
    protected double velocidadMax;

    public Vehiculo(String marca, String modelo, double velocidadMax) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidadMax = velocidadMax;
    }

    public abstract String describir();

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double getVelocidadMax() {
        return velocidadMax;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", velocidadMax=" + velocidadMax +
                '}';
    }
}
