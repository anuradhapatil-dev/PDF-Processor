package com.anuradha.pdfprocessor.pdf_processor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                       // Lombok: getters, setters, toString, equals, hashCode
@AllArgsConstructor         // constructor with all fields
@NoArgsConstructor          // default constructor (for serialization)
public class MergeResponse {
    private String message;     // e.g. "PDFs merged successfully"
    private byte[] mergedPdf;   // useful for logging, validation


    // Default constructor
    public MergeResponse() {
    }

    // Constructor accepting the merged PDF byte array
    public MergeResponse(byte[] mergedPdf) {
        this.mergedPdf = mergedPdf;
    }

    // Getter for mergedPdf
    public byte[] getMergedPdf() {
        return mergedPdf;
    }

    // Setter for mergedPdf
    public void setMergedPdf(byte[] mergedPdf) {
        this.mergedPdf = mergedPdf;
    }
}