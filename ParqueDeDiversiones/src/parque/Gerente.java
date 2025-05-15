package parque;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Gerente extends Empleado {
    public List<EmpleadoNormal> listaEmpleadosGest;
    public List<Atraccion> listaAtraccionesGest;
    public List<Espectaculo> listaEspectaculosGest;

    public Gerente(String id, String nombre, String usuario, String contrasenia) {
        super(id, nombre, usuario, contrasenia);
        this.listaEmpleadosGest = new ArrayList<>();
        this.listaAtraccionesGest = new ArrayList<>();
        this.listaEspectaculosGest = new ArrayList<>();
    }

    public void asignarTurno(EmpleadoNormal empleado, Turno turno) {
        if (!isIniciado()) {
            System.out.println("Debe iniciar sesión para asignar turnos.");
            return;
        }
        if (listaEmpleadosGest.contains(empleado)) {
            empleado.getTurnosAsignados().add(turno);
            turno.setAsignado(true);
        }
    }

    public void eliminarTurno(EmpleadoNormal empleado, Turno turno) {
        if (!isIniciado()) {
            System.out.println("Debe iniciar sesión para eliminar turnos.");
            return;
        }
        if (listaEmpleadosGest.contains(empleado)) {
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
        if (!isIniciado()) {
            System.out.println("Debe iniciar sesión para agregar empleados.");
            return;
        }
        if (!listaEmpleadosGest.contains(empleado)) {
            listaEmpleadosGest.add(empleado);
            System.out.println("Empleado agregado correctamente.");
        } else {
            System.out.println("El empleado ya está en la lista.");
        }
    }

    public void eliminarEmpleado(EmpleadoNormal empleado) {
        if (!isIniciado()) {
            System.out.println("Debe iniciar sesión para eliminar empleados.");
            return;
        }
        if (listaEmpleadosGest.contains(empleado)) {
            listaEmpleadosGest.remove(empleado);
            System.out.println("Empleado eliminado correctamente.");
        } else {
            System.out.println("El empleado ya no está en la lista.");
        }
    }

    public EmpleadoNormal getEmpleado(EmpleadoNormal empleado) {
        if (!isIniciado()) {
            System.out.println("Debe iniciar sesión para consultar empleados.");
            return null;
        }
        if (listaEmpleadosGest.contains(empleado)) {
            return empleado;
        } else {
            return null;
        }
    }

    public void agregarAtraccion(Atraccion atraccion) {
        if (!isIniciado()) {
            System.out.println("Debe iniciar sesión para agregar atracciones.");
            return;
        }
        if (!listaAtraccionesGest.contains(atraccion)) {
            listaAtraccionesGest.add(atraccion);
            System.out.println("Atracción agregada correctamente.");
        } else {
            System.out.println("La atracción ya está en la lista.");
        }
    }

    public void agregarEspectaculo(Espectaculo espectaculo) {
        if (!isIniciado()) {
            System.out.println("Debe iniciar sesión para agregar espectáculos.");
            return;
        }
        if (!listaEspectaculosGest.contains(espectaculo)) {
            listaEspectaculosGest.add(espectaculo);
            System.out.println("Espectáculo agregado correctamente.");
        } else {
            System.out.println("El espectáculo ya está en la lista.");
        }
    }

    public void gestionarAtraccion(Atraccion atraccion) {
        if (!isIniciado()) {
            System.out.println("Debe iniciar sesión para gestionar atracciones.");
            return;
        }
    
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Gestión de atracción: " + atraccion.getNombre());
   
            System.out.println("¿Qué desea modificar?");
            System.out.println("1. Nombre");
            System.out.println("2. Exclusividad");
            System.out.println("3. Ubicación");
            System.out.println("4. Cupo máximo");
            System.out.println("5. Número de encargados mínimo");
            System.out.println("6. Temporada");
            System.out.println("7. Restricciones por clima");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); 
   
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nuevo nombre de la atracción: ");
                    String nuevoNombre = scanner.nextLine();
                    atraccion.setNombre(nuevoNombre);
                    break;
   
                case 2:
                    System.out.print("Ingrese la nueva exclusividad: ");
                    String nuevaExclusividad = scanner.nextLine();
                    atraccion.setExclusividad(nuevaExclusividad);
                    break;
   
                case 3:
                    System.out.print("Ingrese la nueva ubicación: ");
                    String nuevaUbicacion = scanner.nextLine();
                    atraccion.setUbicacion(nuevaUbicacion);
                    break;
   
                case 4:
                    System.out.print("Ingrese el nuevo cupo máximo: ");
                    int nuevoCupo = scanner.nextInt();
                    atraccion.setCupoMaximo(nuevoCupo);
                    break;
   
                case 5:
                    System.out.print("Ingrese el nuevo número de encargados mínimos: ");
                    int nuevosEncargados = scanner.nextInt();
                    atraccion.setNumeroEncargadosMin(nuevosEncargados);
                    break;
   
                case 6:
                    System.out.print("¿Es de temporada? (true/false): ");
                    boolean esDeTemporada = scanner.nextBoolean();
                    atraccion.setDeTemporada(esDeTemporada);
                    break;
   
                case 7:
                    System.out.println("Ingrese las restricciones por clima (separadas por coma): ");
                    scanner.nextLine(); 
                    String restricciones = scanner.nextLine();
                    List<String> nuevasRestricciones = List.of(restricciones.split(","));
                    atraccion.setRestriccionesClima(nuevasRestricciones);
                    break;
   
                default:
                    System.out.println("Opción no válida.");
            }
        }
        System.out.println("Atracción modificada exitosamente.");
    }

    public void gestionarEspectaculo(Espectaculo espectaculo) {
    if (!isIniciado()) {
        System.out.println("Debe iniciar sesión para gestionar espectáculos.");
        return;
    }

    try (Scanner scanner = new Scanner(System.in)) {
        System.out.println("Gestión de espectáculo: " + espectaculo.getNombre());

        System.out.println("¿Qué desea modificar?");
        System.out.println("1. Nombre");
        System.out.println("2. Horario");
        System.out.println("3. Fecha");
        System.out.println("4. Restricciones por clima");
        System.out.println("5. Temporada");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); 

        switch (opcion) {
            case 1:
                System.out.print("Ingrese el nuevo nombre del espectáculo: ");
                String nuevoNombre = scanner.nextLine();
                espectaculo.setNombre(nuevoNombre);
                break;

            case 2:
                System.out.print("Ingrese el nuevo horario (formato HH:mm): ");
                String horarioStr = scanner.nextLine();
                LocalTime nuevoHorario = LocalTime.parse(horarioStr);
                espectaculo.setHorario(nuevoHorario);
                break;

            case 3:
                System.out.print("Ingrese la nueva fecha (formato yyyy-MM-dd): ");
                String fechaStr = scanner.nextLine();
                Date nuevaFecha = java.sql.Date.valueOf(fechaStr);
                espectaculo.setFecha(nuevaFecha);
                break;

            case 4:
                System.out.println("Ingrese las restricciones por clima (separadas por coma): ");
                String restricciones = scanner.nextLine();
                List<String> nuevasRestricciones = List.of(restricciones.split(","));
                espectaculo.setRestriccionesClima(nuevasRestricciones);
                break;

            case 5:
                System.out.print("¿Es de temporada? (true/false): ");
                boolean esDeTemporada = scanner.nextBoolean();
                espectaculo.setDeTemporada(esDeTemporada);
                break;

            default:
                System.out.println("Opción no válida.");
        }
    }
    System.out.println("Espectáculo modificado exitosamente.");
}

    public void eliminarAtraccion(Atraccion atraccion) {
        if (!isIniciado()) {
            System.out.println("Debe iniciar sesión para eliminar atracciones.");
            return;
        }
        if (listaAtraccionesGest.contains(atraccion)) {
            listaAtraccionesGest.remove(atraccion);
            System.out.println("Atracción eliminada correctamente.");
        } else {
            System.out.println("La atracción no se encuentra en la lista.");
        }
    }

    public void eliminarEspectaculo(Espectaculo espectaculo) {
        if (!isIniciado()) {
            System.out.println("Debe iniciar sesión para eliminar espectáculos.");
            return;
        }
        if (listaEspectaculosGest.contains(espectaculo)) {
            listaEspectaculosGest.remove(espectaculo);
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


    @Override
    public String getTipoEntidad() {
        return "Gerente";
    }

    @Override
    public String toString() {
        return "Gerente: " + getNombre() + " | ID: " + getId() + " | Usuarios gestionados: " + listaEmpleadosGest.size();
    }
}
