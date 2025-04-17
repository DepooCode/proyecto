package parque;

import java.util.Date;




public class TiqueteGeneral extends Tiquete {
    
    public TiqueteGeneral(String id, CategoriaTiquete categoria, boolean fastPass, Date fechaFastPass) {
        super(id, categoria, fastPass, fechaFastPass);
    }
    @Override
    public boolean esValido(Date fechaUso) {
        return !utilizado; // solo se puede usar una vez
    }
    

}
