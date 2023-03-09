package com.biblioteca.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfiguracion {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(detalles())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo detalles(){
        return new ApiInfo("Biblioteca Api Rest",
                "El sistema busca automatizar el comportamiento de un bibliotecario cuando un usuario desea prestar un libro.",
                "1.0",
                "www.google.com",
                new Contact("Santiago Andres Manrique", "https://github.com/bysantiago6117", "santiagomanriq.lopez@gmail.com"),
                "MIT",
                "www.google.com",
                Collections.EMPTY_LIST);
    }


}
