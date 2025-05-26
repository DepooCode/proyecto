package pantallas;

import javax.swing.*;
import parque.Cliente;
import parque.EmpleadoNormal;
import parque.Gerente;
import parque.Usuario;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PantallaLogin extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextField campoUsuario;
    private JPasswordField campoContrasena;
    private JButton botonIniciar;
    private JButton botonLimpiar;
    private ArrayList<Usuario> listaUsuarios;

    public PantallaLogin() {
        setTitle("Inicio de Sesión");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));

        listaUsuarios = new ArrayList<>();

        listaUsuarios.add(new Cliente("cliente", "pass", true));
        listaUsuarios.add(new EmpleadoNormal("emp01", "Empleado Ejemplo", "Cajero", 3, "empleado", "abcd"));
        listaUsuarios.add(new Gerente("1", "Juan", "gerente", "1234"));

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

                boolean encontrado = false;

                for (Usuario u : listaUsuarios) {
                    if (u.iniciarSesion(usuario, contrasena)) {
                        encontrado = true;
                        JOptionPane.showMessageDialog(null, "¡Inicio de sesión exitoso!");

                        if (u instanceof Gerente) {
                            new VentanaGerente(u);
                        } else if (u instanceof EmpleadoNormal) {
                            new VentanaEmpleado(u);
                        } else if (u instanceof Cliente) {
                            new VentanaCliente(u);
                        }

                        PantallaLogin.this.dispose(); 
                        break;
                    }
                }

                if (!encontrado) {
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
