package pantallas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import parque.EmpleadoNormal;
import parque.Tienda;

public class VentanaVentasTienda extends JFrame {
    
    public VentanaVentasTienda(EmpleadoNormal empleado) {
        setTitle("Ventas en Tienda");
        setSize(400, 300);
        setLayout(new GridLayout(4, 2, 10, 10));
        
        Tienda tienda = new Tienda("Tienda Principal", "Venta");
        
        JLabel lblProducto = new JLabel("Producto:");
        JTextField txtProducto = new JTextField();
        JLabel lblPrecio = new JLabel("Precio:");
        JTextField txtPrecio = new JTextField();
        JButton btnVender = new JButton("Registrar Venta");
        JButton btnCerrar = new JButton("Cerrar");
        
        btnVender.addActionListener(e -> {
            try {
                String producto = txtProducto.getText();
                int precio = Integer.parseInt(txtPrecio.getText());
                tienda.venderFacturarArticulo(producto, precio);
                JOptionPane.showMessageDialog(this, "Venta registrada con éxito");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un precio válido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        btnCerrar.addActionListener(e -> dispose());
        
        add(lblProducto);
        add(txtProducto);
        add(lblPrecio);
        add(txtPrecio);
        add(btnVender);
        add(btnCerrar);
    }
}