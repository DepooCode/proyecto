package parque;

import persistencia.Persistable;
import java.util.Date;

public class TiqueteEntradaIndividual extends Tiquete implements Persistable {
    private Atraccion atraccionAsociada;

    public TiqueteEntradaIndividual(String id, CategoriaTiquete categoria, boolean fastPass, Date fechaFastPass, Atraccion atraccion) {
        super(id, categoria, fastPass, fechaFastPass);
        this.atraccionAsociada = atraccion;
    }

    public Atraccion getAtraccionAsociad() {
        return atraccionAsociada;
    }

    public void setAtraccionAsociada(Atraccion atraccion) {
        this.atraccionAsociada = atraccion;
    }

    @Override
    public boolean esValido(Date fechaUso) {
        return !utilizado; 
    }

    // Persistable
    @Override
    public String getTipoEntidad() {
        return "TiqueteEntradaIndividual";
    }

    @Override
    public String toString() {
        return "Tiquete Entrada Individual: " + id + " | Categoría: " + categoria + " | FastPass: " + fastPass +
               " | Atracción: " + (atraccionAsociada != null ? atraccionAsociada.getNombre() : "N/A");
    }
}
