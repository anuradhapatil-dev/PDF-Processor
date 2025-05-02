package com.anuradha.pdfprocessor.pdf_processor.controller;

import com.anuradha.pdfprocessor.pdf_processor.exception.CustomException;
import com.anuradha.pdfprocessor.pdf_processor.service.PdfService;
import com.anuradha.pdfprocessor.pdf_processor.dto.MergeResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/pdf")
public class PdfController {

    private static final Logger log = LoggerFactory.getLogger(PdfController.class);

    @Autowired
    private PdfService pdfService;

    // Endpoint to merge PDF files
    @PostMapping("/merge")
    public ResponseEntity<MergeResponse> mergePdfs(@RequestParam("files") MultipartFile[] files) {
        log.info("Starting PDF merge process with {} files", files.length);  // Log the start of the merge process
        try {
            byte[] mergedPdf = pdfService.mergePdfs(files);  // Call service to merge PDFs
            MergeResponse response = new MergeResponse(mergedPdf);
            log.info("PDF merge completed successfully.");  // Log the successful merge
            return ResponseEntity.ok(response);  // Return the merged PDF in the response
        } catch (CustomException e) {
            log.error("Error during PDF merge: {}", e.getMessage(), e);  // Log the error if merge fails
            throw e;  // Rethrow the exception to be handled by GlobalExceptionHandler
        }
    }

    // Add more endpoints as needed for other PDF operations (e.g., split, compress, etc.)
}
