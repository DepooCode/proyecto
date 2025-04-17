package parque;

public abstract class Servicio extends LugarTrabajo {
    protected String tipo;
    protected boolean tieneCajero;

    public Servicio(String nombre, String tipo) {
        super(nombre);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isTieneCajero() {
        return tieneCajero;
    }

    public void setTieneCajero(boolean tieneCajero) {
        this.tieneCajero = tieneCajero;
    }
}
