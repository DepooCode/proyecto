package parque;

import java.util.TreeMap;

public class Cafeteria extends Servicio {

    private boolean tieneCocinero;
    private TreeMap<Integer, String> comidaFacturadaVendida;
    private boolean tieneCajero;

    public Cafeteria(String nombre, String tipo) {
        super(nombre, tipo);
        this.tieneCocinero = false;
        this.tieneCajero = false;
        this.comidaFacturadaVendida = new TreeMap<>();
    }

    public boolean isTieneCocinero() {
        return tieneCocinero;
    }

    public void setTieneCocinero(boolean tieneCocinero) {
        this.tieneCocinero = tieneCocinero;
    }

    public boolean isTieneCajero() {
        return tieneCajero;
    }

    public void setTieneCajero(boolean tieneCajero) {
        this.tieneCajero = tieneCajero;
    }

    public TreeMap<Integer, String> getComidaFacturadaVendida() {
        return comidaFacturadaVendida;
    }

    public void venderFacturarComida(String comida, int precio) {
        if (comida != null && !comida.isEmpty() && precio > 0) {
            comidaFacturadaVendida.put(precio, comida);
            System.out.println("Comida vendida y facturada: " + comida + " | Precio: " + precio);
        } else {
            System.out.println("Error al facturar: datos inválidos.");
        }
    }
}
