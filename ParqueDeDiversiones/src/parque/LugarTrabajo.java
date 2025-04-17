package parque;

public abstract class LugarTrabajo {
    protected String nombre;

    public LugarTrabajo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
