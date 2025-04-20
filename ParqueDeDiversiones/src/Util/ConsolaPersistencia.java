package Util;

import persistencia.GestorPersistencia;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ConsolaPersistencia {
    private GestorPersistencia gestor;
    private Scanner scanner;
    
    public ConsolaPersistencia() {
        this.gestor = GestorPersistencia.getInstance();
        this.scanner = new Scanner(System.in);
    }
    
    public void iniciar() {
        boolean salir = false;
        
        while (!salir) {
            mostrarMenu();
            int opcion = leerOpcion();
            
            switch (opcion) {
                case 1:
                    cargarEntidad();
                    break;
                case 2:
                    cargarTodasEntidades();
                    break;
                case 3:
                    eliminarEntidad();
                    break;
                case 4:
                    hacerBackup();
                    break;
                case 5:
                    restaurarBackup();
                    break;
                case 6:
                    verificarDatos();
                    break;
                case 0:
                    salir = true;
                    System.out.println("Saliendo de la consola de persistencia...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
            
            esperarEnter();
        }
        
        scanner.close();
    }
    
    private void mostrarMenu() {
        System.out.println("\n===== CONSOLA DE PERSISTENCIA =====");
        System.out.println("1. Cargar entidad específica");
        System.out.println("2. Cargar todas las entidades de un tipo");
        System.out.println("3. Eliminar entidad");
        System.out.println("4. Crear backup");
        System.out.println("5. Restaurar desde backup");
        System.out.println("6. Verificar existencia de datos");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }
    
    private int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    private void cargarEntidad() {
        System.out.print("Ingrese el tipo de entidad (Parque, Empleado, Atraccion, etc.): ");
        String tipo = scanner.nextLine();
        
        System.out.print("Ingrese el ID de la entidad: ");
        String id = scanner.nextLine();
        
        Object entidad = gestor.cargarEntidad(tipo, id);
        if (entidad != null) {
            System.out.println("Entidad cargada: " + entidad);
        } else {
            System.out.println("No se pudo cargar la entidad.");
        }
    }
    
    private void cargarTodasEntidades() {
        System.out.print("Ingrese el tipo de entidad (Parque, Empleado, Atraccion, etc.): ");
        String tipo = scanner.nextLine();
        
        List<Object> entidades = gestor.cargarTodas(tipo);
        if (!entidades.isEmpty()) {
            System.out.println("Se cargaron " + entidades.size() + " entidades:");
            for (Object entidad : entidades) {
                System.out.println("- " + entidad);
            }
        } else {
            System.out.println("No se encontraron entidades del tipo: " + tipo);
        }
    }
    
    private void eliminarEntidad() {
        System.out.print("Ingrese el tipo de entidad a eliminar: ");
        String tipo = scanner.nextLine();
        
        System.out.print("Ingrese el ID de la entidad a eliminar: ");
        String id = scanner.nextLine();
        
        System.out.print("¿Está seguro de eliminar esta entidad? (s/n): ");
        String confirmacion = scanner.nextLine();
        
        if (confirmacion.equalsIgnoreCase("s")) {
            gestor.eliminarEntidad(tipo, id);
        } else {
            System.out.println("Operación cancelada.");
        }
    }
    
    private void hacerBackup() {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String rutaBackup = "backups/backup_" + timestamp + "/";
        
        System.out.println("Creando backup en: " + rutaBackup);
        gestor.hacerBackup(rutaBackup);
    }
    
    private void restaurarBackup() {
        System.out.println("Backups disponibles:");
        File dirBackups = new File("backups/");
        
        if (dirBackups.exists() && dirBackups.isDirectory()) {
            File[] backups = dirBackups.listFiles();
            if (backups != null && backups.length > 0) {
                for (int i = 0; i < backups.length; i++) {
                    if (backups[i].isDirectory()) {
                        System.out.println((i+1) + ". " + backups[i].getName());
                    }
                }
                
                System.out.print("Seleccione el número del backup a restaurar (0 para cancelar): ");
                try {
                    int seleccion = Integer.parseInt(scanner.nextLine());
                    if (seleccion > 0 && seleccion <= backups.length) {
                        System.out.print("¿Está seguro de restaurar? Se perderán los datos actuales (s/n): ");
                        String confirmacion = scanner.nextLine();
                        
                        if (confirmacion.equalsIgnoreCase("s")) {
                            gestor.restaurarBackup("backups/" + backups[seleccion-1].getName() + "/");
                        } else {
                            System.out.println("Restauración cancelada.");
                        }
                    } else if (seleccion != 0) {
                        System.out.println("Selección inválida.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida.");
                }
            } else {
                System.out.println("No hay backups disponibles.");
            }
        } else {
            System.out.println("Directorio de backups no encontrado.");
        }
    }
    
    private void verificarDatos() {
        boolean existenDatos = gestor.existenDatos();
        if (existenDatos) {
            System.out.println("El sistema contiene datos persistentes.");
        } else {
            System.out.println("No se encontraron datos persistentes en el sistema.");
        }
    }
    
    private void esperarEnter() {
        System.out.println("\nPresione Enter para continuar...");
        scanner.nextLine();
    }
    
    public static void main(String[] args) {
        ConsolaPersistencia consola = new ConsolaPersistencia();
        consola.iniciar();
    }
}