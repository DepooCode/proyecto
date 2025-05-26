package pantallas;

import javax.swing.*;

import parque.*;

import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class VentanaAsignarTurno extends JFrame {
    private Gerente gerente;
    private JComboBox<String> comboEmpleados;
    private JComboBox<String> comboTurnos;
    private JButton btnAsignar;
    
    private List<Turno> turnosDisponibles;

    public VentanaAsignarTurno(Gerente gerente) {
        this.gerente = gerente;
        setTitle("Asignar Turno a Empleado");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initComponentes();
    }

    private void initComponentes() {
        setLayout(new GridLayout(4, 1, 10, 10));

        comboEmpleados = new JComboBox<>();
        for (EmpleadoNormal emp : gerente.getListaEmpleadosGest()) {
            comboEmpleados.addItem(emp.getNombre());
        }
        add(new JLabel("Seleccione empleado:"));
        add(comboEmpleados);

        comboTurnos = new JComboBox<>();
        turnosDisponibles = obtenerTurnosDisponibles();
        for (Turno t : turnosDisponibles) {
            if (!t.isAsignado()) {
                comboTurnos.addItem(t.getTipoTurno() + " - " + t.getFecha());
            }
        }
        add(new JLabel("Seleccione turno:"));
        add(comboTurnos);

        btnAsignar = new JButton("Asignar Turno");
        add(btnAsignar);

        btnAsignar.addActionListener(e -> asignarTurno());
    }

    private List<Turno> obtenerTurnosDisponibles() {
        List<Turno> turnos = new java.util.ArrayList<>();
        turnos.add(new Turno(new java.util.Date(), "Mañana", null));
        turnos.add(new Turno(new java.util.Date(), "Tarde", null));
        turnos.add(new Turno(new java.util.Date(), "Noche", null));
        return turnos;
    }

    private void asignarTurno() {
        int empleadoIndex = comboEmpleados.getSelectedIndex();
        int turnoIndex = comboTurnos.getSelectedIndex();

        if (empleadoIndex < 0 || turnoIndex < 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar empleado y turno.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        EmpleadoNormal empleado = gerente.getListaEmpleadosGest().get(empleadoIndex);
        Turno turno = turnosDisponibles.get(turnoIndex);

        if (!turno.isAsignado()) {
            empleado.getTurnosAsignados().add(turno);
            turno.setAsignado(true);
            JOptionPane.showMessageDialog(this, "Turno asignado correctamente.");
            this.dispose();  
        } else {
            JOptionPane.showMessageDialog(this, "El turno ya está asignado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
}
