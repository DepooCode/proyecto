package persistencia;

import java.io.*;
import java.nio.file.*;

public class ArchivoUtil {
    private static ArchivoUtil instance;
    
    private ArchivoUtil() {
    
    }
    
    public static ArchivoUtil getInstance() {
        if (instance == null) {
            instance = new ArchivoUtil();
        }
        return instance;
    }
    
    public void escribirArchivo(String ruta, String contenido) {
        try {
            
            File archivo = new File(ruta);
            File directorio = archivo.getParentFile();
            if (directorio != null && !directorio.exists()) {
                directorio.mkdirs();
            }
            
           
            try (FileWriter writer = new FileWriter(ruta);
                 BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
                bufferedWriter.write(contenido);
            }
        } catch (IOException e) {
            System.err.println("Error al escribir archivo: " + e.getMessage());
        }
    }
    
    public String leerArchivo(String ruta) {
        StringBuilder contenido = new StringBuilder();
        try (FileReader reader = new FileReader(ruta);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Error al leer archivo: " + e.getMessage());
        }
        return contenido.toString();
    }
    
    public boolean existeArchivo(String ruta) {
        File archivo = new File(ruta);
        return archivo.exists() && archivo.isFile();
    }
    
    public boolean eliminarArchivo(String ruta) {
        File archivo = new File(ruta);
        return archivo.delete();
    }
    
    public void copiarDirectorio(String origen, String destino) {
        try {
            File dirDestino = new File(destino);
            if (!dirDestino.exists()) {
                dirDestino.mkdirs();
            }
            
            File dirOrigen = new File(origen);
            if (dirOrigen.exists() && dirOrigen.isDirectory()) {
                File[] archivos = dirOrigen.listFiles();
                if (archivos != null) {
                    for (File archivo : archivos) {
                        if (archivo.isFile()) {
                            Path origenPath = archivo.toPath();
                            Path destinoPath = Paths.get(destino, archivo.getName());
                            Files.copy(origenPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error al copiar directorio: " + e.getMessage());
        }
    }
}