package parque;

import persistencia.Persistable;

public class Empleado extends Usuario implements Persistable{
    private String id;
    private String nombre;
    private String usuario;
    private String contrasenia;
    private boolean iniciado;

    public Empleado(String id, String nombre, String usuario, String contrasenia) {
    	super(usuario, contrasenia);
        this.id = id;
        this.nombre = nombre;
        this.iniciado = false;
        
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

    

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
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
