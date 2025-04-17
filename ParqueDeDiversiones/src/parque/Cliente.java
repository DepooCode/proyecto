package parque;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String usuario;
    private String contrasena;
    private boolean tieneDescuento;
    private List<Tiquete> tiquetesComprados;
    public boolean iniciado;

    public Cliente(String usuario, String contrasena, boolean tieneDescuento) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.tieneDescuento = tieneDescuento;
        this.tiquetesComprados = new ArrayList<>();
        this.iniciado = false;
    }

    public void usarTiquete(Tiquete tiquete) {
        if (buscarTiqueteEnMisTiquetes(tiquete)) {
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

    public void comprarTiquete(Tiquete tiquete) {
        tiquetesComprados.add(tiquete);
        System.out.println("Tiquete agregado a la lista de compras. ¿Con descuento? " + (tieneDescuento ? "Sí" : "No"));
    }

    public boolean isTieneDescuento() {
        return tieneDescuento;
    }

    public void setTieneDescuento(boolean tieneDescuento) {
        this.tieneDescuento = tieneDescuento;
    }

    public List<Tiquete> getListaTiquetesComprados() {
        return tiquetesComprados;
    }

    public boolean buscarTiqueteEnMisTiquetes(Tiquete tiquete) {
        return tiquetesComprados.contains(tiquete);
    }

    public boolean iniciarSesion(String usuario, String contrasena) {
        if (this.usuario.equals(usuario) && this.contrasena.equals(contrasena)) {
            this.iniciado = true;
            return true;
        }
        return false;
    }

    public void cerrarSesion() {
        this.iniciado = false;
    }

    public boolean isIniciado() {
        return iniciado;
    }


    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

}

