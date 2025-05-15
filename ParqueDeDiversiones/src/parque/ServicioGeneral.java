package parque;

import persistencia.Persistable;

public class ServicioGeneral extends LugarTrabajo implements Persistable {
    private static final String NOMBRE_GENERAL = "ServicioGeneral";

    public ServicioGeneral(String nombre) {
        super(nombre); 
    }

    public String getNombreGeneral() {
        return NOMBRE_GENERAL;
    }

    // Implementación de Persistable
    @Override
    public String getId() {
        return nombre;
    }

    @Override
    public String getTipoEntidad() {
        return "ServicioGeneral";
    }

    @Override
    public String toString() {
        return "Servicio General: " + nombre;
    }
}

