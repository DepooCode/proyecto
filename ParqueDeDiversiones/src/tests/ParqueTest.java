package tests;

import parque.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class ParqueTest {

    @Test
    public void testAgregarYEliminarEmpleado() {
        Parque parque = new Parque();
        EmpleadoNormal empleado1 = new EmpleadoNormal("1", "Juan", "Cajero", 2);
        EmpleadoNormal empleado2 = new EmpleadoNormal("2", "Maria", "Operador", 3);

        parque.agregarEmpleado(empleado1);
        parque.agregarEmpleado(empleado2);

        assertEquals(2, parque.getListaEmpleados().size());

        parque.eliminarEmpleado(empleado1);
        assertEquals(1, parque.getListaEmpleados().size());
        assertTrue(parque.getListaEmpleados().contains(empleado2));
    }

    @Test
    public void testAgregarYEliminarAtraccion() {
        Parque parque = new Parque();
        List<String> restriccionesClima = new ArrayList<>();
        restriccionesClima.add("Lluvia");
        
        Atraccion atraccion1 = new Mecanica("Montaña Rusa", "Exclusiva", "Zona A", 100, 2, false, restriccionesClima, 1.5f, 2.0f, 40f, 100f, null, "Alto");
        Atraccion atraccion2 = new Cultural("Museo del Futuro", "General", "Zona B", 50, 1, restriccionesClima, true, 10);

        parque.agregarAtraccion(atraccion1);
        parque.agregarAtraccion(atraccion2);

        assertEquals(2, parque.getListaAtracciones().size());

        parque.eliminarAtraccion(atraccion1);
        assertEquals(1, parque.getListaAtracciones().size());
        assertTrue(parque.getListaAtracciones().contains(atraccion2));
    }

    @Test
    public void testAgregarYEliminarEspectaculo() {
        Parque parque = new Parque();
        Espectaculo espectaculo1 = new Espectaculo("Circo Acrobático", null, null, null, false);
        Espectaculo espectaculo2 = new Espectaculo("Concierto Rock", null, null, null, true);

        parque.agregarEspectaculo(espectaculo1);
        parque.agregarEspectaculo(espectaculo2);

        assertEquals(2, parque.getListaEspectaculos().size());

        parque.eliminarEspectaculo(espectaculo1);
        assertEquals(1, parque.getListaEspectaculos().size());
        assertTrue(parque.getListaEspectaculos().contains(espectaculo2));
    }

    @Test
    public void testAgregarYEliminarCliente() {
        Parque parque = new Parque();
        Cliente cliente1 = new Cliente("jose", "1234", true);
        Cliente cliente2 = new Cliente("ana", "abcd", false);

        parque.agregarCliente(cliente1);
        parque.agregarCliente(cliente2);

        assertEquals(2, parque.getListaClientes().size());

        parque.eliminarCliente(cliente1);
        assertEquals(1, parque.getListaClientes().size());
        assertTrue(parque.getListaClientes().contains(cliente2));
    }
}
