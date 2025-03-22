package com.credable.lms.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Loan Management System API")
                        .description("API Documentation for Loan Management System")
                        .version("v1.0.0")
                        .contact(new Contact()
                                .name("Credable")
                                .url("https://credable.io")
                                .email("tech.hiring@credable.io"))
                        .license(new License()
                                .name("Private")
                                .url("https://credable.io")))
                .servers(List.of(
                        new Server().url("/").description("Local Server"),
                        new Server().url("https://lms-api.credable.io").description("Production Server")))
                .components(new Components()
                        .addSecuritySchemes("basicAuth", new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("basic")
                                .description("Basic Authentication")))
                .addSecurityItem(new SecurityRequirement().addList("basicAuth"));
    }
}
