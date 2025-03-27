package com.example.productService.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI productServiceDoc() {
        return new OpenAPI()
                .info(new Info().title("Product Service API")
                        .description("This is the REST AI for product service")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0")))
                .externalDocs(new ExternalDocumentation()
                        .description("you can refer to the product Service Wiki Documentation")
                        .url("https://this-is-fake-product-service-documentation-url.com/docs"));
    }
}
