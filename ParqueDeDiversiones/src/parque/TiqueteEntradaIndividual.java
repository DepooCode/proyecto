package parque;

import java.util.Date;

public class TiqueteEntradaIndividual extends Tiquete {
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
}
