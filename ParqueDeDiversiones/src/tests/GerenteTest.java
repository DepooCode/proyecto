package tests;  

import parque.Gerente;
import parque.EmpleadoNormal;
import parque.Turno;
import parque.LugarTrabajo;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GerenteTest {

    private Gerente gerente;
    private EmpleadoNormal empleado;
    private Turno turno;
    private LugarTrabajo lugarTrabajo;

    @BeforeEach
    public void setUp() {
        // Inicializar los objetos antes de cada prueba
        gerente = new Gerente("1", "Gerente Test");
        empleado = new EmpleadoNormal("1", "Empleado Test", "Normal", 5);
        lugarTrabajo = new LugarTrabajo("Atracción 1") {}; // Clase abstracta para el test
        turno = new Turno(new Date(), "Mañana", lugarTrabajo);

        // Agregar al gerente y empleado
        gerente.agregarEmpleado(empleado);
    }

    @Test
    public void testAsignarTurnoEmpleado() {
        // Asignar turno al empleado
        gerente.asignarTurno(empleado, turno);

        // Verificar que el turno fue asignado
        assertTrue(turno.isAsignado(), "El turno debe estar asignado.");
        assertEquals(1, empleado.getTurnosAsignados().size(), "El empleado debe tener un turno asignado.");
        assertEquals(turno, empleado.getTurnosAsignados().get(0), "El turno asignado debe coincidir.");
    }

    @Test
    public void testEliminarTurnoEmpleado() {
        // Asignar el turno primero
        gerente.asignarTurno(empleado, turno);

        // Eliminar el turno
        gerente.eliminarTurno(empleado, turno);

        // Verificar que el turno fue eliminado
        assertFalse(turno.isAsignado(), "El turno debe estar desasignado.");
        assertEquals(0, empleado.getTurnosAsignados().size(), "El empleado no debe tener turnos asignados.");
    }

    @Test
    public void testAsignarTurnoEmpleadoNoGestionado() {
        // Crear un empleado no gestionado
        EmpleadoNormal otroEmpleado = new EmpleadoNormal("2", "Otro Empleado", "Normal", 3);

        // Intentar asignar turno a un empleado no gestionado
        gerente.asignarTurno(otroEmpleado, turno);

        // Verificar que el turno no se asigna
        assertFalse(turno.isAsignado(), "El turno no debe ser asignado a un empleado no gestionado.");
    }

    
}





