package parque;
import java.util.List;

public class Mecanica extends Atraccion {
    private float minAltura;
    private float maxAltura;
    private float minPeso;
    private float maxPeso;
    private List<String> restriccionesSalud;
    private String nivelRiesgo;

    public Mecanica(String nombre, String exclusividad, String ubicacion, int cupoMaximo, 
                    int numeroEncargadosMin, boolean deTemporada, List<String> restriccionesClima,
                    float minAltura, float maxAltura, float minPeso, float maxPeso, 
                    List<String> restriccionesSalud, String nivelRiesgo) {
        super(nombre, exclusividad, ubicacion, cupoMaximo, numeroEncargadosMin, deTemporada, restriccionesClima);
        this.minAltura = minAltura;
        this.maxAltura = maxAltura;
        this.minPeso = minPeso;
        this.maxPeso = maxPeso;
        this.restriccionesSalud = restriccionesSalud;
        this.nivelRiesgo = nivelRiesgo;
    }

    public float getMinAltura() {
        return minAltura;
    }

    public void setMinAltura(float minAltura) {
        this.minAltura = minAltura;
    }

    public float getMaxAltura() {
        return maxAltura;
    }

    public void setMaxAltura(float maxAltura) {
        this.maxAltura = maxAltura;
    }

    public float getMinPeso() {
        return minPeso;
    }

    public void setMinPeso(float minPeso) {
        this.minPeso = minPeso;
    }

    public float getMaxPeso() {
        return maxPeso;
    }

    public void setMaxPeso(float maxPeso) {
        this.maxPeso = maxPeso;
    }

    public List<String> getRestriccionesSalud() {
        return restriccionesSalud;
    }

    public void setRestriccionesSalud(List<String> restricciones) {
        this.restriccionesSalud = restricciones;
    }

    public String getNivelRiesgo() {
        return nivelRiesgo;
    }

    public void setNivelRiesgo(String nivelRiesgo) {
        this.nivelRiesgo = nivelRiesgo;
    }

    @Override
    public boolean revisarRegistrarTiquete(Tiquete tiquete) {
        if (this.getExclusividad().equals(tiquete.getCategoria())) {
            return true;
        }
        
        return false; 
    }
}