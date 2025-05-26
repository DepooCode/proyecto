package pantallas;

import javax.swing.*;
import parque.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class VentanaListaEmpleados extends JFrame {
    public VentanaListaEmpleados(Gerente gerente) {
        setTitle("Lista de Empleados");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JTextArea areaTexto = new JTextArea();
        for (EmpleadoNormal emp : gerente.getListaEmpleadosGest()) {
            areaTexto.append(emp.getId() + " - " + emp.getNombre() + " (" + emp.getTipo() + ")\n");
        }
        add(new JScrollPane(areaTexto), BorderLayout.CENTER);

        JButton cerrar = new JButton("Cerrar");
        cerrar.addActionListener(e -> dispose());
        add(cerrar, BorderLayout.SOUTH);

        setVisible(true);
    }
}
