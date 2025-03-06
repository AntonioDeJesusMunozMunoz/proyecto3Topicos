/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto3_topicos;

import java.awt.BorderLayout;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.CellType;
import java.util.Iterator;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.SpiderWebPlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;   // Para XLS
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;     // Para XLSX
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;

// Importaciones de iText para exportar PDF
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Image;
import java.awt.Component;
import java.awt.Graphics2D;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author AJMM
 */
public class principalFrame extends javax.swing.JFrame {

    /**
     * Creates new form principalFrame
     */
    String archivoSeleccionado;
    private int graficoCount = 0;
    private JPanel[] graficoPanels;

    public principalFrame() {
        initComponents();

        graficoPanels = new JPanel[]{jPanel1, jPanel2, jPanel3, jPanel4};
    }

    public void mostrarArchivoCSV(String archivo) {

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        graficasScrollPane = new javax.swing.JScrollPane();
        graficasPane = new javax.swing.JPanel();
        mostrarGraficasScrollPane = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        mostrarArchivoScrollPane = new javax.swing.JScrollPane();
        mostrarArchivoTable = new javax.swing.JTable();
        imprimirAPDFBoton = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        crearBoton = new javax.swing.JButton();
        elegirArchivoBoton = new javax.swing.JButton();
        mostrarArchivoLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        graficasScrollPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        graficasPane.setBackground(new java.awt.Color(255, 153, 153));

        mostrarGraficasScrollPane.setBackground(new java.awt.Color(255, 255, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 271, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 283, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 283, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 254, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 228, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout mostrarGraficasScrollPaneLayout = new javax.swing.GroupLayout(mostrarGraficasScrollPane);
        mostrarGraficasScrollPane.setLayout(mostrarGraficasScrollPaneLayout);
        mostrarGraficasScrollPaneLayout.setHorizontalGroup(
            mostrarGraficasScrollPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mostrarGraficasScrollPaneLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 23, Short.MAX_VALUE))
        );
        mostrarGraficasScrollPaneLayout.setVerticalGroup(
            mostrarGraficasScrollPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mostrarGraficasScrollPaneLayout.createSequentialGroup()
                .addGroup(mostrarGraficasScrollPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 19, Short.MAX_VALUE))
        );

        mostrarArchivoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        mostrarArchivoScrollPane.setViewportView(mostrarArchivoTable);

        javax.swing.GroupLayout graficasPaneLayout = new javax.swing.GroupLayout(graficasPane);
        graficasPane.setLayout(graficasPaneLayout);
        graficasPaneLayout.setHorizontalGroup(
            graficasPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mostrarGraficasScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mostrarArchivoScrollPane)
        );
        graficasPaneLayout.setVerticalGroup(
            graficasPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, graficasPaneLayout.createSequentialGroup()
                .addComponent(mostrarArchivoScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mostrarGraficasScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        graficasScrollPane.setViewportView(graficasPane);

        imprimirAPDFBoton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        imprimirAPDFBoton.setText("IMPRIMIR A PDF");
        imprimirAPDFBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirAPDFBotonActionPerformed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gráfica de telaraña", "Gráfica de área", "Item 3", "Item 4" }));

        crearBoton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        crearBoton.setText("CREAR:");
        crearBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearBotonActionPerformed(evt);
            }
        });

        elegirArchivoBoton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        elegirArchivoBoton.setText("Elegir archivo...");
        elegirArchivoBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elegirArchivoBotonActionPerformed(evt);
            }
        });

        mostrarArchivoLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mostrarArchivoLabel.setText("Ningún archivo seleccionado...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(graficasScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 990, Short.MAX_VALUE)
                                .addComponent(imprimirAPDFBoton)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(elegirArchivoBoton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mostrarArchivoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(crearBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(crearBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(elegirArchivoBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(mostrarArchivoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addComponent(graficasScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(imprimirAPDFBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void crearBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearBotonActionPerformed

        // Solo se procesa si la segunda opción del combobox está activada (índice 1)
        if (this.jComboBox1.getSelectedIndex() == 1) {
            // Verificar si ya se ha creado la gráfica de área en jPanel3
            if (jPanel3.getComponentCount() > 0) {
                JOptionPane.showMessageDialog(this,
                        "SOLO UNA GRAFICA DE AREA",
                        "Advertencia",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Generar la gráfica usando los datos del JTable
            ChartPanel cp = generarGraficoDesdeTable();
            if (cp != null) {
                // Se coloca la gráfica en jPanel3
                jPanel3.removeAll();
                jPanel3.setLayout(new BorderLayout());
                jPanel3.add(cp, BorderLayout.CENTER);
                jPanel3.revalidate();
                jPanel3.repaint();
            }
        } else {
            // Si no se seleccionó la opción 2, puede hacerse otro tipo de procesamiento o ignorar la acción
            // Por ejemplo, podríamos lanzar un mensaje o simplemente retornar
            // JOptionPane.showMessageDialog(this, "Seleccione la opción de Área", "Información", JOptionPane.INFORMATION_MESSAGE);
            return;

        }

    }//GEN-LAST:event_crearBotonActionPerformed

    private void elegirArchivoBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elegirArchivoBotonActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.setMultiSelectionEnabled(true);

        // Aplicar filtro para csv
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos (*.csv, *.xls, *.xlsx)", "csv", "xls", "xlsx");
        fc.setFileFilter(filtro);
        int resultado = fc.showOpenDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            this.mostrarArchivoLabel.setText(fc.getSelectedFile().getName());
            archivoSeleccionado = fc.getSelectedFile().getAbsolutePath();
            System.out.println(archivoSeleccionado);

            //si es csv
            if (fc.getSelectedFile().getName().endsWith("csv")) {
                cargarCSVEnJTable(archivoSeleccionado, this.mostrarArchivoTable);
            }

            //si es xls
            if (fc.getSelectedFile().getName().endsWith("xls") || fc.getSelectedFile().getName().endsWith("xlsx")) {
                cargarXLSEnTable(archivoSeleccionado, this.mostrarArchivoTable);
            }

        }

    }//GEN-LAST:event_elegirArchivoBotonActionPerformed

    private void imprimirAPDFBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirAPDFBotonActionPerformed
        // Define el factor de escala; ajústalo según lo que necesites para mayor claridad.
        int scaleFactor = 2;

        try {
            // Capturar la imagen del JTable
            // Se asume que tu JTable se llama "mostrarArchivoTable"
            BufferedImage imagenTabla = captureComponentImage(mostrarArchivoTable, scaleFactor);

            // Capturar las imágenes de los 4 jPanel.
            // Se asume que se llaman jPanel1, jPanel2, jPanel3 y jPanel4.
            BufferedImage imagenPanel1 = captureComponentImage(jPanel1, scaleFactor);
            BufferedImage imagenPanel2 = captureComponentImage(jPanel2, scaleFactor);
            BufferedImage imagenPanel3 = captureComponentImage(jPanel3, scaleFactor);
            BufferedImage imagenPanel4 = captureComponentImage(jPanel4, scaleFactor);

            // Crear el documento PDF (utilizando tamaño A4)
            Document document = new Document(PageSize.A4);
            String outputPath = System.getProperty("user.home") + File.separator
                    + "Downloads" + File.separator + "reporte.pdf";
            PdfWriter.getInstance(document, new FileOutputStream(outputPath));
            document.open();

            // Arreglo de imágenes a insertar (cada imagen se colocará en una página del PDF)
            BufferedImage[] images = {
                imagenTabla, imagenPanel1, imagenPanel2, imagenPanel3, imagenPanel4
            };

            // Para cada imagen, convertirla a formato PNG e insertarla en una página.
            for (int i = 0; i < images.length; i++) {
                // Convertir BufferedImage a arreglo de bytes en formato PNG
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(images[i], "png", baos);
                baos.flush();
                byte[] imageBytes = baos.toByteArray();
                baos.close();

                // Crear el objeto Image de iText
                Image pdfImage = Image.getInstance(imageBytes);
                // Escalar la imagen para que se ajuste a la página A4 dejando un pequeño margen
                pdfImage.scaleToFit(PageSize.A4.getWidth() - 50, PageSize.A4.getHeight() - 50);
                pdfImage.setAlignment(Image.ALIGN_CENTER);

                // Si no es el primer elemento, se agrega nueva página
                if (i > 0) {
                    document.newPage();
                }
                document.add(pdfImage);
            }

            document.close();
            JOptionPane.showMessageDialog(this, "PDF guardado en:\n" + outputPath);
        } catch (IOException | DocumentException ex) {
            JOptionPane.showMessageDialog(this, "Error al generar PDF: " + ex.getMessage());
        }
    }//GEN-LAST:event_imprimirAPDFBotonActionPerformed

    public static void cargarCSVEnJTable(String archivoCSV, JTable table) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            //variables que necesito
            Vector<Vector<Object>> datosParaTable = new Vector<>();

            //leo todos los datos del csv
            String currLinea = "";
            int cuantasColumnas = 0;
            while ((currLinea = br.readLine()) != null) {
                Vector<Object> currVector = new Vector<>();

                //leo renglón
                for (Object currString : currLinea.split(",")) {
                    currVector.add(currString);
                }

                //actualizo cuantas columnas
                cuantasColumnas = Math.max(cuantasColumnas, currVector.size());

                //lo pongo en el vector de todos los datos
                datosParaTable.add(currVector);
            }

            // Le pongo nombres a las columnas de que 1,2,3,4,5 para que el usuario lo vea mas facil
            Vector<String> nombresColumnas = new Vector<>();
            for (int i = 0; i < cuantasColumnas; i++) {
                nombresColumnas.add("" + (i + 1));
            }

            //le pongo el modelo a la table
            table.setModel(new DefaultTableModel(datosParaTable, nombresColumnas));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getCause());
        }
    }

    public static void cargarXLSEnTable(String archivoExcell, JTable table) {
        FileInputStream file = null;
        try {
            file = new FileInputStream(new File(archivoExcell));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(principalFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        Workbook workbook = null;
        try {
            // Verificar la extensión del archivo
            if (archivoExcell.toLowerCase().endsWith("xlsx")) {
                workbook = new XSSFWorkbook(file);
            } else if (archivoExcell.toLowerCase().endsWith("xls")) {
                workbook = new HSSFWorkbook(file);
            } else {
                throw new IllegalArgumentException("Formato de archivo no soportado.");
            }
        } catch (IOException ex) {
            Logger.getLogger(principalFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Conseguir la primera hoja
        Sheet sheet = workbook.getSheetAt(0);
        // Preparar las estructuras de datos para la JTable
        Vector<Vector<Object>> datosParaTable = new Vector<>();
        int cuantasColumnas = 0;

        // Recorrer la hoja de Excel
        for (Row row : sheet) {
            Vector<Object> datosRenglon = new Vector<>();
            for (Cell cell : row) {
                // Dependiendo del tipo de celda, se agrega el valor al vector
                switch (cell.getCellType()) {
                    case STRING:
                        datosRenglon.add(cell.getStringCellValue());
                        break;
                    case NUMERIC:
                        datosRenglon.add(cell.getNumericCellValue());
                        break;
                    case BOOLEAN:
                        datosRenglon.add(cell.getBooleanCellValue());
                        break;
                    default:
                        datosRenglon.add(""); // Para celdas vacías o de tipo desconocido
                        break;
                }
            }
            // Comparar la longitud del renglón para determinar el número máximo de columnas
            cuantasColumnas = Math.max(cuantasColumnas, datosRenglon.size());
            datosParaTable.add(datosRenglon);
        }

        // Crear los nombres de las columnas de forma automática (1, 2, 3,...)
        Vector<String> nombresColumnas = new Vector<>();
        for (int i = 0; i < cuantasColumnas; i++) {
            nombresColumnas.add("" + (i + 1));
        }

        // Aplicar el modelo a la JTable
        table.setModel(new DefaultTableModel(datosParaTable, nombresColumnas));
    }

    public void graficarWeb(JPanel panelDondeGraficar, String documento, String titulo) {
        int indiceDeColumnaDeEjes = 0;
        int indiceDeRenglonDeSeries = 0;

        //creo las estructuras de datos que necesitaré
        ArrayList<String> ejes = new ArrayList<>();
        Map<String, ArrayList<Integer>> seriesYValores = new HashMap<>();

        //conseguir los datos    
        //si es xls, codigo conseguido de: https://howtodoinjava.com/java/library/readingwriting-excel-files-in-java-poi-tutorial/
        FileInputStream file = null;
        try {
            file = new FileInputStream(new File(documento));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(principalFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Crear workbook
        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(file);
        } catch (IOException ex) {
            Logger.getLogger(principalFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Conseguir la primer sheet
        XSSFSheet sheet = workbook.getSheetAt(0);
        //explicacion de código conseguida de: https://poi.apache.org/components/spreadsheet/quick-guide.html?utm_source=chatgpt.com

        //conseguir los valores
        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            Row currRow = sheet.getRow(i);

            //conseguir los ejes
            ejes.add(currRow.getCell(indiceDeColumnaDeEjes).getStringCellValue());
        }

        //conseguir los valores de las series
        //itero por las columnas
        for (int i = indiceDeColumnaDeEjes + 1; i < sheet.getRow(0).getPhysicalNumberOfCells(); i++) {
            //itero por los renglones
            ArrayList<Integer> currValores = new ArrayList<>();
            //lleno este arrayList de sus valores
            for (int j = indiceDeRenglonDeSeries + 1; j < sheet.getPhysicalNumberOfRows(); j++) {
                currValores.add((int) sheet.getRow(j).getCell(i).getNumericCellValue());
            }

            seriesYValores.put(sheet.getRow(0).getCell(i).getStringCellValue(), currValores);
        }
        //cerrar el xls
        try {
            file.close();
            //si es csv      
        } catch (IOException ex) {
            Logger.getLogger(principalFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        //lleno el default category set
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Map.Entry<String, ArrayList<Integer>> parSerieValores : seriesYValores.entrySet()) {
            for (int i = 0; i < parSerieValores.getValue().size(); i++) {
                dataset.addValue(parSerieValores.getValue().get(i), parSerieValores.getKey(), ejes.get(i));
            }
        }

        //crear el dataset
//        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//        String series = "Score"; // Only one series in a radar chart
//        dataset.addValue(8, series, "Speed");
//        dataset.addValue(7, series, "Strength");
//        dataset.addValue(9, series, "Agility");
//        dataset.addValue(6, series, "Endurance");
//        dataset.addValue(8, series, "Flexibility");
//        
        //crear el plot
        SpiderWebPlot plot = new SpiderWebPlot(dataset);

        //crear la chart
        JFreeChart chart = new JFreeChart(titulo, JFreeChart.DEFAULT_TITLE_FONT, plot, false);
        chart.addSubtitle(new LegendTitle(chart.getPlot()));//necesito hace resto para que me muestre las series

        //crear la chartPanel
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(300, 300));
        chartPanel.addMouseMotionListener(new arrastrarMouseListener(chartPanel));
        panelDondeGraficar.add(chartPanel);
    }

    public ArrayList<Cell> conseguirDatosDeRenglonExcell(Sheet hoja, int indiceRenglon, int indiceInicio, int indiceFin) {
        ArrayList<Cell> returnAL = new ArrayList<>();

        //lenar el array list
        Row r = hoja.getRow(indiceRenglon);
        for (int i = indiceInicio; i < indiceFin; i++) {
            returnAL.add(r.getCell(i));
        }

        return returnAL;
    }

    private ChartPanel generarGraficoDesdeTable() {
        DefaultTableModel modelo = (DefaultTableModel) this.mostrarArchivoTable.getModel();

        // Validación: se requiere al menos dos renglones (uno para leyendas y otro de datos)
        if (modelo.getRowCount() < 2) {
            JOptionPane.showMessageDialog(this,
                    "Se requiere al menos una fila de leyenda y una fila de datos.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        int numColumnas = modelo.getColumnCount();

        // Extraer los nombres de las series desde la primera fila (omitiendo la primera columna)
        String[] seriesNombres = new String[numColumnas - 1];
        for (int col = 1; col < numColumnas; col++) {
            Object objSerie = modelo.getValueAt(0, col);
            seriesNombres[col - 1] = (objSerie != null) ? objSerie.toString() : "Serie " + col;
        }

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        // Recorrer las filas de datos (desde la fila 1 en adelante)
        for (int fila = 1; fila < modelo.getRowCount(); fila++) {
            Object objCategoria = modelo.getValueAt(fila, 0);
            if (objCategoria == null) {
                continue;
            }
            String categoria = objCategoria.toString();

            // Agregar cada valor a la serie correspondiente
            for (int col = 1; col < numColumnas; col++) {
                Object objValor = modelo.getValueAt(fila, col);
                if (objValor == null || objValor.toString().trim().isEmpty()) {
                    continue;
                }
                try {
                    double valor = Double.parseDouble(objValor.toString().trim());
                    dataset.addValue(valor, seriesNombres[col - 1], categoria);
                } catch (NumberFormatException ex) {
                    // Si no es numérico, se ignora.
                    continue;
                }
            }
        }

        // Crear el gráfico de área
        JFreeChart chart = ChartFactory.createAreaChart(
                "Gráfica de Área", // Título principal
                "Categorías", // Etiqueta eje X
                "Valores", // Etiqueta eje Y
                dataset, // Conjunto de datos
                PlotOrientation.VERTICAL,// Orientación
                true, // Leyenda
                true, // Tooltips
                false // URLs
        );

        // Actualizar el subtítulo para mostrar "Fuente: <nombre del archivo>" si está disponible
        if (this.archivoSeleccionado != null && !this.archivoSeleccionado.isEmpty()) {
            File f = new File(this.archivoSeleccionado);
            chart.addSubtitle(new TextTitle("Fuente: " + f.getName()));
        }

        // ********* Aquí se cambia el color de las series agregando transparencia *********
        // Se obtiene el CategoryPlot y su renderer
        CategoryPlot plot = chart.getCategoryPlot();
        CategoryItemRenderer renderer = plot.getRenderer();

        // Ejemplo de colores base para cada serie (ajusta según necesites)
        // Se crea el color con transparencia (valor alfa de 128 sobre 255, es decir, 50% de opacidad)
        for (int i = 0; i < dataset.getRowCount(); i++) {
            Color baseColor;
            switch (i) {
                case 0:
                    baseColor = new Color(255, 0, 0);     // Rojo
                    break;
                case 1:
                    baseColor = new Color(0, 255, 0);     // Verde
                    break;
                case 2:
                    baseColor = new Color(0, 0, 255);     // Azul
                    break;
                case 3:
                    baseColor = new Color(255, 165, 0);   // Naranja
                    break;
                default:
                    baseColor = new Color(128, 128, 128); // Gris para el resto
                    break;
            }
            // Crear el color transparente
            Color colorTransparente = new Color(baseColor.getRed(), baseColor.getGreen(), baseColor.getBlue(), 128);
            renderer.setSeriesPaint(i, colorTransparente);
        }
        // *******************************************************************************

        // Generar el ChartPanel y ajustar su tamaño (puedes personalizar la dimensión)
        ChartPanel cp = new ChartPanel(chart);
        cp.setPreferredSize(new Dimension(jPanel1.getWidth(), jPanel1.getHeight()));

        return cp;
    }

    public ArrayList<Cell> conseguirDatosDeColumnaExcell(Sheet hoja, int indiceColumna, int indiceInicio, int indiceFin) {
        ArrayList<Cell> returnAL = new ArrayList<>();

        //lenar el array list
        for (int i = indiceInicio; i < indiceFin; i++) {
            returnAL.add(hoja.getRow(i).getCell(indiceColumna));
        }

        return returnAL;
    }

    private BufferedImage captureComponentImage(Component comp, int scaleFactor) {
        int width = comp.getWidth();
        int height = comp.getHeight();
        // Crear una imagen del tamaño escalado
        BufferedImage img = new BufferedImage(width * scaleFactor, height * scaleFactor, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = img.createGraphics();
        // Aplicar el escalado: por ejemplo, scaleFactor=2 duplicará el tamaño
        g2.scale(scaleFactor, scaleFactor);
        comp.paint(g2);
        g2.dispose();
        return img;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(principalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(principalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(principalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(principalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new principalFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton crearBoton;
    private javax.swing.JButton elegirArchivoBoton;
    private javax.swing.JPanel graficasPane;
    private javax.swing.JScrollPane graficasScrollPane;
    private javax.swing.JButton imprimirAPDFBoton;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel mostrarArchivoLabel;
    private javax.swing.JScrollPane mostrarArchivoScrollPane;
    private javax.swing.JTable mostrarArchivoTable;
    private javax.swing.JPanel mostrarGraficasScrollPane;
    // End of variables declaration//GEN-END:variables
}
