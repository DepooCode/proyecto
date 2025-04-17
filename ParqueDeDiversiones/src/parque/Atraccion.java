package parque;

import java.util.List;

public abstract class Atraccion {
    private String exclusividad;
    private String ubicacion;
    private int cupoMaximo;
    private int numeroEncargadosMin;
    private boolean deTemporada;
    private List<String> restriccionesClima;
    private String nombre;

    public Atraccion(String nombre, String exclusividad, String ubicacion, int cupoMaximo, 
                     int numeroEncargadosMin, boolean deTemporada, List<String> restriccionesClima) {
        this.nombre = nombre;
        this.exclusividad = exclusividad;
        this.ubicacion = ubicacion;
        this.cupoMaximo = cupoMaximo;
        this.numeroEncargadosMin = numeroEncargadosMin;
        this.deTemporada = deTemporada;
        this.restriccionesClima = restriccionesClima;
    }

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

    public abstract boolean revisarRegistrarTiquete(Tiquete tiquete);
}