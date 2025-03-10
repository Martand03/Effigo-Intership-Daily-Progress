package com.inEffigo.fileStorageInAzure.service;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class PdfService {

    public File convertExcelToPdf(MultipartFile excelFile) throws IOException {

        String originalFilename = excelFile.getOriginalFilename();
        if (originalFilename == null || !originalFilename.contains(".")) {
            throw new IllegalArgumentException("Invalid file name: " + originalFilename);
        }


        String pdfFileName = originalFilename.substring(0, originalFilename.lastIndexOf(".")) + ".pdf";
        File pdfFile = new File(pdfFileName);

        try (Workbook workbook = new XSSFWorkbook(excelFile.getInputStream());
             FileOutputStream fos = new FileOutputStream(pdfFile);
             PdfWriter writer = new PdfWriter(fos);
             PdfDocument pdfDoc = new PdfDocument(writer);
             Document document = new Document(pdfDoc)) {

            Sheet sheet = workbook.getSheetAt(0);

            // Get column count and define table structure
            int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();
            float[] columnWidths = new float[columnCount];
            for (int i = 0; i < columnCount; i++) {
                columnWidths[i] = 100f; // Adjust column width as needed
            }

            Table table = new Table(columnWidths);

            // Read data from Excel and add it to the table
            for (Row row : sheet) {
                for (Cell cell : row) {
                    // Fully qualify iText Cell to avoid conflicts
                    table.addCell(new com.itextpdf.layout.element.Cell().add(new Paragraph(cell.toString())));
                }
            }

            document.add(table);
        }

        return pdfFile;
    }
}
