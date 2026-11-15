package modelo;

public class Tarea {

    private static int contador = 1;

    private int id;
    private String descripcion;
    private boolean completada;

    // Constructor
    public Tarea(String descripcion) {
        this.id = contador++;
        this.descripcion = descripcion;
        this.completada = false;
    }

    // Getter del ID
    public int getId() {
        return id;
    }

    // Getter de descripcion
    public String getDescripcion() {
        return descripcion;
    }

    // Setter de descripcion
    public void setDescripcion(String descripcion) {
        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "La descripcion no puede estar vacia"
            );
        }

        this.descripcion = descripcion;
    }

    // Getter de completada
    public boolean isCompletada() {
        return completada;
    }

    // Marcar tarea completada
    public void marcarCompletada() {
        this.completada = true;
    }

    // Mostrar datos
    @Override
    public String toString() {

        String estado;

        if (completada) {
            estado = "Completada";
        } else {
            estado = "Pendiente";
        }

        return "ID: " + id +
               " | Descripcion: " + descripcion +
               " | Estado: " + estado;
    }
}
