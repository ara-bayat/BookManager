package com.ara.BookManager.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//added for swagger
@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customStoreOpenAPI() {
        return new OpenAPI().info(new Info().title("Book Manager")
                .version("1.0").title("Book Manager"));
    }
}
