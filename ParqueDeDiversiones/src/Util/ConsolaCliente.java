package Util;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import parque.Atraccion;
import parque.CategoriaTiquete;
import parque.Cliente;

import parque.Mecanica;
import parque.Tiquete;
import parque.TiqueteEntradaIndividual;
import parque.TiqueteGeneral;
import parque.TiqueteTemporada;

public class ConsolaCliente {
    private static Scanner scanner = new Scanner(System.in);
    private static Cliente cliente;
    
    public static void main(String[] args) {
        cliente = new Cliente("cliente1", "contrasena123", true);

        while (true) {
            if (cliente.isIniciado()) { 
                mostrarMenu();
                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        comprarTiquete();
                        break;
                    case 2:
                        verTiquetesComprados();
                        break;
                    case 3:
                        usarTiquete();
                        break;
                    case 4:
                        cerrarSesion();
                        break;
                    case 5:
                        System.out.println("Saliendo...");
                        return;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            } else {
                System.out.println("Por favor, inicie sesión.");
                if (iniciarSesion()) {
                    System.out.println("Inicio de sesión exitoso.");
                }
            }
        }
    }

    
    private static boolean iniciarSesion() {
        System.out.print("Usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Contraseña: ");
        String contrasena = scanner.nextLine();

        return cliente.iniciarSesion(usuario, contrasena);
    }

    
    private static void cerrarSesion() {
        cliente.cerrarSesion();
        System.out.println("Sesión cerrada con éxito.");
    }

    
    private static void mostrarMenu() {
        System.out.println("\n--- MENÚ CLIENTE ---");
        System.out.println("1. Comprar tiquete");
        System.out.println("2. Ver tiquetes comprados");
        System.out.println("3. Usar tiquete");
        System.out.println("4. Cerrar sesión");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    
    private static void comprarTiquete() {
        System.out.println("\n--- Comprar Tiquete ---");

        System.out.println("Seleccione el tipo de tiquete que desea comprar:");
        System.out.println("1. Tiquete Individual para Atracción");
        System.out.println("2. Tiquete General");
        System.out.println("3. Tiquete de Temporada");
        System.out.print("Seleccione una opción: ");
        int opcionTiquete = scanner.nextInt();
        scanner.nextLine();  

        Tiquete tiquete = null;
        switch (opcionTiquete) {
            case 1:
                comprarTiqueteIndividual();
                return;  
            case 2:
                tiquete = comprarTiqueteGeneral();
                break;
            case 3:
                tiquete = comprarTiqueteTemporada();
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }

        if (tiquete != null) {
            cliente.comprarTiquete(tiquete);
            System.out.println("Tiquete comprado exitosamente.");
        }
    }

    
    private static void comprarTiqueteIndividual() {
        System.out.println("\n--- Comprar Tiquete Individual ---");

        
        System.out.println("Seleccione una atracción para comprar el tiquete:");
        System.out.println("1. Montaña Rusa");
        System.out.println("2. Casa del Terror");
        System.out.println("3. Tren Fantasma");
        System.out.print("Seleccione una opción: ");
        int opcionAtraccion = scanner.nextInt();
        scanner.nextLine();  

        Atraccion atraccionSeleccionada = null;
        switch (opcionAtraccion) {
            case 1:
                atraccionSeleccionada = new Mecanica("Montaña Rusa", "ORO", "Zona D", 20, 3, true, new ArrayList<>(),
                1.20f, 2.00f, 40f, 120f, new ArrayList<>(), "Alto");
                break;
            case 2:
                atraccionSeleccionada = new Mecanica("Casa del Terror", "ORO", "Zona D", 20, 3, true, new ArrayList<>(),
                1.20f, 2.00f, 40f, 120f, new ArrayList<>(), "Alto");
                break;
            case 3:
                atraccionSeleccionada = new Mecanica("Tren Fantasma", "ORO", "Zona D", 20, 3, true, new ArrayList<>(),
                1.20f, 2.00f, 40f, 120f, new ArrayList<>(), "Alto");
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }

        
        String idTiquete = "T-" + System.currentTimeMillis();  
        String categoriaStr = atraccionSeleccionada.getExclusividad();  
        boolean fastPass = cliente.isTieneDescuento();  
        Date fechaFastPass = fastPass ? new Date(System.currentTimeMillis()) : null;
        CategoriaTiquete categoria = CategoriaTiquete.valueOf(categoriaStr);
        Tiquete tiquete = new TiqueteEntradaIndividual(idTiquete, categoria, fastPass, fechaFastPass, atraccionSeleccionada);
        cliente.comprarTiquete(tiquete);
        System.out.println("Tiquete comprado exitosamente para: " + atraccionSeleccionada.getNombre());
    }

    
    private static Tiquete comprarTiqueteGeneral() {
        System.out.println("\n--- Comprar Tiquete General ---");

        
        String idTiquete = "T-" + System.currentTimeMillis();  

        
        System.out.print("Ingrese la categoría del tiquete (por ejemplo: ORO, PLATA): ");
        String categoriaStr = scanner.nextLine();

        System.out.print("¿Desea un FastPass? (true/false): ");
        boolean fastPass = scanner.nextBoolean();
        scanner.nextLine();  

        Date fechaFastPass = fastPass ? new Date(System.currentTimeMillis()) : null;
        CategoriaTiquete categoria = CategoriaTiquete.valueOf(categoriaStr.toUpperCase());  

        return new TiqueteGeneral(idTiquete, categoria, fastPass, fechaFastPass);
    }

    
    private static Tiquete comprarTiqueteTemporada() {
        System.out.println("\n--- Comprar Tiquete de Temporada ---");

        
        String idTiquete = "T-" + System.currentTimeMillis();  

        
        System.out.print("Ingrese la categoría del tiquete (por ejemplo: ORO, PLATA): ");
        String categoriaStr = scanner.nextLine();

        System.out.print("¿Desea un FastPass? (true/false): ");
        boolean fastPass = scanner.nextBoolean();
        scanner.nextLine();  

        System.out.print("Ingrese la fecha de fin de la temporada (yyyy-MM-dd): ");
        String fechaFinStr = scanner.nextLine();
        Date fechaFin = Date.valueOf(fechaFinStr);

        Date fechaFastPass = fastPass ? new Date(System.currentTimeMillis()) : null;
        CategoriaTiquete categoria = CategoriaTiquete.valueOf(categoriaStr.toUpperCase());  

        return new TiqueteTemporada(idTiquete, categoria, fastPass, fechaFastPass, fechaFin);
    }

    
    private static void verTiquetesComprados() {
        System.out.println("\n--- Tiquetes Comprados ---");
        List<Tiquete> tiquetes = cliente.getListaTiquetesComprados();
        if (tiquetes.isEmpty()) {
            System.out.println("No tienes tiquetes comprados.");
        } else {
            for (Tiquete tiquete : tiquetes) {
                System.out.println("ID: " + tiquete.getId() + " | Utilizado: " + tiquete.isUtilizado());
            }
        }
    }

    
    private static void usarTiquete() {
        System.out.println("\n--- Usar Tiquete ---");
        List<Tiquete> tiquetes = cliente.getListaTiquetesComprados();
        if (tiquetes.isEmpty()) {
            System.out.println("No tienes tiquetes para usar.");
            return;
        }

        System.out.println("Seleccione un tiquete para usar:");
        for (int i = 0; i < tiquetes.size(); i++) {
            System.out.println(i + 1 + ". Tiquete ID: " + tiquetes.get(i).getId() + " | Utilizado: " + tiquetes.get(i).isUtilizado());
        }
        int opcionTiquete = scanner.nextInt() - 1;
        scanner.nextLine();  

        if (opcionTiquete >= 0 && opcionTiquete < tiquetes.size()) {
            Tiquete tiqueteSeleccionado = tiquetes.get(opcionTiquete);
            cliente.usarTiquete(tiqueteSeleccionado);
        } else {
            System.out.println("Opción no válida.");
        }
    }
    
}
