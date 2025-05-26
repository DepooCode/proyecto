package pantallas;
import javax.swing.*;
import parque.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class VentanaListaEmpleadosYTurnos extends JFrame {
    public VentanaListaEmpleadosYTurnos(Gerente gerente) {
        setTitle("Empleados y Turnos");
        setSize(500, 400);
        setLocationRelativeTo(null);

        JTextArea areaTexto = new JTextArea();
        for (Empleado emp : gerente.getListaEmpleadosGest()) {
            EmpleadoNormal e = (EmpleadoNormal) emp;
            areaTexto.append(e.getNombre() + " (" + e.getTipo() + ")\n");
            if (e.getTurnosAsignados().isEmpty()) {
                areaTexto.append("   Sin turnos asignados\n");
            } else {
                for (Turno t : e.getTurnosAsignados()) {
                    areaTexto.append("   " + t.getTipoTurno() + " - " + t.getFecha() + "\n");
                }
            }
        }

        add(new JScrollPane(areaTexto));
        JButton cerrar = new JButton("Cerrar");
        cerrar.addActionListener(e -> dispose());
        add(cerrar, BorderLayout.SOUTH);
        setVisible(true);
    }
}
