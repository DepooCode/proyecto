package parque;

public class Usuario {
    private String usuario;
    private String contrasenia;
    private boolean iniciado;

    public Usuario(String usuario, String contrasenia) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.iniciado = false;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public boolean isIniciado() {
        return iniciado;
    }

    public void setIniciado(boolean iniciado) {
        this.iniciado = iniciado;
    }

    public boolean iniciarSesion(String usuario, String contrasenia) {
        if (this.usuario.equals(usuario) && this.contrasenia.equals(contrasenia)) {
            this.iniciado = true;
            return true;
            
        } else {
        	return false;
            
        }
    }

    public void cerrarSesion() {
        this.iniciado = false;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    

    public void setContrasena(String contrasena) {
        this.contrasenia = contrasena;
    }
}
