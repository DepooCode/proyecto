package parque;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public class Espectaculo {
    private String nombre;
    private LocalTime horario;
    private Date fecha;
    private List<String> restriccionesClima;
    private boolean deTemporada;

    public Espectaculo(String nombre, LocalTime horario, Date fecha, List<String> restriccionesClima, boolean deTemporada) {
        this.nombre = nombre;
        this.horario = horario;
        this.fecha = fecha;
        this.restriccionesClima = restriccionesClima;
        this.deTemporada = deTemporada;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<String> getRestriccionesClima() {
        return restriccionesClima;
    }

    public void setRestriccionesClima(List<String> restricciones) {
        this.restriccionesClima = restricciones;
    }

    public boolean isDeTemporada() {
        return deTemporada;
    }

    public void setNumeroEncargadosMin(int num) {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDeTemporada(boolean deTemporada){
        this.deTemporada= deTemporada;
    }
}