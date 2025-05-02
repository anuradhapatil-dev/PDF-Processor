package com.anuradha.pdfprocessor.pdf_processor.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("PDF Processor API")
                        .version("1.0")
                        .description("API documentation for core and advanced PDF operations including merge, split, compress, and more."));
    }
}

