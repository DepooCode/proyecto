package parque;

import java.util.Date;

public abstract class Tiquete {
    protected String id;
    protected CategoriaTiquete categoria;
    protected boolean utilizado;
    protected Date fechaFastPass;
    protected boolean fastPass;

    // Constructor
    public Tiquete(String id, CategoriaTiquete categoria, boolean fastPass, Date fechaFastPass) {
        this.id = id;
        this.categoria = categoria;
        this.fastPass = fastPass;
        this.fechaFastPass = fechaFastPass;
    }

    // Métodos getter y setter
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

   
}

