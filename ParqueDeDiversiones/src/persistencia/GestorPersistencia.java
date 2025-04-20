package persistencia;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GestorPersistencia {
    private String rutaDirectorio;
    private static GestorPersistencia instance;
    private JsonAdapter jsonAdapter;
    private ArchivoUtil archivoUtil;
    
    private GestorPersistencia(String rutaDirectorio) {
        this.rutaDirectorio = rutaDirectorio;
        this.jsonAdapter = JsonAdapter.getInstance();
        this.archivoUtil = ArchivoUtil.getInstance();
        
        // Crear directorio si no existe
        File directorio = new File(rutaDirectorio);
        if (!directorio.exists()) {
            directorio.mkdirs();
        }
    }
    
    public static GestorPersistencia getInstance() {
        if (instance == null) {
            instance = new GestorPersistencia("data/");
        }
        return instance;
    }
    
    public void guardarEntidad(Object entidad) {
        if (!(entidad instanceof Persistable)) {
            throw new IllegalArgumentException("La entidad debe implementar Persistable");
        }
        
        Persistable persistable = (Persistable) entidad;
        String tipo = persistable.getTipoEntidad();
        String id = persistable.getId();
        String json = jsonAdapter.objectToJson(entidad);
        
        String ruta = construirRutaArchivo(tipo, id);
        archivoUtil.escribirArchivo(ruta, json);
        System.out.println("Entidad guardada: " + tipo + " con ID: " + id);
    }
    
    public Object cargarEntidad(String tipo, String id) {
        String ruta = construirRutaArchivo(tipo, id);
        if (!archivoUtil.existeArchivo(ruta)) {
            System.out.println("No existe entidad de tipo " + tipo + " con ID: " + id);
            return null;
        }
        
        String json = archivoUtil.leerArchivo(ruta);
        try {
            Class<?> clase = obtenerClase(tipo);
            return jsonAdapter.jsonToObject(json, clase);
        } catch (ClassNotFoundException e) {
            System.err.println("Error al cargar entidad: " + e.getMessage());
            return null;
        }
    }
    
    public List<Object> cargarTodas(String tipo) {
        List<Object> resultado = new ArrayList<>();
        File directorio = new File(rutaDirectorio);
        String prefijo = tipo + "_";
        String sufijo = ".json";
        
        if (directorio.exists() && directorio.isDirectory()) {
            File[] archivos = directorio.listFiles();
            if (archivos != null) {
                for (File archivo : archivos) {
                    String nombreArchivo = archivo.getName();
                    if (nombreArchivo.startsWith(prefijo) && nombreArchivo.endsWith(sufijo)) {
                        String id = nombreArchivo.substring(prefijo.length(), nombreArchivo.length() - sufijo.length());
                        Object entidad = cargarEntidad(tipo, id);
                        if (entidad != null) {
                            resultado.add(entidad);
                        }
                    }
                }
            }
        }
        
        System.out.println("Cargadas " + resultado.size() + " entidades de tipo: " + tipo);
        return resultado;
    }
    
    public void eliminarEntidad(String tipo, String id) {
        String ruta = construirRutaArchivo(tipo, id);
        if (archivoUtil.existeArchivo(ruta)) {
            archivoUtil.eliminarArchivo(ruta);
            System.out.println("Entidad eliminada: " + tipo + " con ID: " + id);
        } else {
            System.out.println("No existe entidad para eliminar de tipo " + tipo + " con ID: " + id);
        }
    }
    
    private String construirRutaArchivo(String tipo, String id) {
        return rutaDirectorio + tipo + "_" + id + ".json";
    }
    
    private Class<?> obtenerClase(String tipo) throws ClassNotFoundException {
        // Mapeo de nombres de tipos a clases concretas
        switch (tipo) {
            case "Parque":
                return Class.forName("parque.Parque");
            case "Empleado":
                return Class.forName("parque.Empleado");
            case "EmpleadoNormal":
                return Class.forName("parque.EmpleadoNormal");
            case "Gerente":
                return Class.forName("parque.Gerente");
            case "Atraccion":
                return Class.forName("parque.Atraccion");
            case "Mecanica":
                return Class.forName("parque.Mecanica");
            case "Cultural":
                return Class.forName("parque.Cultural");
            case "Espectaculo":
                return Class.forName("parque.Espectaculo");
            case "Tiquete":
                return Class.forName("parque.Tiquete");
            case "TiqueteGeneral":
                return Class.forName("parque.TiqueteGeneral");
            case "TiqueteTemporada":
                return Class.forName("parque.TiqueteTemporada");
            case "TiqueteEntradaIndividual":
                return Class.forName("parque.TiqueteEntradaIndividual");
            case "Turno":
                return Class.forName("parque.Turno");
            case "Cafeteria":
                return Class.forName("parque.Cafeteria");
            case "Cliente":
                return Class.forName("parque.Cliente");
            case "LugarTrabajo":
                return Class.forName("parque.LugarTrabajo");
            case "Servicio":
                return Class.forName("parque.Servicio");
            case "ServicioGeneral":
                return Class.forName("parque.ServicioGeneral");
            case "Taquilla":
                return Class.forName("parque.Taquilla");
            case "Tienda":
                return Class.forName("parque.Tienda");
            case "CategoriaTiquete":
                return Class.forName("parque.CategoriaTiquete");
            default:
                throw new ClassNotFoundException("No se reconoce el tipo de entidad: " + tipo);
        }
    }
    
    public void hacerBackup(String rutaBackup) {
        archivoUtil.copiarDirectorio(rutaDirectorio, rutaBackup);
        System.out.println("Backup realizado en: " + rutaBackup);
    }
    
    public void restaurarBackup(String rutaBackup) {
        archivoUtil.copiarDirectorio(rutaBackup, rutaDirectorio);
        System.out.println("Sistema restaurado desde: " + rutaBackup);
    }
    
    public boolean existenDatos() {
        File directorio = new File(rutaDirectorio);
        if (directorio.exists() && directorio.isDirectory()) {
            File[] archivos = directorio.listFiles();
            return archivos != null && archivos.length > 0;
        }
        return false;
    }
}