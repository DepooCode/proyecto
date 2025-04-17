package tests;
import parque.*;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TiqueteValidezTest {

    @Test
    public void testTiqueteGeneralValido() {
        TiqueteGeneral t = new TiqueteGeneral("TG001", CategoriaTiquete.BASICO, false, null);
        assertTrue(t.esValido(new Date()));

        t.usarTiquete();
        assertFalse(t.esValido(new Date()));
    }

    @Test
    public void testTiqueteTemporadaValido() {
        Date ahora = new Date();
        Date fin = new Date(System.currentTimeMillis() + 1000000000L); // futuro
        TiqueteTemporada t = new TiqueteTemporada("TT001", CategoriaTiquete.FAMILIAR, false, null, fin);

        assertTrue(t.esValido(ahora));

        Date despuesDeFin = new Date(fin.getTime() + 10000);
        assertFalse(t.esValido(despuesDeFin));
    }

    @Test
    public void testTiqueteEntradaIndividualValido() {
        Atraccion atraccion = new Cultural("Museo Virtual", "BASICO", "Zona B", 15, 3, List.of("Ninguna"), false, 10);
        TiqueteEntradaIndividual t = new TiqueteEntradaIndividual("TI001", CategoriaTiquete.BASICO, false, null, atraccion);

        assertTrue(t.esValido(new Date()));
        t.usarTiquete();
        assertFalse(t.esValido(new Date()));
    }
}