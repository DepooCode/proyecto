package tests;
import parque.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class GerenteTest {

    private Gerente gerente;
    private EmpleadoNormal empleado;
    private Atraccion atraccion;
    private Espectaculo espectaculo;
    private Turno turno;

    @BeforeEach
    public void setUp() {
        gerente = new Gerente("G1", "Laura", "gerente", "1234");
        empleado = new EmpleadoNormal("E1", "Juan", "Operador", 2, "empleadoNormal", "1234");
        atraccion = new Cultural("Museo", "General", "Zona A", 30, 2, new ArrayList<>(), false, 10);
        espectaculo = new Espectaculo("Show Mágico", java.time.LocalTime.of(15, 0), new Date(), new ArrayList<>(), false);
        turno = new Turno(new Date(), "Mañana", new LugarTrabajo("Zona A") {});
        
        gerente.iniciarSesion("gerente", "1234");
    }

    @Test
    public void testAgregarEmpleado() {
        gerente.agregarEmpleado(empleado);
        assertTrue(gerente.getListaEmpleadosGest().contains(empleado));
    }

    @Test
    public void testEliminarEmpleadoExistente() {
        gerente.agregarEmpleado(empleado);
        gerente.eliminarEmpleado(empleado);
        assertFalse(gerente.getListaEmpleadosGest().contains(empleado));
    }

    @Test
    public void testAsignarTurno() {
        gerente.agregarEmpleado(empleado);
        gerente.asignarTurno(empleado, turno);
        assertTrue(empleado.getTurnosAsignados().contains(turno));
        assertTrue(turno.isAsignado());
    }

    @Test
    public void testEliminarTurno() {
        gerente.agregarEmpleado(empleado);
        gerente.asignarTurno(empleado, turno);
        gerente.eliminarTurno(empleado, turno);
        assertFalse(empleado.getTurnosAsignados().contains(turno));
        assertFalse(turno.isAsignado());
    }

    @Test
    public void testAgregarAtraccion() {
        gerente.agregarAtraccion(atraccion);
        assertTrue(gerente.getListaAtraccionesGest().contains(atraccion));
    }

    @Test
    public void testEliminarAtraccion() {
        gerente.agregarAtraccion(atraccion);
        gerente.eliminarAtraccion(atraccion);
        assertFalse(gerente.getListaAtraccionesGest().contains(atraccion));
    }

    @Test
    public void testAgregarEspectaculo() {
        gerente.agregarEspectaculo(espectaculo);
        assertTrue(gerente.getListaEspectaculosGest().contains(espectaculo));
    }

    @Test
    public void testEliminarEspectaculo() {
        gerente.agregarEspectaculo(espectaculo);
        gerente.eliminarEspectaculo(espectaculo);
        assertFalse(gerente.getListaEspectaculosGest().contains(espectaculo));
    }

    @Test
    public void testGetEmpleadoExistente() {
        gerente.agregarEmpleado(empleado);
        assertEquals(empleado, gerente.getEmpleado(empleado));
    }

    @Test
    public void testGetEmpleadoNoExistente() {
        assertNull(gerente.getEmpleado(empleado));
    }
    @Test
    public void testAgregarEmpleadoSinIniciarSesion() {
    gerente.cerrarSesion();

    gerente.agregarEmpleado(empleado);

    assertFalse(gerente.getListaEmpleadosGest().contains(empleado));
}
    @Test
    public void testGestionarAtraccionConCambioDeNombre() {
    String input = "1\nNueva Rueda\n"; // Opción 1 para cambiar el nombre, "Nueva Rueda" es el nuevo nombre
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    gerente.gestionarAtraccion(atraccion);

    assertEquals("Nueva Rueda", atraccion.getNombre());

    }
    @Test
    public void testGestionarEspectaculoConCambioDeNombre() {
        String input = "1\nNuevo Show Mágico\n"; // Opción 1 para cambiar el nombre, seguido de "Nuevo Show Mágico"
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        gerente.gestionarEspectaculo(espectaculo);

        assertEquals("Nuevo Show Mágico", espectaculo.getNombre());
    }
}





