package parque;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String usuario;
    private String contrasena;
    private boolean tieneDescuento;
    private List<Tiquete> tiquetesComprados;

    public Cliente(String usuario, String contrasena, boolean tieneDescuento) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.tieneDescuento = tieneDescuento;
        this.tiquetesComprados = new ArrayList<>();
    }

    public void usarTiquete(Tiquete tiquete) {
        if (tiquetesComprados.contains(tiquete)) {
            if (!tiquete.isUtilizado()) {
                tiquete.usarTiquete();
                System.out.println("El tiquete ha sido utilizado con éxito.");
            } else {
                System.out.println("El tiquete ya fue utilizado anteriormente.");
            }
        } else {
            System.out.println("Este tiquete no pertenece a este cliente.");
        }
    }

    public void comprarTiquete(Tiquete tiquete, boolean tieneDescuento) {
        this.tieneDescuento = tieneDescuento;
        tiquetesComprados.add(tiquete);
        System.out.println("Tiquete agregado a la lista de compras. ¿Con descuento? " + (tieneDescuento ? "Sí" : "No"));
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public boolean isTieneDescuento() {
        return tieneDescuento;
    }

    public List<Tiquete> getTiquetesComprados() {
        return tiquetesComprados;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setTieneDescuento(boolean tieneDescuento) {
        this.tieneDescuento = tieneDescuento;
    }
}

