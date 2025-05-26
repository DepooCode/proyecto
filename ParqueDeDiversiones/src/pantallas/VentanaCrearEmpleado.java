package pantallas;

import javax.swing.*;

import parque.EmpleadoNormal;
import parque.Gerente;

import java.awt.*;
import java.awt.event.*;


public class VentanaCrearEmpleado extends JFrame {

    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtTipo;
    private JTextField txtExperiencia;
    private JTextField txtUsuario;
    private JPasswordField txtContrasenia;

    public VentanaCrearEmpleado(Gerente gerente) {
        setTitle("Crear Empleado");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(7, 2, 10, 10));

        txtId = new JTextField();
        txtNombre = new JTextField();
        txtTipo = new JTextField();
        txtExperiencia = new JTextField();
        txtUsuario = new JTextField();
        txtContrasenia = new JPasswordField();

        add(new JLabel("ID:"));
        add(txtId);
        add(new JLabel("Nombre:"));
        add(txtNombre);
        add(new JLabel("Tipo:"));
        add(txtTipo);
        add(new JLabel("Experiencia:"));
        add(txtExperiencia);
        add(new JLabel("Usuario:"));
        add(txtUsuario);
        add(new JLabel("Contraseña:"));
        add(txtContrasenia);

        JButton btnCrear = new JButton("Crear");
        btnCrear.addActionListener(e -> {
            try {
                String id = txtId.getText();
                String nombre = txtNombre.getText();
                String tipo = txtTipo.getText();
                int experiencia = Integer.parseInt(txtExperiencia.getText());
                String usuario = txtUsuario.getText();
                String contrasenia = new String(txtContrasenia.getPassword());

                EmpleadoNormal nuevo = new EmpleadoNormal(id, nombre, tipo, experiencia, usuario, contrasenia);
                gerente.agregarEmpleado(nuevo);

                JOptionPane.showMessageDialog(this, "Empleado creado y agregado al sistema.");
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        add(new JLabel()); 
        add(btnCrear);
    }
}
