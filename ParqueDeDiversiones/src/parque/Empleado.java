package parque;

import persistencia.Persistable;

public class Empleado implements Persistable {
    private String id;
    private String nombre;
    private String usuario;
    private String contrasenia;
    private boolean iniciado;

    public Empleado(String id, String nombre, String usuario, String contrasenia) {
        this.id = id;
        this.nombre = nombre;
        this.iniciado = false;
        this.contrasenia = contrasenia;
        this.usuario = usuario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public boolean isIniciado() {
        return iniciado;
    }

    public boolean iniciarSesion(String usuario, String contrasenia) {
        if (this.usuario != null && this.contrasenia != null &&
            this.usuario.equals(usuario) && this.contrasenia.equals(contrasenia)) {
            iniciado = true;
            return true;
        }
        return false;
    }

    public void cerrarSesion() {
        iniciado = false;
    }

    // Implementación de Persistable
    @Override
    public String getTipoEntidad() {
        return "Empleado";
    }

    // Para mostrar info en consola
    @Override
    public String toString() {
        return "Empleado: " + nombre + " | ID: " + id + " | Usuario: " + usuario;
    }
}
