package proyecto3_topicos;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

public class DatosGraficaArea extends JFrame {

    private JButton btnSeleccionar;
    private JButton btnGraficar;
    private JLabel lblInstrucciones;
    private JLabel lblFormato;
    private JLabel lblRuta; // Label para mostrar la ruta del archivo seleccionado

    // Variable para almacenar el archivo a utilizar (CSV o Excel)
    private File archivoSeleccionado;

    public DatosGraficaArea() {
        super("Selector de Archivo CSV / Excel");
        setSize(1000, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel central con las instrucciones
        JPanel panelInstrucciones = new JPanel();
        panelInstrucciones.setLayout(new BoxLayout(panelInstrucciones, BoxLayout.Y_AXIS));

        lblInstrucciones = new JLabel("Por favor, seleccione un archivo CSV, XLS o XLSX.");
        lblInstrucciones.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Recomendación del formato de archivo.
        lblFormato = new JLabel("Formato recomendado: Categoría;Valor;Valor;...");
        lblFormato.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Label para mostrar la ruta del archivo seleccionado
        lblRuta = new JLabel("Archivo seleccionado: Ningún archivo seleccionado");
        lblRuta.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelInstrucciones.add(Box.createVerticalStrut(20));
        panelInstrucciones.add(lblInstrucciones);
        panelInstrucciones.add(Box.createVerticalStrut(10));
        panelInstrucciones.add(lblFormato);
        panelInstrucciones.add(Box.createVerticalStrut(10));
        panelInstrucciones.add(lblRuta);
        add(panelInstrucciones, BorderLayout.CENTER);

        // Panel inferior con los botones para seleccionar archivo y graficar
        JPanel panelBoton = new JPanel(new FlowLayout());

        btnSeleccionar = new JButton("Seleccionar Archivo");
        btnSeleccionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccionarArchivo();
            }
        });
        panelBoton.add(btnSeleccionar);

        btnGraficar = new JButton("Graficar");
        btnGraficar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                graficar();
            }
        });
        panelBoton.add(btnGraficar);

        add(panelBoton, BorderLayout.SOUTH);
    }

    private void seleccionarArchivo() {
        // FileChooser para archivos CSV, XLS y XLSX.
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Archivos CSV, XLS y XLSX", "csv", "xls", "xlsx");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(filter);

        int returnValue = fileChooser.showOpenDialog(this);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String ext = getFileExtension(selectedFile.getName());
            if (ext.equalsIgnoreCase("csv")
                    || ext.equalsIgnoreCase("xls")
                    || ext.equalsIgnoreCase("xlsx")) {

                archivoSeleccionado = selectedFile;
                lblRuta.setText("Archivo seleccionado: " + selectedFile.getAbsolutePath());
            } else {
                lblRuta.setText("Error: Por favor, seleccione un archivo CSV, XLS o XLSX.");
            }
        }
    }

    // Método auxiliar para obtener la extensión de un archivo
    private String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf(".");
        if (dotIndex >= 0) {
            return fileName.substring(dotIndex + 1);
        }
        return "";
    }

    private void graficar() {
        if (archivoSeleccionado != null && archivoSeleccionado.exists()) {
            new GraficaArea(archivoSeleccionado);
        } else {
            JOptionPane.showMessageDialog(this,
                    "Por favor, seleccione primero un archivo CSV, XLS o XLSX.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DatosGraficaArea frame = new DatosGraficaArea();
            frame.setVisible(true);
        });
    }
}
