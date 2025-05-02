package com.anuradha.pdfprocessor.pdf_processor.service.impl;

import com.anuradha.pdfprocessor.pdf_processor.service.PdfService;
import com.anuradha.pdfprocessor.pdf_processor.util.PdfMergeUtil;
import com.anuradha.pdfprocessor.pdf_processor.exception.CustomException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Service
public class PdfServiceImpl implements PdfService {

    private static final Logger log = LoggerFactory.getLogger(PdfServiceImpl.class);

    @Override
    public byte[] mergePdfs(MultipartFile[] files) {
        try {
            log.info("Merging {} PDF files", files.length);
            PdfMergeUtil util = new PdfMergeUtil();
            byte[] result = util.mergePdfs(files);
            return result;  // Calling the merge method
        } catch (IOException e) {
            log.error("Error during PDF merge", e);  // Handle IOException specifically
            throw new CustomException("Failed to merge PDFs due to I/O error.", e);
        } catch (Exception e) {
            log.error("Unexpected error during PDF merge", e);  // Catch any other exceptions
            throw new CustomException("Failed to merge PDFs. Please check your files.", e);
        }
    }
}
