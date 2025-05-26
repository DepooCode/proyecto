package pantallas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import parque.*;

public class VentanaEliminarTurno extends JFrame {
    private Gerente gerente;
    private JComboBox<String> comboEmpleados;
    private JComboBox<String> comboTurnos;
    private JButton btnEliminar;

    public VentanaEliminarTurno(Gerente gerente) {
        this.gerente = gerente;
        setTitle("Eliminar Turno de Empleado");
        setSize(400, 220);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initComponentes();
    }

    private void initComponentes() {
        setLayout(new GridLayout(5, 1, 10, 10));

        comboEmpleados = new JComboBox<>();
        for (EmpleadoNormal emp : gerente.getListaEmpleadosGest()) {
            comboEmpleados.addItem(emp.getNombre());
        }
        add(new JLabel("Seleccione empleado:"));
        add(comboEmpleados);

        comboTurnos = new JComboBox<>();
        add(new JLabel("Seleccione turno a eliminar:"));
        add(comboTurnos);

        btnEliminar = new JButton("Eliminar Turno");
        add(btnEliminar);

        comboEmpleados.addActionListener(e -> cargarTurnosEmpleado());

        btnEliminar.addActionListener(e -> eliminarTurno());

        if (comboEmpleados.getItemCount() > 0) {
            comboEmpleados.setSelectedIndex(0);
            cargarTurnosEmpleado();
        }
    }

    private void cargarTurnosEmpleado() {
        comboTurnos.removeAllItems();
        int empIndex = comboEmpleados.getSelectedIndex();
        if (empIndex < 0) return;

        EmpleadoNormal empleado = gerente.getListaEmpleadosGest().get(empIndex);
        List<Turno> turnos = empleado.getTurnosAsignados();

        if (turnos.isEmpty()) {
            comboTurnos.addItem("No tiene turnos asignados");
            comboTurnos.setEnabled(false);
            btnEliminar.setEnabled(false);
        } else {
            comboTurnos.setEnabled(true);
            btnEliminar.setEnabled(true);
            for (Turno t : turnos) {
                comboTurnos.addItem(t.getTipoTurno() + " - " + t.getFecha());
            }
        }
    }

    private void eliminarTurno() {
        int empIndex = comboEmpleados.getSelectedIndex();
        int turnoIndex = comboTurnos.getSelectedIndex();

        if (empIndex < 0 || turnoIndex < 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar empleado y turno.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        EmpleadoNormal empleado = gerente.getListaEmpleadosGest().get(empIndex);
        List<Turno> turnos = empleado.getTurnosAsignados();

        if (turnos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El empleado no tiene turnos asignados.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Turno turno = turnos.get(turnoIndex);
        turnos.remove(turnoIndex);
        turno.setAsignado(false);

        JOptionPane.showMessageDialog(this, "Turno eliminado correctamente.");
        cargarTurnosEmpleado(); 
    }

    
}
