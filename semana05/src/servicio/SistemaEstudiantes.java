package servicio;

import modelo.Estudiante;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.ArrayList;

public class SistemaEstudiantes {

    private HashMap<String, Estudiante> porCodigo;
    private TreeSet<Estudiante> ranking;

    public SistemaEstudiantes() {
        porCodigo = new HashMap<>();
        ranking = new TreeSet<>();
    }

    // Registrar estudiante
    public boolean registrar(Estudiante e) {

        if (e == null || e.getPromedio() < 0 ||
            e.getPromedio() > 100) {
            return false;
        }

        if (porCodigo.containsKey(e.getCodigo())) {
            return false;
        }

        porCodigo.put(e.getCodigo(), e);
        ranking.add(e);

        return true;
    }

    // Buscar por codigo
    public Estudiante buscarPorCodigo(String codigo) {
        return porCodigo.get(codigo);
    }

    // Actualizar promedio
    public boolean actualizarPromedio(
        String codigo, double nuevoPromedio) {

        if (nuevoPromedio < 0 || nuevoPromedio > 100) {
            return false;
        }

        Estudiante e = porCodigo.get(codigo);

        if (e == null) {
            return false;
        }

        ranking.remove(e);

        e.setPromedio(nuevoPromedio);

        ranking.add(e);

        return true;
    }

    // Mostrar ranking
    public ArrayList<Estudiante> listarRanking() {
        return new ArrayList<>(ranking);
    }

    // Obtener los mejores N estudiantes
    public ArrayList<Estudiante> topN(int n) {

        ArrayList<Estudiante> top = new ArrayList<>();

        if (n <= 0) {
            return top;
        }

        int i = 0;

        for (Estudiante e : ranking) {

            if (i >= n) {
                break;
            }

            top.add(e);
            i++;
        }

        return top;
    }

    // Eliminar estudiante
    public boolean eliminar(String codigo) {

        Estudiante e = porCodigo.remove(codigo);

        if (e == null) {
            return false;
        }

        ranking.remove(e);

        return true;
    }
}
