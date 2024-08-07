package com.labs.iw.library.config;

import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
@EnableWebMvc
public class SwaggerConfig {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("API Documentation")
						.version("1.0")
						.description("API documentation for the CRUD template project using Spring Boot 3"));
	}

	@Bean
	public OpenApiCustomizer customerGlobalHeaderOpenApiCustomizer() {
		return openApi -> openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(operation -> {
			operation.addTagsItem("default");
		}));
	}
}