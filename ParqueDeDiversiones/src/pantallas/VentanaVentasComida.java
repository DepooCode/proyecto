package pantallas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import parque.EmpleadoNormal;
import parque.Cafeteria;

public class VentanaVentasComida extends JFrame {
    
    public VentanaVentasComida(EmpleadoNormal empleado) {
        setTitle("Ventas en Cafetería");
        setSize(400, 300);
        setLayout(new GridLayout(4, 2, 10, 10));
        
        Cafeteria cafeteria = new Cafeteria("Cafetería Central", "Comida");
        
        JLabel lblComida = new JLabel("Comida:");
        JTextField txtComida = new JTextField();
        JLabel lblPrecio = new JLabel("Precio:");
        JTextField txtPrecio = new JTextField();
        JButton btnVender = new JButton("Registrar Venta");
        JButton btnCerrar = new JButton("Cerrar");
        
        btnVender.addActionListener(e -> {
            try {
                String comida = txtComida.getText();
                int precio = Integer.parseInt(txtPrecio.getText());
                cafeteria.venderFacturarComida(comida, precio);
                JOptionPane.showMessageDialog(this, "Venta registrada con éxito");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un precio válido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        btnCerrar.addActionListener(e -> dispose());
        
        add(lblComida);
        add(txtComida);
        add(lblPrecio);
        add(txtPrecio);
        add(btnVender);
        add(btnCerrar);
    }
}