package parque;

import persistencia.Persistable;
import java.util.List;

public abstract class Atraccion extends LugarTrabajo implements Persistable {
    private String exclusividad;
    private String ubicacion;
    private int cupoMaximo;
    private int numeroEncargadosMin;
    private boolean deTemporada;
    private List<String> restriccionesClima;

    public Atraccion(String nombre, String exclusividad, String ubicacion, int cupoMaximo, 
                     int numeroEncargadosMin, boolean deTemporada, List<String> restriccionesClima) {
        super(nombre);
        this.exclusividad = exclusividad;
        this.ubicacion = ubicacion;
        this.cupoMaximo = cupoMaximo;
        this.numeroEncargadosMin = numeroEncargadosMin;
        this.deTemporada = deTemporada;
        this.restriccionesClima = restriccionesClima;
    }

    // Getters y setters
    public String getExclusividad() {
        return exclusividad;
    }

    public void setExclusividad(String ex) {
        this.exclusividad = ex;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ub) {
        this.ubicacion = ub;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(int cupo) {
        this.cupoMaximo = cupo;
    }

    public int getNumeroEncargadosMin() {
        return numeroEncargadosMin;
    }

    public void setNumeroEncargadosMin(int num) {
        this.numeroEncargadosMin = num;
    }

    public boolean isDeTemporada() {
        return deTemporada;
    }

    public void setDeTemporada(boolean temp) {
        this.deTemporada = temp;
    }

    public List<String> getRestriccionesClima() {
        return restriccionesClima;
    }

    public void setRestriccionesClima(List<String> restricciones) {
        this.restriccionesClima = restricciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Implementación de Persistable
    @Override
    public String getId() {
        return nombre; 
    }

    @Override
    public String getTipoEntidad() {
        return "Atraccion";
    }

    @Override
    public String toString() {
        return "Atracción: " + nombre + ", ubicación: " + ubicacion + ", cupo: " + cupoMaximo;
    }

    public abstract boolean revisarRegistrarTiquete(Tiquete tiquete);
}
