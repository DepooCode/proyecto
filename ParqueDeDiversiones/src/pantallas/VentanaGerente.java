package pantallas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import parque.Gerente;
import parque.Usuario;

public class VentanaGerente extends JFrame {

    private Gerente gerente;

    public VentanaGerente(Usuario u) {
    	this.gerente= (Gerente) u;
        setTitle("Panel de Gerente");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(10, 1, 10, 10));

        String[] opciones = {
            "1. Listar empleados",
            "2. Crear empleado",
            "3. Crear atracción",
            "4. Crear espectáculo",
            "5. Asignar turno",
            "6. Eliminar turno",
            "7. Listar atracciones",
            "8. Listar espectáculos",
            "9. Empleados y turnos",
            "10. Salir"
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
                new VentanaListaEmpleados(gerente).setVisible(true);
                break;
            case 2:
                new VentanaCrearEmpleado(gerente).setVisible(true);
                break;
            case 3:
                new VentanaCrearAtraccion(gerente).setVisible(true);
                break;
            case 4:
                new VentanaCrearEspectaculo(gerente).setVisible(true);
                break;
            case 5:
                new VentanaAsignarTurno(gerente).setVisible(true);
                break;
            case 6:
                new VentanaEliminarTurno(gerente).setVisible(true);
                break;
            case 7:
                new VentanaListaAtracciones(gerente).setVisible(true);
                break;
            case 8:
                new VentanaListaEspectaculos(gerente).setVisible(true);
                break;
            case 9:
                new VentanaListaEmpleadosYTurnos(gerente).setVisible(true);
                break;
            case 10:
                dispose();
                System.exit(0);
                break;
            default:
                JOptionPane.showMessageDialog(this, "Opción inválida.");
                break;
        }
    }
    
}
