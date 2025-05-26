package pantallas;
import javax.swing.*;
import parque.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
public class VentanaListaEspectaculos extends JFrame {
    public VentanaListaEspectaculos(Gerente gerente) {
        setTitle("Lista de Espectáculos");
        setSize(400, 300);
        setLocationRelativeTo(null);
        JTextArea areaTexto = new JTextArea();
        for (Espectaculo e : gerente.getListaEspectaculosGest()) {
            areaTexto.append(e.getNombre() + " - " + e.getHorario() + "\n");
        }
        add(new JScrollPane(areaTexto));
        JButton cerrar = new JButton("Cerrar");
        cerrar.addActionListener(e -> dispose());
        add(cerrar, BorderLayout.SOUTH);
        setVisible(true);
    }
}
