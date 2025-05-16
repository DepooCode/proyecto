package pantallas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaLogin extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextField campoUsuario;
    private JPasswordField campoContrasena;
    private JButton botonIniciar;
    private JButton botonLimpiar;

    public PantallaLogin() {
        setTitle("Inicio de Sesión");
        setSize(300, 200);
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));

        
        JLabel etiquetaUsuario = new JLabel("Usuario:");
        campoUsuario = new JTextField();

        JLabel etiquetaContrasena = new JLabel("Contraseña:");
        campoContrasena = new JPasswordField();

        botonIniciar = new JButton("Iniciar sesión");
        botonLimpiar = new JButton("Limpiar");

        
        add(etiquetaUsuario);
        add(campoUsuario);
        add(etiquetaContrasena);
        add(campoContrasena);
        add(botonIniciar);
        add(botonLimpiar);

        
        botonIniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = campoUsuario.getText();
                String contrasena = new String(campoContrasena.getPassword());

                
                if (usuario.equals("gerente") && contrasena.equals("1234")) {
                    JOptionPane.showMessageDialog(null, "¡Inicio de sesión como Gerente!");
                    new VentanaGerente();
                    PantallaLogin.this.dispose();
                    
                } else if (usuario.equals("empleado") && contrasena.equals("abcd")) {
                    JOptionPane.showMessageDialog(null, "¡Inicio de sesión como Empleado!");
                    new VentanaEmpleado();
                    PantallaLogin.this.dispose();
                } else if (usuario.equals("cliente") && contrasena.equals("pass")) {
                    JOptionPane.showMessageDialog(null, "¡Inicio de sesión como Cliente!");
                    new VentanaCliente();
                    PantallaLogin.this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        
        botonLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                campoUsuario.setText("");
                campoContrasena.setText("");
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new PantallaLogin();
    }
}

