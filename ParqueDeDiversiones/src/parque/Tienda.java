package parque;

import persistencia.Persistable;
import java.util.TreeMap;

public class Tienda extends Servicio implements Persistable{
    private String nombre;
    private String tipo;
    private boolean tieneCajero;
    private TreeMap<Integer, String> articulosFacturadosVendidos;

    // Constructor
    public Tienda(String nombre, String tipo) {
        super(nombre, tipo);
        this.articulosFacturadosVendidos = new TreeMap<>();
    }

    // Métodos getter y setter
    

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

	@Override
	public String getId() {
		
		return "Tienda";
	}

	@Override
	public String getTipoEntidad() {
		
		return "Tienda: " + nombre + " | tipo: " + tipo;
	}
    
}
