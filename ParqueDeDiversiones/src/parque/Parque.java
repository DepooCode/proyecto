package parque;

import java.util.ArrayList;
import java.util.List;

public class Parque {
    private List<Empleado> listaEmpleados;
    private List<Atraccion> listaAtracciones;
    private List<Espectaculo> listaEspectaculos;

    public Parque() {
        listaEmpleados = new ArrayList<>();
        listaAtracciones = new ArrayList<>();
        listaEspectaculos = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        listaEmpleados.add(empleado);
    }

    public void eliminarEmpleado(Empleado empleado) {
        listaEmpleados.remove(empleado);
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void agregarAtraccion(Atraccion atraccion) {
        listaAtracciones.add(atraccion);
    }

    public void eliminarAtraccion(Atraccion atraccion) {
        listaAtracciones.remove(atraccion);
    }

    public List<Atraccion> getListaAtracciones() {
        return listaAtracciones;
    }

    public void agregarEspectaculo(Espectaculo espectaculo) {
        listaEspectaculos.add(espectaculo);
    }

    public void eliminarEspectaculo(Espectaculo espectaculo) {
        listaEspectaculos.remove(espectaculo);
    }

    public List<Espectaculo> getListaEspectaculos() {
        return listaEspectaculos;
    }
}
