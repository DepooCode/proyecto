package parque;

import persistencia.Persistable;
import java.util.Date;

public class TiqueteTemporada extends Tiquete implements Persistable {
    private Date fechaFin;

    public TiqueteTemporada(String id, CategoriaTiquete categoria, boolean fastPass, Date fechaFastPass, Date fechaFin) {
        super(id, categoria, fastPass, fechaFastPass);
        this.fechaFin = fechaFin;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public boolean esValido(Date fechaUso) {
        return !utilizado && fechaUso.before(fechaFin);
    }

    // Persistable
    @Override
    public String getTipoEntidad() {
        return "TiqueteTemporada";
    }

    @Override
    public String toString() {
        return "Tiquete Temporada: " + id + " | Válido hasta: " + fechaFin + " | Categoría: " + categoria;
    }
}
