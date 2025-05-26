import parque.*;
import persistencia.GestorPersistencia;

import java.util.*;

public class CargadorInicialDeDatos {
    public static void main(String[] args) {
        GestorPersistencia gestor = GestorPersistencia.getInstance();

        // ---------- Clientes ----------
        Cliente cliente1 = new Cliente("juan123", "1234", true);
        Cliente cliente2 = new Cliente("lina456", "abcd", false);

        // ---------- Atracciones ----------
        Cultural cultural1 = new Cultural("MuseoTerror", "ORO", "Zona A", 30, 2, List.of("lluvia"), false, 12);
        Mecanica mecanica1 = new Mecanica("MontañaRusa", "DIAMANTE", "Zona B", 20, 4, false,
                List.of("viento"), 1.5f, 2.0f, 40, 100, List.of("cardíacos"), "ALTO");

        // ---------- Empleados ----------
        EmpleadoNormal emp1 = new EmpleadoNormal("E01", "Carlos", "Operador", 2, "carlos01", "pass");
        Gerente gerente1 = new Gerente("G01", "Laura", "lauraAdmin", "admin123");

        // ---------- Tiquetes ----------
        TiqueteGeneral tiquete1 = new TiqueteGeneral("TG001", CategoriaTiquete.FAMILIAR, false, new Date());
        TiqueteTemporada tiquete2 = new TiqueteTemporada("TT002", CategoriaTiquete.DIAMANTE, true, new Date(),
                new GregorianCalendar(2024, Calendar.DECEMBER, 31).getTime());

        // ---------- Guardar todo ----------
        gestor.guardarEntidad(cliente1);
        gestor.guardarEntidad(cliente2);
        gestor.guardarEntidad(cultural1);
        gestor.guardarEntidad(mecanica1);
        gestor.guardarEntidad(emp1);
        gestor.guardarEntidad(gerente1);
        gestor.guardarEntidad(tiquete1);
        gestor.guardarEntidad(tiquete2);

        System.out.println("Datos de prueba guardados con éxito.");
    }
}
