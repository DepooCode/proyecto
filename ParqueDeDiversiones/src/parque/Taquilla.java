package parque;

import java.util.TreeMap;

public class Taquilla extends Servicio {
    private TreeMap<String, Integer> mapaTiquetes;

    public Taquilla(String nombre, String tipo) {
        super(nombre, tipo);
        mapaTiquetes = new TreeMap<>();
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

    public void venderFacturarTiquete(Tiquete tiquete, int precio) {
        mapaTiquetes.put(tiquete.getId(), precio);
    }

    public TreeMap<String, Integer> getMapaTiquetes() {
        return mapaTiquetes;
    }
}
