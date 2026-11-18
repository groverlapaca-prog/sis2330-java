package servicio;

import modelo.Estudiante;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SistemaEstudiantesTest {

    private SistemaEstudiantes sistema;

    @BeforeEach
    void setUp() {
        sistema = new SistemaEstudiantes();
    }

    @Test
    void registrarEstudianteNuevoDevuelveTrue() {
        assertTrue(sistema.registrar(
            new Estudiante("E1", "Ana", 90.0)
        ));
    }

    @Test
    void registrarCodigoDuplicadoDevuelveFalse() {
        sistema.registrar(
            new Estudiante("E1", "Ana", 90.0)
        );

        boolean segundo = sistema.registrar(
            new Estudiante("E1", "Otro", 50.0)
        );

        assertFalse(segundo);
    }

    @Test
    void buscarPorCodigoExistenteDevuelveEstudiante() {
        sistema.registrar(
            new Estudiante("E1", "Ana", 90.0)
        );

        assertNotNull(sistema.buscarPorCodigo("E1"));
    }

    @Test
    void buscarPorCodigoInexistenteDevuelveNull() {
        assertNull(sistema.buscarPorCodigo("NOEXISTE"));
    }

    @Test
    void actualizarPromedioExistenteDevuelveTrue() {
        sistema.registrar(
            new Estudiante("E1", "Ana", 70.0)
        );

        assertTrue(
            sistema.actualizarPromedio("E1", 95.0)
        );

        assertEquals(
            95.0,
            sistema.buscarPorCodigo("E1").getPromedio()
        );
    }

    @Test
    void actualizarPromedioInexistenteDevuelveFalse() {
        assertFalse(
            sistema.actualizarPromedio("NOEXISTE", 80.0)
        );
    }

    @Test
    void eliminarEstudianteExistenteDevuelveTrue() {
        sistema.registrar(
            new Estudiante("E1", "Ana", 90.0)
        );

        assertTrue(sistema.eliminar("E1"));
        assertNull(sistema.buscarPorCodigo("E1"));
        assertEquals(0, sistema.listarRanking().size());
    }

    @Test
    void listarRankingVacioDevuelveListaVacia() {
        ArrayList<Estudiante> ranking =
            sistema.listarRanking();

        assertTrue(ranking.isEmpty());
    }

    @Test
    void listarRankingOrdenaPorPromedioDescendente() {
        sistema.registrar(
            new Estudiante("E1", "Ana", 70.0)
        );

        sistema.registrar(
            new Estudiante("E2", "Luis", 95.0)
        );

        sistema.registrar(
            new Estudiante("E3", "Zoe", 80.0)
        );

        ArrayList<Estudiante> ranking =
            sistema.listarRanking();

        assertEquals("E2", ranking.get(0).getCodigo());
        assertEquals("E3", ranking.get(1).getCodigo());
        assertEquals("E1", ranking.get(2).getCodigo());
    }

    @Test
    void topNMayorAlTotalDevuelveTodos() {
        sistema.registrar(
            new Estudiante("E1", "Ana", 70.0)
        );

        sistema.registrar(
            new Estudiante("E2", "Luis", 95.0)
        );

        ArrayList<Estudiante> top = sistema.topN(10);

        assertEquals(2, top.size());
    }

    @Test
    void eliminarEstudianteInexistenteDevuelveFalse() {
        assertFalse(sistema.eliminar("NOEXISTE"));
    }

    @Test
    void cantidadDevuelveNumeroDeEstudiantes() {
        sistema.registrar(
            new Estudiante("E1", "Ana", 70.0)
        );

        sistema.registrar(
            new Estudiante("E2", "Luis", 95.0)
        );

        assertEquals(2, sistema.cantidad());
    }
}
