package pantallas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import parque.Cliente;
import parque.Usuario;

public class VentanaCliente extends JFrame {

    private Cliente cliente;

    public VentanaCliente(Usuario usuario) {
        this.cliente = (Cliente) usuario;
        setTitle("Panel del Cliente");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1, 10, 10)); // 5 botones

        String[] opciones = {
            "1. Comprar Tiquete",
            "2. Ver Tiquetes Comprados",
            "3. Usar Tiquete",
            "4. Cerrar Sesión"
        };

        for (int i = 0; i < opciones.length; i++) {
            JButton boton = new JButton(opciones[i]);
            final int opcion = i + 1;
            boton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ejecutarOpcion(opcion);
                }
            });
            add(boton);
        }

        setVisible(true);
    }

    private void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                new VentanaComprarTiquete(cliente).setVisible(true);
                break;
            case 2:
                new VentanaVerTiquetes(cliente).setVisible(true);
                break;
            case 3:
                new VentanaUsarTiquete(cliente).setVisible(true);
                break;
            case 4:
                // Volver a la pantalla de login
                new PantallaLogin();
                dispose();
                break;
            default:
                JOptionPane.showMessageDialog(this, "Opción inválida.");
                break;
        }
    }
}
