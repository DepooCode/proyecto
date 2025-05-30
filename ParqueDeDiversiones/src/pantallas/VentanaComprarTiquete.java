package pantallas;

import parque.Cliente;
import parque.Atraccion;
import parque.Mecanica;
import parque.CategoriaTiquete;
import parque.Tiquete;
import parque.TiqueteEntradaIndividual;
import parque.TiqueteGeneral;
import parque.TiqueteTemporada;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;

public class VentanaComprarTiquete extends JFrame {

    private Cliente cliente;

    private JComboBox<String> comboTipo;
    private JComboBox<String> comboAtraccion;
    private JTextField campoCategoria;
    private JCheckBox checkFastPass;
    private JTextField campoFechaFin;
    private JButton botonComprar;

    public VentanaComprarTiquete(Cliente cliente) {
        this.cliente = cliente;

        setTitle("Comprar Tiquete");
        setSize(400, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(7, 1, 10, 10));

        comboTipo = new JComboBox<>(new String[]{"Individual", "General", "Temporada"});
        comboAtraccion = new JComboBox<>(new String[]{"Montaña Rusa", "Casa del Terror", "Tren Fantasma"});
        campoCategoria = new JTextField();
        checkFastPass = new JCheckBox("FastPass");
        campoFechaFin = new JTextField();
        botonComprar = new JButton("Comprar");

        add(new JLabel("Tipo de Tiquete:"));
        add(comboTipo);
        add(new JLabel("Atracción (solo individual):"));
        add(comboAtraccion);
        add(new JLabel("Categoría (ORO, PLATA, BRONCE):"));
        add(campoCategoria);
        add(checkFastPass);
        add(new JLabel("Fecha Fin (solo temporada) [yyyy-MM-dd]:"));
        add(campoFechaFin);
        add(botonComprar);

        comboTipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipoSeleccionado = (String) comboTipo.getSelectedItem();
                comboAtraccion.setEnabled(tipoSeleccionado.equals("Individual"));
                campoFechaFin.setEnabled(tipoSeleccionado.equals("Temporada"));
            }
        });

        // Inicializar el estado de los campos
        comboAtraccion.setEnabled(true);
        campoFechaFin.setEnabled(false);

        botonComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comprarTiquete();
            }
        });

        setVisible(true);
    }

    private void comprarTiquete() {
        String tipo = (String) comboTipo.getSelectedItem();
        String idTiquete = "T-" + System.currentTimeMillis(); // ID único
        String categoriaStr = campoCategoria.getText().toUpperCase();
        boolean fastPass = checkFastPass.isSelected();
        Date fechaFastPass = fastPass ? new Date(System.currentTimeMillis()) : null;

        if (categoriaStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar una categoría.");
            return;
        }

        CategoriaTiquete categoria;
        try {
            categoria = CategoriaTiquete.valueOf(categoriaStr);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, "Categoría inválida. Use ORO, PLATA o BRONCE.");
            return;
        }

        Tiquete nuevoTiquete = null;

        if (tipo.equals("Individual")) {
            String atraccionSeleccionada = (String) comboAtraccion.getSelectedItem();
            Atraccion atraccion = new Mecanica(atraccionSeleccionada, categoriaStr, "Zona D", 20, 3, true, new ArrayList<>(),
                    1.20f, 2.00f, 40f, 120f, new ArrayList<>(), "Alto");
            nuevoTiquete = new TiqueteEntradaIndividual(idTiquete, categoria, fastPass, fechaFastPass, atraccion);
        } else if (tipo.equals("General")) {
            nuevoTiquete = new TiqueteGeneral(idTiquete, categoria, fastPass, fechaFastPass);
        } else if (tipo.equals("Temporada")) {
            String fechaFinStr = campoFechaFin.getText();
            if (fechaFinStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe ingresar la fecha de fin.");
                return;
            }
            Date fechaFin;
            try {
                fechaFin = Date.valueOf(fechaFinStr); // yyyy-MM-dd
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, "Formato de fecha inválido. Use yyyy-MM-dd.");
                return;
            }
            nuevoTiquete = new TiqueteTemporada(idTiquete, categoria, fastPass, fechaFastPass, fechaFin);
        }

        if (nuevoTiquete != null) {
            cliente.comprarTiquete(nuevoTiquete);
            JOptionPane.showMessageDialog(this, "¡Tiquete comprado exitosamente!");
            dispose(); // Cierra la ventana de compra
        }
    }
}
