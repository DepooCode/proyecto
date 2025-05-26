package pantallas;
import javax.swing.*;
import parque.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
public class VentanaListaAtracciones extends JFrame {
    public VentanaListaAtracciones(Gerente gerente) {
        setTitle("Lista de Atracciones");
        setSize(400, 300);
        setLocationRelativeTo(null);
        JTextArea areaTexto = new JTextArea();
        for (Atraccion a : gerente.getListaAtraccionesGest()) {
            areaTexto.append(a.getNombre() + " - " + a.getExclusividad() + "\n");
        }
        add(new JScrollPane(areaTexto));
        JButton cerrar = new JButton("Cerrar");
        cerrar.addActionListener(e -> dispose());
        add(cerrar, BorderLayout.SOUTH);
        setVisible(true);
    }
}
