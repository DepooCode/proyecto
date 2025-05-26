package pantallas;

import javax.swing.*;

import parque.Espectaculo;
import parque.Gerente;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.sql.Date;
import java.util.List;

public class VentanaCrearEspectaculo extends JFrame {

    private JTextField txtNombre, txtHorario, txtFecha, txtRestriccionesClima, txtTemporada;

    public VentanaCrearEspectaculo(Gerente gerente) {
        setTitle("Crear Espectáculo");
        setSize(400, 300);
        setLayout(new GridLayout(6, 2, 10, 10));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        txtNombre = new JTextField();
        txtHorario = new JTextField();
        txtFecha = new JTextField();
        txtRestriccionesClima = new JTextField();
        txtTemporada = new JTextField();

        add(new JLabel("Nombre:")); add(txtNombre);
        add(new JLabel("Horario (HH:mm):")); add(txtHorario);
        add(new JLabel("Fecha (yyyy-MM-dd):")); add(txtFecha);
        add(new JLabel("Restricciones clima:")); add(txtRestriccionesClima);
        add(new JLabel("¿Es de temporada? (true/false):")); add(txtTemporada);

        JButton btnCrear = new JButton("Crear");
        btnCrear.addActionListener(e -> {
            try {
                String nombre = txtNombre.getText();
                LocalTime horario = LocalTime.parse(txtHorario.getText());
                Date fecha = Date.valueOf(txtFecha.getText());
                List<String> restricciones = Arrays.asList(txtRestriccionesClima.getText().split("\\s*,\\s*"));
                boolean temporada = Boolean.parseBoolean(txtTemporada.getText());

                Espectaculo esp = new Espectaculo(nombre, horario, fecha, restricciones, temporada);
                gerente.agregarEspectaculo(esp);

                JOptionPane.showMessageDialog(this, "Espectáculo creado correctamente.");
                dispose();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        add(new JLabel());
        add(btnCrear);
    }
}
