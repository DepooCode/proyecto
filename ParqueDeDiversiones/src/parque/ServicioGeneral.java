package parque;

public class ServicioGeneral extends LugarTrabajo {
    private static final String NOMBRE = "ServicioGeneral";

    public ServicioGeneral(String nombre) {
        super(nombre); 
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }

    public String getNombreGeneral() {
        return NOMBRE;
    }
}

