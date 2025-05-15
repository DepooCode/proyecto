package parque;

import persistencia.Persistable;
import java.util.Date;

public class TiqueteGeneral extends Tiquete implements Persistable {

    public TiqueteGeneral(String id, CategoriaTiquete categoria, boolean fastPass, Date fechaFastPass) {
        super(id, categoria, fastPass, fechaFastPass);
    }

    @Override
    public boolean esValido(Date fechaUso) {
        return !utilizado;
    }

    // Persistable
    @Override
    public String getTipoEntidad() {
        return "TiqueteGeneral";
    }

    @Override
    public String toString() {
        return "Tiquete General: " + id + " | Categoría: " + categoria + " | FastPass: " + fastPass;
    }
}
