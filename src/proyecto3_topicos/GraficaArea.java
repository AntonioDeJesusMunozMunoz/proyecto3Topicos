package proyecto3_topicos;

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
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class GraficaArea extends JFrame {

    private File archivo;
    private JFreeChart chart;
    private ChartPanel chartPanel;

    public GraficaArea(File archivo) {
        super("Gráfica de área");
        this.archivo = archivo;
        setSize(800, 580);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        crearGrafico();
        agregarBotonPDF();
        //setVisible(true);
    }

    /**
     * Método auxiliar para convertir un string a número (double). Se intenta la
     * conversión directa; si falla, se reemplaza la coma por punto.
     */
    private double parseDoubleFromString(String str) throws NumberFormatException {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return Double.parseDouble(str.replace(",", "."));
        }
    }

    private void crearGrafico() {
        // Mapa para almacenar las series y sus sumas acumuladas por categoría.
        // Estructura: { serie : { categoría : suma de valores } }
        Map<String, Map<String, Double>> seriesData = new HashMap<>();
        // Conjunto de todas las categorías (para el eje X)
        Set<String> categorias = new HashSet<>();

        // Detectar la extensión del archivo y procesarlo según corresponda:
        String ext = getFileExtension(archivo.getName());
        boolean error = false;
        if (ext.equalsIgnoreCase("csv")) {
            error = procesarCSV(archivo, seriesData, categorias);
        } else if (ext.equalsIgnoreCase("xls") || ext.equalsIgnoreCase("xlsx")) {
            error = procesarExcel(archivo, seriesData, categorias);
        } else {
            error = true;
            JOptionPane.showMessageDialog(this, "Formato de archivo no reconocido: " + archivo.getName());
        }

        if (!error) {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();

            // Rellenar el dataset usando las sumas acumuladas
            for (String categoria : categorias) {
                for (String serie : seriesData.keySet()) {
                    double sum = seriesData.get(serie).getOrDefault(categoria, 0.0);
                    dataset.addValue(sum, serie, categoria);
                }
            }

            // Crear el gráfico de área utilizando el dataset
            chart = ChartFactory.createAreaChart(
                    "Gráfica", // Título del gráfico
                    "Categorías", // Etiqueta eje X
                    "Valores", // Etiqueta eje Y
                    dataset, // Conjunto de datos
                    PlotOrientation.VERTICAL,// Orientación
                    true, // Leyenda
                    true, // Tooltips
                    false // URLs
            );

            TextTitle subtitle = new TextTitle("Fuente: " + archivo.getName());
            chart.addSubtitle(subtitle);

            // Calcular el valor máximo para ajustar el rango del eje Y (con un 10% extra de margen)
            double maxValue = 0.0;
            for (String categoria : categorias) {
                for (String serie : seriesData.keySet()) {
                    double sum = seriesData.get(serie).getOrDefault(categoria, 0.0);
                    if (sum > maxValue) {
                        maxValue = sum;
                    }
                }
            }
            CategoryPlot plot = chart.getCategoryPlot();
            NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
            rangeAxis.setRange(0, maxValue * 1.1);

            // Configurar la transparencia en los colores de las áreas
            CategoryItemRenderer areaRenderer = plot.getRenderer();
            int seriesCount = dataset.getRowCount();
            Color[] baseColors = {
                Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE,
                Color.MAGENTA, Color.CYAN, Color.YELLOW
            };
            for (int i = 0; i < seriesCount; i++) {
                Color base = baseColors[i % baseColors.length];
                Color transparentColor = new Color(base.getRed(), base.getGreen(), base.getBlue(), 128);
                areaRenderer.setSeriesPaint(i, transparentColor);
            }

            // --- SUPERPONER UN RENDERER PARA MOSTRAR LOS PUNTOS CON TOOLTIP ---
            // Se utiliza un renderer especial para el dataset 1 que NO devuelve legend items
            LineAndShapeRenderer shapeRenderer = new LineAndShapeRenderer() {
                @Override
                public org.jfree.chart.LegendItem getLegendItem(int datasetIndex, int series) {
                    // Evitamos que el renderer de puntos genere ítems en la leyenda
                    return null;
                }
            };
            shapeRenderer.setDefaultShapesVisible(true);
            shapeRenderer.setDefaultLinesVisible(false);
            shapeRenderer.setDefaultToolTipGenerator(new StandardCategoryToolTipGenerator());

            // Asignar los mismos colores de las series para mantener la consistencia
            for (int i = 0; i < seriesCount; i++) {
                shapeRenderer.setSeriesPaint(i, areaRenderer.getSeriesPaint(i));
            }
            // Asignar el mismo dataset al segundo renderer para superponer los puntos
            plot.setDataset(1, dataset);
            plot.setRenderer(1, shapeRenderer);
            // Fijar la leyenda usando únicamente los ítems del renderer del dataset 0 para evitar duplicados
            LegendItemCollection lic = plot.getRenderer(0).getLegendItems();
            plot.setFixedLegendItems(lic);

            ChartPanel panel = new ChartPanel(chart, false);
            panel.setBounds(10, 20, 760, 450);
            add(panel);
        } else {
            JLabel lblError = new JLabel("Error al procesar el archivo.");
            lblError.setBounds(10, 20, 760, 30);
            add(lblError);
        }
    }

    /**
     * Agrega un botón al frame que permite guardar la gráfica y los datos base
     * en un PDF.
     */
    private void agregarBotonPDF() {
        JButton btnExportPDF = new JButton("Guardar a PDF");
        btnExportPDF.setBounds(10, 480, 150, 30);
        btnExportPDF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exportChartToPDF();
            }
        });
        add(btnExportPDF);
    }

    /**
     * Exporta la gráfica a un PDF y, en una nueva página, inserta una tabla con
     * el contenido del archivo base.
     */
    private void exportChartToPDF() {
        try {
            int width = 760;
            int height = 450;
            BufferedImage chartImage = chart.createBufferedImage(width, height);

            // Convertir la imagen del gráfico a un arreglo de bytes en formato PNG
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(chartImage, "png", baos);
            baos.flush();
            byte[] imageBytes = baos.toByteArray();
            baos.close();

            // Crear el objeto Image de iText a partir del arreglo de bytes
            Image pdfImage = Image.getInstance(imageBytes);
            pdfImage.scaleToFit(PageSize.A4.getWidth() - 50, PageSize.A4.getHeight() - 50);

            // Crear el documento PDF y asociarlo a un PdfWriter
            Document document = new Document(PageSize.A4);
            String outputPath = System.getProperty("user.home") + File.separator
                    + "Downloads" + File.separator + "chart.pdf";
            PdfWriter.getInstance(document, new FileOutputStream(outputPath));
            document.open();

            // Agregar la imagen del gráfico en la primera página
            document.add(pdfImage);

            // Agregar una nueva página para los datos base
            document.newPage();
            addBaseFileDataToPDF(document);

            document.close();
            JOptionPane.showMessageDialog(this, "PDF guardado en:\n" + outputPath);
        } catch (IOException | DocumentException ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar PDF: " + ex.getMessage());
        }
    }

    /**
     * Agrega al documento PDF una tabla que representa el contenido del archivo
     * base. Se detecta si el archivo es CSV o Excel (XLS/XLSX) y se procesa en
     * consecuencia.
     */
    private void addBaseFileDataToPDF(Document document) throws DocumentException, IOException {
        String ext = getFileExtension(archivo.getName()).toLowerCase();

        // Agregar un título para la sección de datos base
        Paragraph title = new Paragraph("Datos Base");
        document.add(title);

        if (ext.equals("csv")) {
            // Procesar CSV: leer línea a línea y crear una tabla
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String line;
            PdfPTable table = null;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                // Determinar el delimitador: si tiene ";" se usa ese, de lo contrario ","
                String[] tokens;
                if (line.contains(";")) {
                    tokens = line.split(";");
                } else {
                    tokens = line.split(",");
                }
                if (table == null) {
                    table = new PdfPTable(tokens.length);
                }
                for (String token : tokens) {
                    PdfPCell cell = new PdfPCell(new Paragraph(token.trim()));
                    table.addCell(cell);
                }
            }
            br.close();
            if (table != null) {
                document.add(table);
            }
        } else if (ext.equals("xls") || ext.equals("xlsx")) {
            // Procesar Excel: usar Apache POI para leer la primera hoja y crear una tabla PDF
            FileInputStream fis = new FileInputStream(archivo);
            Workbook workbook;
            if (ext.equals("xlsx")) {
                workbook = new XSSFWorkbook(fis);
            } else {
                workbook = new HSSFWorkbook(fis);
            }
            Sheet sheet = workbook.getSheetAt(0);
            int numColumns = 0;
            Row firstRow = sheet.getRow(sheet.getFirstRowNum());
            if (firstRow != null) {
                numColumns = firstRow.getLastCellNum();
            }
            PdfPTable table = new PdfPTable(numColumns);
            // Recorrer todas las filas
            for (Row row : sheet) {
                for (int i = 0; i < numColumns; i++) {
                    Cell cell = row.getCell(i, MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    PdfPCell pdfCell = new PdfPCell(new Paragraph(cell.toString()));
                    table.addCell(pdfCell);
                }
            }
            workbook.close();
            fis.close();
            document.add(table);
        } else {
            // Si llegara otro formato, se puede agregar un mensaje
            Paragraph p = new Paragraph("El formato del archivo base no es compatible para mostrar en PDF.");
            document.add(p);
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

    /**
     * Procesa archivos CSV. Soporta dos formatos: - Formato de 2 columnas (con
     * o sin encabezado): Columna 0: Categoría (ej. Entidad federativa) Columna
     * 1: Valor numérico (double) (ej. 13,5 o 13.5) - Formato de 3 columnas:
     * Columna 0: Valor numérico (double) Columna 1: Serie Columna 2: Categoría
     */
    private boolean procesarCSV(File file, Map<String, Map<String, Double>> seriesData, Set<String> categorias) {
        boolean error = false;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            boolean headerProcessed = false;
            String[] headerSeries = null; // Para el caso de múltiples series con encabezado
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                // Determinar el delimitador: si contiene ";" se usa ese; en caso contrario, se asume ","
                String[] tokens = line.contains(";") ? line.split(";") : line.split(",");
                if (!headerProcessed) {
                    // Intentamos convertir el primer token a número:
                    try {
                        parseDoubleFromString(tokens[0].trim());
                        // Si se pudo convertir, no hay encabezado; usamos la lógica antigua:
                        headerProcessed = true;
                        if (tokens.length == 2) {
                            // Formato: Categoría;Valor (una sola serie)
                            String category = tokens[0].trim();
                            double value = parseDoubleFromString(tokens[1].trim());
                            categorias.add(category);
                            seriesData.computeIfAbsent("Datos", k -> new HashMap<>());
                            Map<String, Double> map = seriesData.get("Datos");
                            map.put(category, map.getOrDefault(category, 0.0) + value);
                        } else if (tokens.length >= 3) {
                            // Formato: Valor;Serie;Categoría (la lógica antigua para 3 columnas)
                            double value = parseDoubleFromString(tokens[0].trim());
                            String series = tokens[1].trim();
                            String category = tokens[2].trim();
                            categorias.add(category);
                            seriesData.computeIfAbsent(series, k -> new HashMap<>());
                            Map<String, Double> map = seriesData.get(series);
                            map.put(category, map.getOrDefault(category, 0.0) + value);
                        }
                    } catch (NumberFormatException e) {
                        // El primer token NO es numérico, asumiendo que se trata de una fila header
                        headerSeries = tokens;
                        headerProcessed = true;
                        // No procesamos esta línea, ya que es el encabezado.
                        continue;
                    }
                } else {
                    // Si headerSeries != null, es que se detectó un encabezado.
                    if (headerSeries != null) {
                        // Formato: [Categoría, Serie1, Serie2, ..., SerieN]
                        if (tokens.length < 1) {
                            continue;
                        }
                        String category = tokens[0].trim();
                        categorias.add(category);
                        // Para cada columna de serie, desde la columna 1 hasta min(headerSeries.length, tokens.length)
                        int cols = Math.min(headerSeries.length, tokens.length);
                        for (int i = 1; i < cols; i++) {
                            String series = headerSeries[i].trim();
                            double value;
                            try {
                                value = parseDoubleFromString(tokens[i].trim());
                            } catch (NumberFormatException ex) {
                                continue;
                            }
                            seriesData.computeIfAbsent(series, k -> new HashMap<>());
                            Map<String, Double> map = seriesData.get(series);
                            map.put(category, map.getOrDefault(category, 0.0) + value);
                        }
                    } else {
                        // Si no hubo encabezado, se usa la lógica antigua:
                        if (tokens.length == 2) {
                            String category = tokens[0].trim();
                            double value;
                            try {
                                value = parseDoubleFromString(tokens[1].trim());
                            } catch (NumberFormatException e) {
                                continue;
                            }
                            categorias.add(category);
                            seriesData.computeIfAbsent("Datos", k -> new HashMap<>());
                            Map<String, Double> map = seriesData.get("Datos");
                            map.put(category, map.getOrDefault(category, 0.0) + value);
                        } else if (tokens.length >= 3) {
                            double value;
                            try {
                                value = parseDoubleFromString(tokens[0].trim());
                            } catch (NumberFormatException e) {
                                continue;
                            }
                            String series = tokens[1].trim();
                            String category = tokens[2].trim();
                            categorias.add(category);
                            seriesData.computeIfAbsent(series, k -> new HashMap<>());
                            Map<String, Double> map = seriesData.get(series);
                            map.put(category, map.getOrDefault(category, 0.0) + value);
                        }
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            error = true;
            JOptionPane.showMessageDialog(this, "Error al leer el archivo: " + file.getName());
        }
        return error;
    }

    /**
     * Procesa archivos Excel (XLS y XLSX). Soporta dos formatos: - Formato de 2
     * columnas (con o sin encabezado): Columna 0: Categoría Columna 1: Valor
     * numérico (double) - Formato de 3 columnas: Columna 0: Valor numérico
     * (double) Columna 1: Serie Columna 2: Categoría
     */
    private boolean procesarExcel(File file, Map<String, Map<String, Double>> seriesData, Set<String> categorias) {
        boolean error = false;
        try (FileInputStream fis = new FileInputStream(file)) {
            Workbook workbook;
            if (file.getName().toLowerCase().endsWith("xlsx")) {
                workbook = new XSSFWorkbook(fis);
            } else {
                workbook = new HSSFWorkbook(fis);
            }
            Sheet sheet = workbook.getSheetAt(0);
            boolean headerProcessed = false;
            boolean hasHeader = false;
            int startRow = sheet.getFirstRowNum();
            Row firstRow = sheet.getRow(startRow);
            String[] headerSeries = null;
            if (firstRow != null) {
                int cellCount = firstRow.getLastCellNum();
                // Intentamos leer la primera celda; si no es numérica, asumimos que hay encabezado
                try {
                    firstRow.getCell(0, MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
                    // Si se puede leer un número, no hay encabezado.
                } catch (Exception e) {
                    hasHeader = true;
                    headerSeries = new String[cellCount - 1];
                    for (int i = 1; i < cellCount; i++) {
                        headerSeries[i - 1] = firstRow.getCell(i, MissingCellPolicy.CREATE_NULL_AS_BLANK).toString().trim();
                    }
                    headerProcessed = true;
                    startRow++;
                }
            }
            // Procesar las filas
            for (int i = startRow; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) {
                    continue;
                }
                // Si hay header, asumimos que la primera columna es la categoría y las siguientes son series.
                if (hasHeader) {
                    String category = row.getCell(0, MissingCellPolicy.CREATE_NULL_AS_BLANK).toString().trim();
                    categorias.add(category);
                    int totalCells = row.getLastCellNum();
                    // Recorrer desde la columna 1 hasta el número mínimo entre headerSeries y las celdas disponibles
                    int limit = Math.min(headerSeries.length + 1, totalCells);
                    for (int j = 1; j < limit; j++) {
                        Cell cell = row.getCell(j, MissingCellPolicy.CREATE_NULL_AS_BLANK);
                        double value;
                        try {
                            value = cell.getNumericCellValue();
                        } catch (Exception ex) {
                            try {
                                value = parseDoubleFromString(cell.toString().trim());
                            } catch (Exception e2) {
                                continue;
                            }
                        }
                        String seriesName = headerSeries[j - 1];
                        seriesData.computeIfAbsent(seriesName, k -> new HashMap<>());
                        Map<String, Double> map = seriesData.get(seriesName);
                        map.put(category, map.getOrDefault(category, 0.0) + value);
                    }
                } else {
                    // No hay encabezado: procesar según la lógica antigua.
                    int cellCount = row.getLastCellNum();
                    if (cellCount == 2) {
                        // Formato: Categoría;Valor
                        Cell cellCat = row.getCell(0, MissingCellPolicy.CREATE_NULL_AS_BLANK);
                        Cell cellVal = row.getCell(1, MissingCellPolicy.CREATE_NULL_AS_BLANK);
                        String category = cellCat.toString().trim();
                        double value;
                        try {
                            value = cellVal.getNumericCellValue();
                        } catch (Exception ex) {
                            try {
                                value = parseDoubleFromString(cellVal.toString().trim());
                            } catch (Exception e2) {
                                continue;
                            }
                        }
                        categorias.add(category);
                        seriesData.computeIfAbsent("Datos", k -> new HashMap<>());
                        Map<String, Double> map = seriesData.get("Datos");
                        map.put(category, map.getOrDefault(category, 0.0) + value);
                    } else if (cellCount >= 3) {
                        // Formato: Valor;Serie;Categoría
                        Cell cellVal = row.getCell(0, MissingCellPolicy.CREATE_NULL_AS_BLANK);
                        double value;
                        try {
                            value = cellVal.getNumericCellValue();
                        } catch (Exception ex) {
                            try {
                                value = parseDoubleFromString(cellVal.toString().trim());
                            } catch (Exception e2) {
                                continue;
                            }
                        }
                        Cell cellSerie = row.getCell(1, MissingCellPolicy.CREATE_NULL_AS_BLANK);
                        String series = cellSerie.toString().trim();
                        Cell cellCat = row.getCell(2, MissingCellPolicy.CREATE_NULL_AS_BLANK);
                        String category = cellCat.toString().trim();
                        categorias.add(category);
                        seriesData.computeIfAbsent(series, k -> new HashMap<>());
                        Map<String, Double> map = seriesData.get(series);
                        map.put(category, map.getOrDefault(category, 0.0) + value);
                    }
                }
            }
            workbook.close();
        } catch (IOException ex) {
            error = true;
            JOptionPane.showMessageDialog(this, "Error al leer el archivo: " + file.getName());
        }
        return error;
    }

}

