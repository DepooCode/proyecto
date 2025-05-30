package pantallas;

import parque.Cliente;
import parque.Tiquete;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.List;

import com.google.zxing.*;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class VentanaVerTiquetes extends JFrame {

    private Cliente cliente;
    private JTable tablaTiquetes;
    private DefaultTableModel modeloTabla;

    public VentanaVerTiquetes(Cliente cliente) {
        this.cliente = cliente;

        setTitle("Tiquetes Comprados");
        setSize(600, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Tipo");
        modeloTabla.addColumn("Utilizado");
        modeloTabla.addColumn("FastPass");

        tablaTiquetes = new JTable(modeloTabla);
        cargarTiquetes();

        JScrollPane scrollPane = new JScrollPane(tablaTiquetes);
        add(scrollPane, BorderLayout.CENTER);

        JButton botonImprimirQR = new JButton("Imprimir QR");
        add(botonImprimirQR, BorderLayout.SOUTH);

        botonImprimirQR.addActionListener(e -> imprimirTiquete());

        setVisible(true);
    }

    private void cargarTiquetes() {
        List<Tiquete> tiquetes = cliente.getListaTiquetesComprados();
        modeloTabla.setRowCount(0); // limpiar tabla

        for (Tiquete t : tiquetes) {
            modeloTabla.addRow(new Object[]{
                t.getId(),
                t.getClass().getSimpleName(),
                t.isUtilizado() ? "Sí" : "No",
                t.isFastPass() ? "Sí" : "No"
            });
        }
    }

    private void imprimirTiquete() {
        int filaSeleccionada = tablaTiquetes.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un tiquete para imprimir el QR.");
            return;
        }

        String id = (String) modeloTabla.getValueAt(filaSeleccionada, 0);
        Tiquete tiquete = cliente.buscarTiquetePorId(id);

        if (tiquete == null) {
            JOptionPane.showMessageDialog(this, "Tiquete no encontrado.");
            return;
        }

        if (tiquete.isImpreso()) {
            int opcion = JOptionPane.showConfirmDialog(this, "El tiquete ya fue impreso. ¿Desea reimprimirlo?", "Confirmar Reimpresión", JOptionPane.YES_NO_OPTION);
            if (opcion != JOptionPane.YES_OPTION) {
                return; // no imprimir
            }
        }

        try {
            
            String contenidoQR = generarContenidoQR(tiquete);
            BufferedImage qrImage = generarQR(contenidoQR, 300, 300);

            ImageIcon icon = new ImageIcon(qrImage);
            JOptionPane.showMessageDialog(this, new JLabel(icon), "QR del Tiquete", JOptionPane.PLAIN_MESSAGE);

            tiquete.setImpreso(true);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al generar el QR: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

 
    private String generarContenidoQR(Tiquete tiquete) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fecha = sdf.format(new java.util.Date());

        return "{\"tipo\":\"" + tiquete.getClass().getSimpleName() +
               "\", \"id\":\"" + tiquete.getId() +
               "\", \"fecha\":\"" + fecha + "\"}";
    }

    private BufferedImage generarQR(String texto, int ancho, int alto) throws WriterException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(texto, BarcodeFormat.QR_CODE, ancho, alto);
        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }
}
