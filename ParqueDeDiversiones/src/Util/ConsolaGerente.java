package Util;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import parque.Atraccion;
import parque.Empleado;
import parque.EmpleadoNormal;
import parque.Espectaculo;
import parque.Gerente;
import parque.Turno;

public class ConsolaGerente {
    
    private static Scanner scanner = new Scanner(System.in);
    private static Gerente gerente = new Gerente("1", "Juan Pérez", "juanp", "admin123");

    public static void main(String[] args) {
        if (iniciarSesion()) {
            while (true) {
                mostrarMenu();
                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        listarEmpleados();
                        break;
                    case 2: 
                        crearEmpleado();
                        break;
                    case 3:
                        crearAtraccion();
                        break;
                    case 4:
                        crearEspectaculo();
                        break;
                    case 5:
                        asignarTurno();
                        break;
                    case 6:
                        eliminarTurno();
                        break;
                    case 7:
                        listarAtracciones();
                        break;
                    case 8:
                        listarEspectaculos();
                        break;
                    case 9:
                        listarEmpleadosYTurnos();
                        break;
                    case 10:
                        System.out.println("Saliendo...");
                        return;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            }
        }
    }

    private static boolean iniciarSesion() {
        System.out.print("Usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Contraseña: ");
        String clave = scanner.nextLine();

        if (gerente.getUsuario().equals(usuario) && gerente.getContrasenia().equals(clave)) {
            System.out.println("Inicio de sesión exitoso.\n");
            return true;
        } else {
            System.out.println("Credenciales incorrectas.");
            return false;
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n--- MENÚ ---");
        System.out.println("1. Listar empleados");
        System.out.println("2. Crear empleado normal");
        System.out.println("3. Crear atracción");
        System.out.println("4. Crear espectáculo");
        System.out.println("5. Asignar turno a empleado");
        System.out.println("6. Eliminar turno de empleado");
        System.out.println("7. Listar atracciones");
        System.out.println("8. Listar espectáculos");
        System.out.println("9. Listar empleados y turnos");
        System.out.println("10. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void listarEmpleados() {
        System.out.println("\n--- Lista de Empleados ---");
        for (EmpleadoNormal emp : gerente.getListaEmpleadosGest()) {
            System.out.println(emp.getId() + " - " + emp.getNombre() + " (" + emp.getTipo() + ")");
        }
    }

    private static void crearEmpleado() {
        EmpleadoNormal nuevo = CrearFactory.crearEmpleadoNormal(scanner);
        gerente.getListaEmpleadosGest().add(nuevo);
        System.out.println("Empleado agregado exitosamente.");
    }

    private static void crearAtraccion() {
        Atraccion nuevaAtraccion = CrearFactory.crearAtraccion(scanner);
        if (nuevaAtraccion != null) {
            System.out.println("Atracción creada: " + nuevaAtraccion.getNombre());
            gerente.getListaAtraccionesGest().add(nuevaAtraccion);
        }
    }

    private static void crearEspectaculo() {
        Espectaculo espectaculo = CrearFactory.crearEspectaculo(scanner);
        System.out.println("Espectáculo creado: " + espectaculo.getNombre());
        gerente.getListaEspectaculosGest().add(espectaculo);
    }

    private static void asignarTurno() {
        System.out.println("\n--- Asignar Turno ---");

        System.out.println("Seleccione un empleado:");
        for (int i = 0; i < gerente.getListaEmpleadosGest().size(); i++) {
            System.out.println(i + 1 + ". " + gerente.getListaEmpleadosGest().get(i).getNombre());
        }
        int empleadoIndex = scanner.nextInt() - 1;
        scanner.nextLine(); 

        if (empleadoIndex < 0 || empleadoIndex >= gerente.getListaEmpleadosGest().size()) {
            System.out.println("Empleado no válido.");
            return;
        }

        EmpleadoNormal empleadoSeleccionado = (EmpleadoNormal) gerente.getListaEmpleadosGest().get(empleadoIndex);

        System.out.println("Seleccione un turno:");
        List<Turno> turnosDisponibles = obtenerTurnosDisponibles();  
        for (int i = 0; i < turnosDisponibles.size(); i++) {
            System.out.println(i + 1 + ". " + turnosDisponibles.get(i).getTipoTurno() + " - " + turnosDisponibles.get(i).getFecha());
        }

        int turnoIndex = scanner.nextInt() - 1;
        scanner.nextLine();  

        if (turnoIndex < 0 || turnoIndex >= turnosDisponibles.size()) {
            System.out.println("Turno no válido.");
            return;
        }

        Turno turnoSeleccionado = turnosDisponibles.get(turnoIndex);
        if (!turnoSeleccionado.isAsignado()) {
            empleadoSeleccionado.getTurnosAsignados().add(turnoSeleccionado);
            turnoSeleccionado.setAsignado(true); 
            System.out.println("Turno asignado correctamente.");
        } else {
            System.out.println("El turno ya está asignado.");
        }
    }

    private static void eliminarTurno() {
        System.out.println("\n--- Eliminar Turno ---");

        
        System.out.println("Seleccione un empleado:");
        for (int i = 0; i < gerente.getListaEmpleadosGest().size(); i++) {
            System.out.println(i + 1 + ". " + gerente.getListaEmpleadosGest().get(i).getNombre());
        }
        int empleadoIndex = scanner.nextInt() - 1;
        scanner.nextLine();  

        if (empleadoIndex < 0 || empleadoIndex >= gerente.getListaEmpleadosGest().size()) {
            System.out.println("Empleado no válido.");
            return;
        }

        EmpleadoNormal empleadoSeleccionado = (EmpleadoNormal) gerente.getListaEmpleadosGest().get(empleadoIndex);

       
        System.out.println("Seleccione un turno para eliminar:");
        List<Turno> turnosAsignados = empleadoSeleccionado.getTurnosAsignados();
        for (int i = 0; i < turnosAsignados.size(); i++) {
            System.out.println(i + 1 + ". " + turnosAsignados.get(i).getTipoTurno() + " - " + turnosAsignados.get(i).getFecha());
        }

        int turnoIndex = scanner.nextInt() - 1;
        scanner.nextLine();  

        if (turnoIndex < 0 || turnoIndex >= turnosAsignados.size()) {
            System.out.println("Turno no válido.");
            return;
        }

        Turno turnoSeleccionado = turnosAsignados.get(turnoIndex);
        turnosAsignados.remove(turnoIndex);
        turnoSeleccionado.setAsignado(false);  
        System.out.println("Turno eliminado correctamente.");
    }

    
    private static List<Turno> obtenerTurnosDisponibles() {
        
        List<Turno> turnos = new ArrayList<>();
        turnos.add(new Turno(new Date(), "Mañana", null));
        turnos.add(new Turno(new Date(), "Tarde", null));
        turnos.add(new Turno(new Date(), "Noche", null));
        return turnos;
    }

    
    private static void listarAtracciones() {
        System.out.println("\n--- Lista de Atracciones ---");
        for (Atraccion atraccion : gerente.getListaAtraccionesGest()) {
            System.out.println(atraccion.getNombre() + " - " + atraccion.getExclusividad());
        }
    }

    
    private static void listarEspectaculos() {
        System.out.println("\n--- Lista de Espectáculos ---");
        for (Espectaculo espectaculo : gerente.getListaEspectaculosGest()) {
            System.out.println(espectaculo.getNombre() + " - " + espectaculo.getHorario());
        }
    }

    
    private static void listarEmpleadosYTurnos() {
        System.out.println("\n--- Lista de Empleados y sus Turnos ---");
        for (Empleado emp : gerente.getListaEmpleadosGest()) {
            EmpleadoNormal empleado = (EmpleadoNormal) emp;
            System.out.println(empleado.getNombre() + " (" + empleado.getTipo() + ")");
            List<Turno> turnosAsignados = empleado.getTurnosAsignados();
            if (turnosAsignados.isEmpty()) {
                System.out.println("   Sin turnos asignados.");
            } else {
                for (Turno turno : turnosAsignados) {
                    System.out.println("   " + turno.getTipoTurno() + " - " + turno.getFecha());
                }
            }
        }
    }





    
        





}
