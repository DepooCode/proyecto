package parque;

import java.util.ArrayList;
import java.util.List;
 
public class Gerente extends Empleado {
    public List<EmpleadoNormal> listaEmpleadosGest;
    public List<Atraccion> listaAtraccionesGest;
    public List<Espectaculo> listaEspectaculosGest;
    public Gerente(String id, String nombre) {
        super(id, nombre);
        this.listaEmpleadosGest = new ArrayList<>();
        this.listaAtraccionesGest = new ArrayList<>();
        this.listaEspectaculosGest = new ArrayList<>();

    }

    public void asignarTurno(EmpleadoNormal empleado, Turno turno) {
        if (getListaEmpleadosGest().contains(empleado)) {
            empleado.getTurnosAsignados().add(turno);
                turno.setAsignado(true);
        }
    }
    


    public void eliminarTurno(EmpleadoNormal empleado, Turno turno) {
        if (getListaEmpleadosGest().contains(empleado)) {
            if (empleado.getTurnosAsignados().contains(turno)) {
                empleado.getTurnosAsignados().remove(turno);
    
                turno.setAsignado(false);
            } else {
                System.out.println("El empleado no tiene asignado este turno.");
            }
        } else {
            System.out.println("Empleado no encontrado en la lista de empleados gestionados.");
        }
    }
    

    public void agregarEmpleado(EmpleadoNormal empleado) {
        if (!getListaEmpleadosGest().contains(empleado)) {
                getListaEmpleadosGest().add(empleado);
                System.out.println("Empleado agregado correctamente.");
            } else {
                System.out.println("El empleado ya está en la lista.");
            }
        }
        
    

    public void eliminarEmpleado(EmpleadoNormal empleado) {
        if (!getListaEmpleadosGest().contains(empleado)) {
            getListaEmpleadosGest().remove(empleado);
            System.out.println("Empleado eliminado correctamente.");
        } else {
            System.out.println("El empleado ya no está en la lista.");
        }
    }
    

    public EmpleadoNormal getEmpleado(EmpleadoNormal empleado) {
        if (getListaEmpleadosGest().contains(empleado)) {
            return empleado;
        } else {
            return null;
        }
    }

    public void agregarAtraccion(Atraccion atraccion) {
        if (!getListaAtraccionesGest().contains(atraccion)) {
            getListaAtraccionesGest().add(atraccion);
            System.out.println("Atracción agregada correctamente.");
        } else {
            System.out.println("La atracción ya está en la lista.");
        }
    }
    

    public void agregarEspectaculo(Espectaculo espectaculo) {
        if (!getListaEspectaculosGest().contains(espectaculo)) {
            getListaEspectaculosGest().add(espectaculo);
            System.out.println("Espectáculo agregado correctamente.");
        } else {
            System.out.println("El espectáculo ya está en la lista.");
        }
    }
    

    public void gestionarAtraccion(Atraccion atraccion) {
    }

    public void gestionarEspectaculo(Espectaculo espectaculo) {
    }

    public void eliminarAtraccion(Atraccion atraccion) {
        if (getListaAtraccionesGest().contains(atraccion)) {
            getListaAtraccionesGest().remove(atraccion);
            System.out.println("Atracción eliminada correctamente.");
        } else {
            System.out.println("La atracción no se encuentra en la lista.");
        }
    }

    public void eliminarEspectaculo(Espectaculo espectaculo) {
        if (getListaEspectaculosGest().contains(espectaculo)) {
            getListaEspectaculosGest().remove(espectaculo);
            System.out.println("Espectáculo eliminado correctamente.");
        } else {
            System.out.println("El espectáculo no se encuentra en la lista.");
        }
    }
    

    public List<Atraccion> getListaAtraccionesGest() {
        return listaAtraccionesGest;
    }

    public List<Espectaculo> getListaEspectaculosGest() {
        return listaEspectaculosGest;
    }

    public List<EmpleadoNormal> getListaEmpleadosGest() {
        return listaEmpleadosGest;
    }
}