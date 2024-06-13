package com.example.msinventario.util;

import com.example.msinventario.entity.Inventario;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class PdfUtils {
    public static ByteArrayOutputStream generatePdfStream(List<Inventario> inventarios
    ) throws DocumentException {
        Document document = new Document();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, outputStream);
        document.open();

        // Título del documento
        Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
        Paragraph title = new Paragraph("Boleta de Venta de Libros", titleFont);
        title.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(title);
        // Write column names
        // Map<String, Object> firstRow = queryResults.get(0);
        for (Inventario inventario : inventarios) {
            Font boldFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
            Paragraph paragraph = new Paragraph(inventario.getNombre(), boldFont);
            document.add(paragraph);
        }
        document.add(new Paragraph("\n"));
        // Write data rows
        /*for (Map<String, Object> row : queryResults) {
            for (Object value : row.values()) {
                Paragraph paragraph = new Paragraph(value.toString());
                document.add(paragraph);
            }
            document.add(new Paragraph("\n"));
        }*/
        document.close();
        return outputStream;
    }
}
