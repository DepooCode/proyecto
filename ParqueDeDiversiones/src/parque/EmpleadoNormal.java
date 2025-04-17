package parque;
import java.util.List;
import java.util.ArrayList;
public class EmpleadoNormal extends Empleado {

    private String tipo;
    private int experiencia;
    public List<Turno> turnosAsignados;

    public EmpleadoNormal(String id, String nombre, String tipo, int experiencia) {
        super(id, nombre);
        this.tipo = tipo;
        this.experiencia = experiencia;
        this.turnosAsignados = new ArrayList<Turno>();
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }
    public List<Turno> getTurnosAsignados() {
        return turnosAsignados;
    }
}