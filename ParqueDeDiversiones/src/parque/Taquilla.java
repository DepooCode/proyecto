package parque;

import java.util.TreeMap;

public class Taquilla extends Servicio {
    private TreeMap<Integer, String> mapaTiquetes;

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
        mapaTiquetes.put(precio, tiquete.toString());
    }

    public TreeMap<Integer, String> getMapaTiquetes() {
        return mapaTiquetes;
    }
}
