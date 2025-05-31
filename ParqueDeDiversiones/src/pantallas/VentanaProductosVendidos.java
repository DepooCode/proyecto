package pantallas;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class VentanaProductosVendidos extends JFrame {

    public VentanaProductosVendidos(Map<String, Integer> productosVendidos) {
        setTitle("Productos Vendidos");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JTextArea areaProductos = new JTextArea();
        areaProductos.setEditable(false);

        if (productosVendidos == null || productosVendidos.isEmpty()) {
            areaProductos.setText("No se han registrado productos vendidos.");
        } else {
            for (Map.Entry<String, Integer> entry : productosVendidos.entrySet()) {
                areaProductos.append(entry.getKey() + " - Cantidad vendida: " + entry.getValue() + "\n");
            }
        }

        add(new JScrollPane(areaProductos), BorderLayout.CENTER);
    }
}
