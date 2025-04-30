package com.nt.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    // General API Info shown in Swagger UI
    @Bean
    public OpenAPI touristOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Tourist Management API")
                        .description("API for managing tourist records")
                        .version("1.0.0"));
    }

    // Grouping the API under a name and matching path
    @Bean
    public GroupedOpenApi touristApiGroup() {
        return GroupedOpenApi.builder()
                .group("tourist-api") // Group name shown in Swagger UI
                .pathsToMatch("/tourist-api/**") // Only include these endpoints
                .build();
    }
}
