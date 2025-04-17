package tests;
import parque.*;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TiqueteTest {

    @Test
    public void testCrearTiqueteGeneral() {
        Date fechaFastPass = new Date();
        TiqueteGeneral tiquete = new TiqueteGeneral("TG001", CategoriaTiquete.BASICO, true, fechaFastPass);

        assertEquals("TG001", tiquete.getId());
        assertEquals("BASICO", tiquete.getCategoria());
        assertTrue(tiquete.isFastPass());
        assertEquals(fechaFastPass, tiquete.getFechaFastPass());
        assertFalse(tiquete.isUtilizado());
    }

    @Test
    public void testCrearTiqueteTemporada() {
        Date fechaFastPass = new Date();
        Date fechaFin = new Date(System.currentTimeMillis() + 1000000000L); // futuro

        TiqueteTemporada tiquete = new TiqueteTemporada("TT001", CategoriaTiquete.DIAMANTE, false, fechaFastPass, fechaFin);

        assertEquals("TT001", tiquete.getId());
        assertEquals("DIAMANTE", tiquete.getCategoria());
        assertFalse(tiquete.isFastPass());
        assertEquals(fechaFastPass, tiquete.getFechaFastPass());
        assertEquals(fechaFin, tiquete.getFechaFin());
        assertFalse(tiquete.isUtilizado());
    }

    @Test
    public void testCrearTiqueteEntradaIndividual() {
        Atraccion atraccion = new Cultural("Casa del Terror", "BASICO", "Zona A", 20, 2, List.of("Lluvia"), false, 12);
        Date fechaFastPass = new Date();

        TiqueteEntradaIndividual tiquete = new TiqueteEntradaIndividual("TI001", CategoriaTiquete.BASICO, true, fechaFastPass, atraccion);

        assertEquals("TI001", tiquete.getId());
        assertEquals("BASICO", tiquete.getCategoria());
        assertEquals(atraccion, tiquete.getAtraccionAsociad());
        assertTrue(tiquete.isFastPass());
        assertFalse(tiquete.isUtilizado());
    }
}
