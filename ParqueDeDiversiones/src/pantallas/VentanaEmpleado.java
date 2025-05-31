package pantallas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.TreeMap;

import parque.EmpleadoNormal;
import parque.Usuario;

public class VentanaEmpleado extends JFrame {

    private EmpleadoNormal empleado;

    public VentanaEmpleado(Usuario u) {
        this.empleado = (EmpleadoNormal) u;
        setTitle("Panel de Empleado - " + empleado.getNombre());
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(8, 1, 10, 10)); // Ajustado para 8 botones

        String[] opciones = {
            "1. Ver mis turnos",
            "2. Registrar venta en tienda",
            "3. Facturar tiquetes",
            "4. Vender comida",
            "5. Registrar uso de atracción",
            "6. Ver mi información",
            "7. Ver productos vendidos",
            "8. Salir"
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
                new VentanaMisTurnos(empleado).setVisible(true);
                break;
            case 2:
                new VentanaVentasTienda(empleado).setVisible(true);
                break;
            case 3:
                new VentanaFacturacionTiquetes(empleado).setVisible(true);
                break;
            case 4:
                new VentanaVentasComida(empleado).setVisible(true);
                break;
            case 5:
                new VentanaRegistroAtracciones(empleado).setVisible(true);
                break;
            case 6:
                mostrarInformacionPersonal();
                break;
            case 7:
                Map<String, Integer> productosVendidos = new TreeMap<>();
                productosVendidos.put("Hamburguesa", 12);
                productosVendidos.put("Camisa souvenir", 5);
                productosVendidos.put("Gaseosa", 20);
                new VentanaProductosVendidos(productosVendidos).setVisible(true);
                break;
            case 8:
                dispose();
                System.exit(0);
                break;
            default:
                JOptionPane.showMessageDialog(this, "Opción inválida.");
                break;
        }
    }

    private void mostrarInformacionPersonal() {
        StringBuilder info = new StringBuilder();
        info.append("=== INFORMACIÓN PERSONAL ===\n");
        info.append("Nombre: ").append(empleado.getNombre()).append("\n");
        info.append("ID: ").append(empleado.getId()).append("\n");
        info.append("Usuario: ").append(empleado.getUsuario()).append("\n");
        info.append("Estado: ").append(empleado.isIniciado() ? "Sesión activa" : "Sesión inactiva").append("\n");

        JOptionPane.showMessageDialog(
            this,
            info.toString(),
            "Mi Información",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EmpleadoNormal empEjemplo = new EmpleadoNormal("EMP001", "Juan Pérez", "Cajero", 2, "juan", "1234");
            new VentanaEmpleado(empEjemplo).setVisible(true);
        });
    }
}
