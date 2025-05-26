package pantallas;

import javax.swing.*;

import parque.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.List;

public class VentanaCrearAtraccion extends JFrame {

    private JComboBox<String> tipoAtraccion;
    private JTextField txtNombre, txtExclusividad, txtUbicacion, txtCupo, txtEncargados,
                       txtRestriccionesClima, txtTemporada;
    private JTextField txtMinAltura, txtMaxAltura, txtMinPeso, txtMaxPeso, txtRestriccionesSalud, txtNivelRiesgo;
    private JTextField txtMinEdad;

    public VentanaCrearAtraccion(Gerente gerente) {
        setTitle("Crear Atracción");
        setSize(500, 600);
        setLayout(new GridLayout(17, 2, 5, 5));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        tipoAtraccion = new JComboBox<>(new String[]{"Mecánica", "Cultural"});
        txtNombre = new JTextField();
        txtExclusividad = new JTextField();
        txtUbicacion = new JTextField();
        txtCupo = new JTextField();
        txtEncargados = new JTextField();
        txtTemporada = new JTextField();
        txtRestriccionesClima = new JTextField();

        txtMinAltura = new JTextField();
        txtMaxAltura = new JTextField();
        txtMinPeso = new JTextField();
        txtMaxPeso = new JTextField();
        txtRestriccionesSalud = new JTextField();
        txtNivelRiesgo = new JTextField();
        txtMinEdad = new JTextField();

        add(new JLabel("Tipo de Atracción:")); add(tipoAtraccion);
        add(new JLabel("Nombre:")); add(txtNombre);
        add(new JLabel("Exclusividad:")); add(txtExclusividad);
        add(new JLabel("Ubicación:")); add(txtUbicacion);
        add(new JLabel("Cupo máximo:")); add(txtCupo);
        add(new JLabel("Encargados mínimos:")); add(txtEncargados);
        add(new JLabel("¿Es de temporada? (true/false):")); add(txtTemporada);
        add(new JLabel("Restricciones clima (coma separadas):")); add(txtRestriccionesClima);

        add(new JLabel("Altura mínima (solo Mecánica):")); add(txtMinAltura);
        add(new JLabel("Altura máxima:")); add(txtMaxAltura);
        add(new JLabel("Peso mínimo:")); add(txtMinPeso);
        add(new JLabel("Peso máximo:")); add(txtMaxPeso);
        add(new JLabel("Restricciones de salud:")); add(txtRestriccionesSalud);
        add(new JLabel("Nivel de riesgo:")); add(txtNivelRiesgo);

        add(new JLabel("Edad mínima (solo Cultural):")); add(txtMinEdad);

        JButton btnCrear = new JButton("Crear Atracción");
        btnCrear.addActionListener(e -> {
            try {
                String nombre = txtNombre.getText();
                String exclusividad = txtExclusividad.getText();
                String ubicacion = txtUbicacion.getText();
                int cupo = Integer.parseInt(txtCupo.getText());
                int encargados = Integer.parseInt(txtEncargados.getText());
                boolean temporada = Boolean.parseBoolean(txtTemporada.getText());
                List<String> clima = Arrays.asList(txtRestriccionesClima.getText().split("\\s*,\\s*"));

                Atraccion atraccion;

                if (tipoAtraccion.getSelectedItem().equals("Mecánica")) {
                    float minAltura = Float.parseFloat(txtMinAltura.getText());
                    float maxAltura = Float.parseFloat(txtMaxAltura.getText());
                    float minPeso = Float.parseFloat(txtMinPeso.getText());
                    float maxPeso = Float.parseFloat(txtMaxPeso.getText());
                    List<String> salud = Arrays.asList(txtRestriccionesSalud.getText().split("\\s*,\\s*"));
                    String riesgo = txtNivelRiesgo.getText();

                    atraccion = new Mecanica(nombre, exclusividad, ubicacion, cupo, encargados, temporada,
                            clima, minAltura, maxAltura, minPeso, maxPeso, salud, riesgo);
                } else {
                    int minEdad = Integer.parseInt(txtMinEdad.getText());
                    atraccion = new Cultural(nombre, exclusividad, ubicacion, cupo, encargados, clima, temporada, minEdad);
                }

                gerente.agregarAtraccion(atraccion);
                JOptionPane.showMessageDialog(this, "Atracción creada correctamente.");
                dispose();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        add(new JLabel());
        add(btnCrear);
    }
}

