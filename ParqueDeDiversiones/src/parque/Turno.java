package parque;

import java.util.Date;



public class Turno {
    private Date fecha;
    private String tipoTurno;
    private LugarTrabajo lugarAsignado;
    private boolean asignado;  

    public Turno(Date fecha, String tipoTurno, LugarTrabajo lugar) {
        this.fecha = fecha;
        this.tipoTurno = tipoTurno;
        this.lugarAsignado = lugar;
        this.asignado = false; 
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipoTurno() {
        return tipoTurno;
    }

    public void setTipoTurno(String tipoTurno) {
        this.tipoTurno = tipoTurno;
    }

    public LugarTrabajo getLugarAsignado() {
        return lugarAsignado;
    }

    public void setLugarAsignado(LugarTrabajo lugarAsignado) {
        this.lugarAsignado = lugarAsignado;
    }

    public boolean isAsignado() {  
        return asignado;
    }

    public void setAsignado(boolean asignado) {  
        this.asignado = asignado;
    }
}
