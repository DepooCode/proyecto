package parque;

import persistencia.Persistable;
import java.util.TreeMap;

public class Taquilla extends Servicio implements Persistable {
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

    // Persistable
    @Override
    public String getId() {
        return nombre; // nombre heredado de LugarTrabajo
    }

    @Override
    public String getTipoEntidad() {
        return "Taquilla";
    }

    @Override
    public String toString() {
        return "Taquilla: " + nombre + " | Tiquetes vendidos: " + mapaTiquetes.size();
    }
}
