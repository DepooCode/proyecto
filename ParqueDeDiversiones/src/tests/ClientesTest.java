package tests;
import parque.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;


public class ClientesTest {

    private Cliente cliente;
    private TiqueteGeneral tiquete1;
    private TiqueteGeneral tiquete2;

    @BeforeEach
    public void setUp() {
        cliente = new Cliente("juan123", "pass456", true);
        tiquete1 = new TiqueteGeneral("TQ001", CategoriaTiquete.BASICO, false, new Date());
        tiquete2 = new TiqueteGeneral("TQ002", CategoriaTiquete.BASICO, true, new Date());
    }

    @Test
    public void testIniciarSesionCorrecto() {
        assertTrue(cliente.iniciarSesion("juan123", "pass456"));
        assertTrue(cliente.isIniciado());
    }

    @Test
    public void testIniciarSesionIncorrecto() {
        assertFalse(cliente.iniciarSesion("otro", "incorrecto"));
        assertFalse(cliente.isIniciado());
    }

    @Test
    public void testCerrarSesion() {
        cliente.iniciarSesion("juan123", "pass456");
        cliente.cerrarSesion();
        assertFalse(cliente.isIniciado());
    }

    @Test
    public void testGestionUsuarioYContrasena() {
        cliente.setUsuario("nuevoUsuario");
        cliente.setContrasena("nuevaClave");
        assertEquals("nuevoUsuario", cliente.getUsuario());
        assertEquals("nuevaClave", cliente.getContrasena());
    }

    @Test
    public void testCompraTiquete() {
        cliente.comprarTiquete(tiquete1);
        assertTrue(cliente.getListaTiquetesComprados().contains(tiquete1));
        assertEquals(1, cliente.getListaTiquetesComprados().size());
    }

    @Test
    public void testBuscarTiquete() {
        cliente.comprarTiquete(tiquete1);
        assertTrue(cliente.buscarTiqueteEnMisTiquetes(tiquete1));
        assertFalse(cliente.buscarTiqueteEnMisTiquetes(tiquete2));
    }

    @Test
    public void testUsarTiqueteExitosamente() {
        cliente.comprarTiquete(tiquete1);
        assertFalse(tiquete1.isUtilizado());
        cliente.usarTiquete(tiquete1);
        assertTrue(tiquete1.isUtilizado());
    }

    @Test
    public void testUsarTiqueteNoComprado() {
        cliente.usarTiquete(tiquete2); 
        assertFalse(tiquete2.isUtilizado());
    }

    @Test
    public void testTieneDescuento() {
        assertTrue(cliente.isTieneDescuento());
        cliente.setTieneDescuento(false);
        assertFalse(cliente.isTieneDescuento());
    }
}
