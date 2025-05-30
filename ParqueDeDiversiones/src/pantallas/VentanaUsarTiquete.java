package pantallas;

import parque.Cliente;
import parque.Tiquete;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class VentanaUsarTiquete extends JFrame {

    private Cliente cliente;
    private JTable tablaTiquetes;
    private DefaultTableModel modeloTabla;

    public VentanaUsarTiquete(Cliente cliente) {
        this.cliente = cliente;

        setTitle("Usar Tiquete");
        setSize(600, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Tipo");
        modeloTabla.addColumn("Utilizado");

        tablaTiquetes = new JTable(modeloTabla);
        cargarTiquetes();

        JScrollPane scrollPane = new JScrollPane(tablaTiquetes);
        add(scrollPane, BorderLayout.CENTER);

        JButton botonUsar = new JButton("Usar Tiquete");
        add(botonUsar, BorderLayout.SOUTH);

        botonUsar.addActionListener(e -> usarTiquete());

        setVisible(true);
    }

    private void cargarTiquetes() {
        List<Tiquete> tiquetes = cliente.getListaTiquetesComprados();
        modeloTabla.setRowCount(0); // limpiar tabla

        for (Tiquete t : tiquetes) {
            modeloTabla.addRow(new Object[]{
                t.getId(),
                t.getClass().getSimpleName(),
                t.isUtilizado() ? "Sí" : "No"
            });
        }
    }

    private void usarTiquete() {
        int filaSeleccionada = tablaTiquetes.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un tiquete para usar.");
            return;
        }

        String id = (String) modeloTabla.getValueAt(filaSeleccionada, 0);
        Tiquete tiquete = cliente.buscarTiquetePorId(id);

        if (tiquete == null) {
            JOptionPane.showMessageDialog(this, "Tiquete no encontrado.");
            return;
        }

        if (tiquete.isUtilizado()) {
            JOptionPane.showMessageDialog(this, "Este tiquete ya ha sido utilizado.");
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea usar este tiquete?", "Confirmar Uso", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            tiquete.usarTiquete();
            JOptionPane.showMessageDialog(this, "Tiquete utilizado con éxito.");
            cargarTiquetes(); 
        }
    }
}
