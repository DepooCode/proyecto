package parque;

import java.util.Date;

public abstract class Tiquete {
    protected String id;
    protected CategoriaTiquete categoria;
    protected boolean utilizado;
    protected Date fechaFastPass;
    protected boolean fastPass;
    protected boolean impreso = false; 
    
    public Tiquete(String id, CategoriaTiquete categoria, boolean fastPass, Date fechaFastPass) {
        this.id = id;
        this.categoria = categoria;
        this.fastPass = fastPass;
        this.fechaFastPass = fechaFastPass;
    }

  
    public String getId() {
        return id;
    }

    public String getCategoria() {
        return categoria.toString();
    }

    public Date getFechaFastPass() {
        return fechaFastPass;
    }

    public boolean isFastPass() {
        return fastPass;
    }

    public boolean isUtilizado() {
        return utilizado;
    }

    public void usarTiquete() {
        this.utilizado = true;
    }

   
    public boolean isImpreso() {
        return impreso;
    }

    public void setImpreso(boolean impreso) {
        this.impreso = impreso;
    }

    public abstract boolean esValido(Date fechaUso);
}


}

