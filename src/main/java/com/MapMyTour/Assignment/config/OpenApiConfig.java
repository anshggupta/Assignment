package com.MapMyTour.Assignment.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI api() {
        return new OpenAPI().info(
                new Info().title("Tour Service API")
                        .version("v1")
                        .description("Manage tour packages")
                )
                .externalDocs(new ExternalDocumentation().description("API Docs").url("/swagger-ui/index.html"));
    }
}
