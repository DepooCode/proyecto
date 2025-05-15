package Util;

import java.util.List;
import java.util.Scanner;
import java.util.Date;
import parque.Atraccion;
import parque.Cafeteria;
import parque.CategoriaTiquete;
import parque.Cultural;
import parque.EmpleadoNormal;
import parque.LugarTrabajo;
import parque.Mecanica;
import parque.Taquilla;
import parque.Tienda;
import parque.Tiquete;

import parque.TiqueteGeneral;
import parque.Turno;

public class ConsolaEmpleado {
    private static Scanner scanner = new Scanner(System.in);
    private static EmpleadoNormal empleado;
    private static List<Tiquete> listaTiquetesDisponibles;

    public static void main(String[] args) {
        
        empleado = new EmpleadoNormal("emp01", "Empleado Ejemplo", "Cajero", 3, "empusuario", "emppass");

        
        crearTiquetesEjemplo();

        
        asignarTurnosEjemplo();

        
        if (iniciarSesion()) {
            while (true) {
                mostrarTurnos();
                int opcionTurno = scanner.nextInt();
                scanner.nextLine();  

                if (opcionTurno == 0) {
                    System.out.println("Saliendo...");
                    break;
                } else if (opcionTurno > 0 && opcionTurno <= empleado.getTurnosAsignados().size()) {
                    Turno turnoSeleccionado = empleado.getTurnosAsignados().get(opcionTurno - 1);

                    if (turnoSeleccionado.isAsignado()) {
                        realizarAccionSegunTurno(turnoSeleccionado);
                    } else {
                        System.out.println("El turno seleccionado no ha sido asignado.");
                    }
                } else {
                    System.out.println("Opción no válida.");
                }
            }
        } else {
            System.out.println("Credenciales incorrectas.");
        }
    }

    
    private static boolean iniciarSesion() {
        System.out.print("Usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Contraseña: ");
        String contrasena = scanner.nextLine();

        return empleado.iniciarSesion(usuario, contrasena);
    }

    
    private static void mostrarTurnos() {
        System.out.println("\n--- TURNOS ASIGNADOS ---");
        for (int i = 0; i < empleado.getTurnosAsignados().size(); i++) {
            Turno turno = empleado.getTurnosAsignados().get(i);
            System.out.println((i + 1) + ". Fecha: " + turno.getFecha() +
                               " | Tipo: " + turno.getTipoTurno() +
                               " | Lugar: " + turno.getLugarAsignado().getNombre());
        }
        System.out.println("0. Salir");
        System.out.print("Seleccione un turno para ver más detalles: ");
    }

    
    private static void asignarTurnosEjemplo() {
        Cafeteria cafeteria = new Cafeteria("Cafetería Central", "Comida");
        Tienda tienda = new Tienda("Tienda de Souvenirs", "Venta");
        Taquilla taquilla = new Taquilla("Taquilla Principal", "Venta");
        Cultural atraccionCultural = new Cultural("Atracción Cultural", "ORO", "Zona A", 100, 2, 
                                                  List.of("Lluvia", "Viento"), false, 12);
        Mecanica atraccionMecanica = new Mecanica("Montaña Rusa", "ORO", "Zona B", 150, 2, true, 
                                                 List.of("Sol", "Niebla"), 1.2f, 2.5f, 40, 100, 
                                                 List.of("Corazón débil"), "Alto");

        Turno turno1 = new Turno(new java.util.Date(), "Mañana", cafeteria);
        turno1.setAsignado(true);  // Asignar este turno

        Turno turno2 = new Turno(new java.util.Date(), "Tarde", tienda);
        turno2.setAsignado(true);  // Asignar este turno

        Turno turno3 = new Turno(new java.util.Date(), "Noche", taquilla);
        turno3.setAsignado(true);  // Asignar este turno

        Turno turno4 = new Turno(new java.util.Date(), "Mañana", atraccionCultural);
        turno4.setAsignado(true);  // Asignar este turno

        Turno turno5 = new Turno(new java.util.Date(), "Tarde", atraccionMecanica);
        turno5.setAsignado(true);  // Asignar este turno

        
        empleado.getTurnosAsignados().add(turno1);
        empleado.getTurnosAsignados().add(turno2);
        empleado.getTurnosAsignados().add(turno3);
        empleado.getTurnosAsignados().add(turno4);
        empleado.getTurnosAsignados().add(turno5);
    }

    
    private static void crearTiquetesEjemplo() {
        Date fechaFastPass1 = new Date(); 
        Date fechaFastPass2 = new Date();
        listaTiquetesDisponibles = List.of(
            new TiqueteGeneral("T1", CategoriaTiquete.ORO, false, fechaFastPass1),
            new TiqueteGeneral("T2", CategoriaTiquete.ORO, true, fechaFastPass2)
        );
    }

    
    private static void realizarAccionSegunTurno(Turno turno) {
        LugarTrabajo lugar = turno.getLugarAsignado();

        if (lugar instanceof Cafeteria) {
            accionCafeteria((Cafeteria) lugar);
        } else if (lugar instanceof Tienda) {
            accionTienda((Tienda) lugar);
        } else if (lugar instanceof Taquilla) {
            accionTaquilla((Taquilla) lugar);
        } else if (lugar instanceof Atraccion) {
            accionAtraccion((Atraccion) lugar);
        } else {
            System.out.println("Este lugar no tiene acciones definidas.");
        }
    }

    
    private static void accionAtraccion(Atraccion atraccion) {
        System.out.println("\n--- ACCIÓN: Revisión de Tiquetes en Atracción ---");
        System.out.println("1. Revisar tiquetes");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();  

        if (opcion == 1) {
            revisarTiquetesAtraccion(atraccion);
        } else {
            System.out.println("Opción no válida.");
        }
    }

    
    private static void revisarTiquetesAtraccion(Atraccion atraccion) {
        System.out.println("\n--- SELECCIONAR TIQUETE ---");
        for (int i = 0; i < listaTiquetesDisponibles.size(); i++) {
            Tiquete tiquete = listaTiquetesDisponibles.get(i);
            System.out.println((i + 1) + ". Tiquete: " + tiquete.getId() + " | Categoria: " + tiquete.getCategoria());
        }

        System.out.print("Seleccione el tiquete que desea revisar: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();  

        if (opcion > 0 && opcion <= listaTiquetesDisponibles.size()) {
            Tiquete tiqueteSeleccionado = listaTiquetesDisponibles.get(opcion - 1);
            
            if (atraccion.revisarRegistrarTiquete(tiqueteSeleccionado)) {
                System.out.println("Tiquete válido y registrado correctamente.");
            } else {
                System.out.println("Tiquete no válido o ya utilizado.");
            }
        } else {
            System.out.println("Opción no válida.");
        }
    }

    
   

   
    
    private static void verTiquetesFacturados(Taquilla taquilla) {
        System.out.println("\n--- Tiquetes Facturados ---");
        taquilla.getMapaTiquetes().forEach((id, precio) -> {
            System.out.println("ID: " + id + " | Precio: " + precio);
        });
    }
    private static void accionTaquilla(Taquilla taquilla) {
        System.out.println("\n--- ACCIÓN: Facturación de Tiquetes ---");
        System.out.println("1. Facturar tiquete");
        System.out.println("2. Ver tiquetes facturados");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();  
    
        switch (opcion) {
            case 1:
                facturarTiquete(taquilla);
                break;
            case 2:
                verTiquetesFacturados(taquilla);
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }
    
    
    private static void facturarTiquete(Taquilla taquilla) {
        System.out.println("\n--- SELECCIONAR TIQUETE ---");
        for (int i = 0; i < listaTiquetesDisponibles.size(); i++) {
            Tiquete tiquete = listaTiquetesDisponibles.get(i);
            System.out.println((i + 1) + ". Tiquete: " + tiquete.getId() + " | Categoria: " + tiquete.getCategoria());
        }
        System.out.print("Seleccione el tiquete que desea facturar: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();  
    
        if (opcion > 0 && opcion <= listaTiquetesDisponibles.size()) {
            Tiquete tiqueteSeleccionado = listaTiquetesDisponibles.get(opcion - 1);
    
            if (!tiqueteSeleccionado.isUtilizado()) {
                System.out.print("Ingrese el precio del tiquete: ");
                int precio = scanner.nextInt();
                scanner.nextLine();  
    
                taquilla.venderFacturarTiquete(tiqueteSeleccionado, precio);
                System.out.println("Tiquete facturado con éxito.");
            } else {
                System.out.println("Este tiquete no es válido para facturación.");
            }
        } else {
            System.out.println("Opción no válida.");
        }
    }
    
    
    
    
    
    private static void accionTienda(Tienda tienda) {
        System.out.println("\n--- ACCIÓN: Venta de productos en la tienda ---");
        System.out.println("1. Vender producto");
        System.out.println("2. Ver productos vendidos");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();  // Limpiar buffer
    
        switch (opcion) {
            case 1:
                venderProducto(tienda);
                break;
            case 2:
                verProductosVendidos(tienda);
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }
    
    
    private static void venderProducto(Tienda tienda) {
        System.out.println("\n--- SELECCIONAR PRODUCTO ---");
        
        System.out.println("1. Camiseta de Parque");
        System.out.println("2. Taza con logo");
        System.out.print("Seleccione el producto que desea vender: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();  
    
        if (opcion == 1 || opcion == 2) {
            System.out.print("Ingrese el precio del producto: ");
            int precio = scanner.nextInt();
            scanner.nextLine();  
    
            
            tienda.venderFacturarArticulo("Producto " + opcion, precio);
            System.out.println("Producto vendido con éxito.");
        } else {
            System.out.println("Opción no válida.");
        }
    }
    
    
    private static void verProductosVendidos(Tienda tienda) {
        System.out.println("\n--- Productos Vendidos ---");
        tienda.getArticulosFacturadosVendidos().forEach((precio, producto) -> {
            System.out.println("Producto: " + producto + " | Precio: " + precio);
        });
    }
    private static void accionCafeteria(Cafeteria cafeteria) {
        System.out.println("\n--- ACCIÓN: Venta de comida en la cafetería ---");
        System.out.println("1. Vender comida");
        System.out.println("2. Ver comida vendida");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();  
    
        switch (opcion) {
            case 1:
                venderComida(cafeteria);
                break;
            case 2:
                verComidaVendida(cafeteria);
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }
    
    
    private static void venderComida(Cafeteria cafeteria) {
        System.out.println("\n--- SELECCIONAR COMIDA ---");
        
        System.out.println("1. Hamburguesa");
        System.out.println("2. Pizza");
        System.out.println("3. Ensalada");
        System.out.print("Seleccione el producto que desea vender: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();  
        if (opcion == 1 || opcion == 2 || opcion == 3) {
            System.out.print("Ingrese el precio de la comida: ");
            int precio = scanner.nextInt();
            scanner.nextLine();  
    
            
            String nombreComida = opcion == 1 ? "Hamburguesa" : (opcion == 2 ? "Pizza" : "Ensalada");
            cafeteria.venderFacturarComida(nombreComida, precio);
            System.out.println("Comida vendida con éxito.");
        } else {
            System.out.println("Opción no válida.");
        }
    }
    
    
    private static void verComidaVendida(Cafeteria cafeteria) {
        System.out.println("\n--- Comida Vendida ---");
        cafeteria.getComidaFacturadaVendida().forEach((precio, comida) -> {
            System.out.println("Comida: " + comida + " | Precio: " + precio);
        });
    }
    
}
