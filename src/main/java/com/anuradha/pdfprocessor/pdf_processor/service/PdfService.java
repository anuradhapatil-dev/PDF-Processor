package com.anuradha.pdfprocessor.pdf_processor.service;

import org.springframework.web.multipart.MultipartFile;

public interface PdfService {
    byte[] mergePdfs(MultipartFile[] files);
}
