package com.example.backendDevTest.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The type Swagger config.
 */
@Configuration
public class SwaggerConfig {
    /**
     * Api grouped open api.
     *
     * @return the grouped open api
     */
    @Bean
    public GroupedOpenApi api() {
        return GroupedOpenApi.builder()
                .group("api-web")
                .packagesToScan("com.example.backendDevTest.web")
                .build();
    }

    /**
     * Api info open api.
     *
     * @return the open api
     */
    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new Info().title("backendDevTest")
                        .description("Solution to the interview backendDevTest")
                        .version("1.0.0-SNAPSHOT")
                );
    }
}
