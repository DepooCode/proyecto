package tests;
import parque.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

public class ServicioTest {

    @Test
    public void testCafeteria() {
        Cafeteria cafeteria = new Cafeteria("Café Central", "Alimentos");
        cafeteria.setTieneCocinero(true);
        cafeteria.setTieneCajero(true);

        assertEquals("Alimentos", cafeteria.getTipo());
        assertTrue(cafeteria.isTieneCocinero());
        assertTrue(cafeteria.isTieneCajero());

        cafeteria.venderFacturarComida("Hamburguesa", 15000);
        TreeMap<Integer, String> comidas = cafeteria.getComidaFacturadaVendida();
        assertEquals("Hamburguesa", comidas.get(15000));
    }

    @Test
    public void testTienda() {
        Tienda tienda = new Tienda("Tienda 1", "Recuerdos");
        tienda.setTieneCajero(true);

        assertEquals("Recuerdos", tienda.getTipo());
        assertTrue(tienda.isTieneCajero());

        tienda.venderFacturarArticulo("Llavero", 5000);
        assertEquals("Llavero", tienda.getArticulosFacturadosVendidos().get(5000));
    }

    @Test
    public void testTaquilla() {
        Taquilla taquilla = new Taquilla("Taquilla Norte", "VentaTiquetes");
        taquilla.setTieneCajero(true);

        assertEquals("VentaTiquetes", taquilla.getTipo());
        assertTrue(taquilla.isTieneCajero());

        
        TiqueteGeneral tiquete = new TiqueteGeneral("TQ001", CategoriaTiquete.BASICO, false, null);
        taquilla.venderFacturarTiquete(tiquete, 20000);

        assertTrue(taquilla.getMapaTiquetes().containsKey("TQ001"));
        assertEquals(20000, taquilla.getMapaTiquetes().get("TQ001"));
    }
    @Test
    public void testMecanicaAceptaTiqueteCorrecto() {
        Mecanica mecanica = new Mecanica(
            "Montaña Rusa", "DIAMANTE", "Zona A", 30, 3, false,
            Arrays.asList("Lluvia", "Tormenta"), 1.2f, 2.0f, 40f, 120f,
            Arrays.asList("Cardíacos"), "Alto"
        );

        TiqueteGeneral tiqueteValido = new TiqueteGeneral("TQ001", CategoriaTiquete.DIAMANTE, false, new Date());
        assertTrue(mecanica.revisarRegistrarTiquete(tiqueteValido));
    }

    @Test
    public void testMecanicaRechazaTiqueteIncorrecto() {
        Mecanica mecanica = new Mecanica(
            "Montaña Rusa", "DIAMANTE", "Zona A", 30, 3, false,
            Arrays.asList("Lluvia", "Tormenta"), 1.2f, 2.0f, 40f, 120f,
            Arrays.asList("Cardíacos"), "Alto"
        );

        TiqueteGeneral tiqueteInvalido = new TiqueteGeneral("TQ002", CategoriaTiquete.BASICO, false, new Date());
        assertFalse(mecanica.revisarRegistrarTiquete(tiqueteInvalido));
    }

    @Test
    public void testCulturalAceptaTiqueteCorrecto() {
        Cultural cultural = new Cultural(
            "Museo del Parque", "FAMILIAR", "Zona B", 50, 2,
            Arrays.asList("Viento fuerte"), true, 7
        );

        TiqueteGeneral tiqueteValido = new TiqueteGeneral("TQ003", CategoriaTiquete.FAMILIAR, false, new Date());
        assertTrue(cultural.revisarRegistrarTiquete(tiqueteValido));
    }

    @Test
    public void testCulturalRechazaTiqueteIncorrecto() {
        Cultural cultural = new Cultural(
            "Museo del Parque", "FAMILIAR", "Zona B", 50, 2,
            Arrays.asList("Viento fuerte"), true, 7
        );

        TiqueteGeneral tiqueteInvalido = new TiqueteGeneral("TQ004", CategoriaTiquete.ORO, false, new Date());
        assertFalse(cultural.revisarRegistrarTiquete(tiqueteInvalido));
    }


}