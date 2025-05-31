package pantallas;

import javax.swing.*;
import java.awt.*;
import parque.EmpleadoNormal;

public class VentanaFacturacionTiquetes extends JFrame {
    public VentanaFacturacionTiquetes(EmpleadoNormal empleado) {
        setTitle("Facturar Tiquetes");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2));

        add(new JLabel("Tipo de Tiquete:"));
        String[] tipos = {"Básico", "Familiar", "Oro", "Diamante"};
        JComboBox<String> tipoBox = new JComboBox<>(tipos);
        add(tipoBox);

        add(new JLabel("Precio:"));
        JTextField precio = new JTextField();
        add(precio);

        JButton facturar = new JButton("Facturar");
        facturar.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Tiquete facturado.");
        });

        add(facturar);
    }
}
