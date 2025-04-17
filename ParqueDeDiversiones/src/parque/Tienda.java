package parque;

import java.util.TreeMap;

public class Tienda {
    private String nombre;
    private String tipo;
    private boolean tieneCajero;
    private TreeMap<Integer, String> articulosFacturadosVendidos;

    // Constructor
    public Tienda(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.articulosFacturadosVendidos = new TreeMap<>();
    }

    // Métodos getter y setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public void venderFacturarArticulo(String articulo, int precio) {
        articulosFacturadosVendidos.put(precio, articulo);
    }

    public TreeMap<Integer, String> getArticulosFacturadosVendidos() {
        return articulosFacturadosVendidos;
    }
}
