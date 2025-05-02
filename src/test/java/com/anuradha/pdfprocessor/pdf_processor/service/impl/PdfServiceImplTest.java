package com.anuradha.pdfprocessor.pdf_processor.service.impl;

import com.anuradha.pdfprocessor.pdf_processor.exception.CustomException;
import com.anuradha.pdfprocessor.pdf_processor.util.PdfMergeUtil;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PdfServiceImplTest {

    @Mock
    private PdfMergeUtil pdfMergeUtil;

    @InjectMocks
    private PdfServiceImpl pdfService;

    @Test
    public void testMergePdfs_Success() throws IOException {
        try (
                InputStream inputStream1 = new FileInputStream("C:/anu/se2_projects/file3.pdf");
                InputStream inputStream2 = new FileInputStream("C:/anu/se2_projects/file2.pdf")
        ) {
            MultipartFile file1 = new MockMultipartFile("file1", "file1.pdf", "application/pdf", inputStream1.readAllBytes());
            MultipartFile file2 = new MockMultipartFile("file2", "file2.pdf", "application/pdf", inputStream2.readAllBytes());
            MultipartFile[] files = new MultipartFile[] { file1, file2 };

            // Call actual merge method
            PdfMergeUtil realUtil = new PdfMergeUtil();
            byte[] mergedPdf = realUtil.mergePdfs(files);

            // Assert result is not null
            assertNotNull(mergedPdf);

            // Assert merged PDF has expected page count
            try (PDDocument mergedDoc = PDDocument.load(mergedPdf)) {
                assertEquals(4, mergedDoc.getNumberOfPages());
            }
        }
    }

}
