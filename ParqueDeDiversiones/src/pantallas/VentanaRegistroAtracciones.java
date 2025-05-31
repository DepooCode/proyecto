package pantallas;

import javax.swing.*;
import java.awt.*;
import parque.EmpleadoNormal;

public class VentanaRegistroAtracciones extends JFrame {
    public VentanaRegistroAtracciones(EmpleadoNormal empleado) {
        setTitle("Registro de Uso de Atracción");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2));

        add(new JLabel("ID Tiquete:"));
        JTextField idTiquete = new JTextField();
        add(idTiquete);

        add(new JLabel("Nombre Atracción:"));
        JTextField atraccion = new JTextField();
        add(atraccion);

        JButton registrar = new JButton("Registrar Uso");
        registrar.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Uso de atracción registrado.");
        });

        add(registrar);
    }
}
