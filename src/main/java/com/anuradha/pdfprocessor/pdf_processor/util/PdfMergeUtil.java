package com.anuradha.pdfprocessor.pdf_processor.util;

import com.anuradha.pdfprocessor.pdf_processor.exception.CustomException;
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.springframework.web.multipart.MultipartFile;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.multipdf.PDFMergerUtility;

import java.io.ByteArrayOutputStream;
import java.io.IOException;


public class PdfMergeUtil {

    // Non-static merge method
    public byte[] mergePdfs(MultipartFile[] files) throws IOException {

        PDFMergerUtility merger = new PDFMergerUtility();

        for (MultipartFile file : files) {
            if (file == null || file.isEmpty()) {
                throw new CustomException("One or more uploaded files are missing or empty.");
            }

            try (PDDocument doc = PDDocument.load(file.getInputStream())) {
                merger.addSource(file.getInputStream());
            } catch (IOException e) {
                throw new CustomException("One of the files is not a valid PDF: " + file.getOriginalFilename());
            }
        }

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            merger.setDestinationStream(outputStream);
            merger.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
            return outputStream.toByteArray();
        }
    }

}
