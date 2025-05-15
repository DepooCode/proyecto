package Util;

import java.time.LocalTime;
import java.util.*;

import parque.Atraccion;
import parque.Cultural;
import parque.EmpleadoNormal;
import parque.Espectaculo;
import parque.Mecanica;

public class CrearFactory {

    public static Atraccion crearAtraccion(Scanner scanner) {
        System.out.println("Seleccione el tipo de atracción:");
        System.out.println("1. Mecánica");
        System.out.println("2. Cultural");
        int tipo = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Exclusividad: ");
        String exclusividad = scanner.nextLine();

        System.out.print("Ubicación: ");
        String ubicacion = scanner.nextLine();

        System.out.print("Cupo máximo: ");
        int cupo = scanner.nextInt();

        System.out.print("Encargados mínimos: ");
        int encargados = scanner.nextInt();

        System.out.print("¿Es de temporada? (true/false): ");
        boolean temporada = scanner.nextBoolean();
        scanner.nextLine();

        System.out.print("Restricciones por clima (coma separadas): ");
        List<String> restriccionesClima = List.of(scanner.nextLine().split("\\s*,\\s*"));

        if (tipo == 1) {
            
            System.out.print("Altura mínima: ");
            float minAltura = scanner.nextFloat();
            System.out.print("Altura máxima: ");
            float maxAltura = scanner.nextFloat();

            System.out.print("Peso mínimo: ");
            float minPeso = scanner.nextFloat();
            System.out.print("Peso máximo: ");
            float maxPeso = scanner.nextFloat();
            scanner.nextLine(); 

            System.out.print("Restricciones de salud (coma separadas): ");
            List<String> restriccionesSalud = List.of(scanner.nextLine().split("\\s*,\\s*"));

            System.out.print("Nivel de riesgo (bajo/medio/alto): ");
            String nivelRiesgo = scanner.nextLine();

            return new Mecanica(nombre, exclusividad, ubicacion, cupo, encargados, temporada,
                                restriccionesClima, minAltura, maxAltura, minPeso, maxPeso,
                                restriccionesSalud, nivelRiesgo);

        } else if (tipo == 2) {
            
            System.out.print("Edad mínima: ");
            int minEdad = scanner.nextInt();
            scanner.nextLine(); 

            return new Cultural(nombre, exclusividad, ubicacion, cupo, encargados, restriccionesClima, temporada, minEdad);

        } else {
            System.out.println("Tipo no válido. Se canceló la creación.");
            return null;
        }
    }

    public static Espectaculo crearEspectaculo(Scanner scanner) {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Horario (HH:mm): ");
        LocalTime horario = LocalTime.parse(scanner.nextLine());

        System.out.print("Fecha (yyyy-MM-dd): ");
        Date fecha = java.sql.Date.valueOf(scanner.nextLine());

        System.out.print("Restricciones por clima (coma separadas): ");
        List<String> restricciones = List.of(scanner.nextLine().split("\\s*,\\s*"));

        System.out.print("¿Es de temporada? (true/false): ");
        boolean temporada = scanner.nextBoolean();
        scanner.nextLine(); 

        return new Espectaculo(nombre, horario, fecha, restricciones, temporada);
    }

    public static EmpleadoNormal crearEmpleadoNormal(Scanner scanner) {
        System.out.print("ID del empleado: ");
        String id = scanner.nextLine();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Tipo: ");
        String tipo = scanner.nextLine();

        System.out.print("Experiencia: ");
        int experiencia = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Usuario: ");
        String usuario = scanner.nextLine();

        System.out.print("Contraseña: ");
        String contrasenia = scanner.nextLine();

        return new EmpleadoNormal(id, nombre, tipo, experiencia, usuario, contrasenia);
    }
}


