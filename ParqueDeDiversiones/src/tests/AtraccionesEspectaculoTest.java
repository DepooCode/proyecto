package tests;
import parque.*;


import org.junit.jupiter.api.Test;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AtraccionesEspectaculoTest {

    @Test
    public void testCreacionYModificacionCultural() {
        List<String> clima = List.of("Lluvia");
        Cultural cultural = new Cultural("Museo Magia", "BASICO", "Zona A", 30, 2, clima, false, 7);

        assertEquals("Museo Magia", cultural.getNombre());
        assertEquals("Zona A", cultural.getUbicacion());
        assertEquals(30, cultural.getCupoMaximo());
        assertEquals(7, cultural.getMinEdad());

        // Modificación
        cultural.setCupoMaximo(50);
        cultural.setUbicacion("Zona B");

        assertEquals(50, cultural.getCupoMaximo());
        assertEquals("Zona B", cultural.getUbicacion());
    }

    @Test
    public void testCreacionYModificacionMecanica() {
        List<String> clima = List.of("Tormenta");
        List<String> salud = List.of("Cardiopatías");

        Mecanica mecanica = new Mecanica("Montaña Rusa", "ORO", "Zona D", 20, 3, true, clima,
                1.20f, 2.00f, 40f, 120f, salud, "Alto");

        assertEquals("Montaña Rusa", mecanica.getNombre());
        assertEquals("Zona D", mecanica.getUbicacion());
        assertEquals("Alto", mecanica.getNivelRiesgo());
        assertTrue(mecanica.isDeTemporada());

        // Modificación
        mecanica.setNivelRiesgo("Moderado");
        mecanica.setUbicacion("Zona C");

        assertEquals("Moderado", mecanica.getNivelRiesgo());
        assertEquals("Zona C", mecanica.getUbicacion());
    }

    @Test
    public void testCreacionYProgramacionEspectaculo() {
        List<String> clima = List.of("Niebla");
        LocalTime hora = LocalTime.of(18, 30);
        Date fecha = new Date();

        Espectaculo show = new Espectaculo("Show de Magia", hora, fecha, clima, true);

        assertEquals("Show de Magia", show.getNombre());
        assertEquals(hora, show.getHorario());
        assertEquals(fecha, show.getFecha());
        assertTrue(show.isDeTemporada());

        // Reprogramación
        LocalTime nuevaHora = LocalTime.of(20, 0);
        Date nuevaFecha = new Date(System.currentTimeMillis() + 86400000); // +1 día
        show.setHorario(nuevaHora);
        show.setFecha(nuevaFecha);

        assertEquals(nuevaHora, show.getHorario());
        assertEquals(nuevaFecha, show.getFecha());
    }
}

