package pantallas;

import javax.swing.*;
import java.awt.*;
import parque.EmpleadoNormal;
import parque.Turno;

public class VentanaMisTurnos extends JFrame {
    
    public VentanaMisTurnos(EmpleadoNormal empleado) {
        setTitle("Mis Turnos - " + empleado.getNombre());
        setSize(400, 300);
        setLayout(new BorderLayout());
        
        JTextArea areaTurnos = new JTextArea();
        areaTurnos.setEditable(false);
        
        StringBuilder sb = new StringBuilder();
        sb.append("=== TURNOS ASIGNADOS ===\n\n");
        for (Turno turno : empleado.getTurnosAsignados()) {
            sb.append("Fecha: ").append(turno.getFecha()).append("\n");
            sb.append("Tipo: ").append(turno.getTipoTurno()).append("\n");
            sb.append("Lugar: ").append(turno.getLugarAsignado().getNombre()).append("\n\n");
        }
        
        areaTurnos.setText(sb.toString());
        add(new JScrollPane(areaTurnos), BorderLayout.CENTER);
        
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(e -> dispose());
        add(btnCerrar, BorderLayout.SOUTH);
    }
}