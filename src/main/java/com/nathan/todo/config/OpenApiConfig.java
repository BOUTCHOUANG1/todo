
package com.nathan.todo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // Marks this class as a configuration class.
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        Contact contact = new Contact();
        contact.setEmail("boutchouangelija@gmail.com");
        contact.setName("Boutchouang Nathan Elija");

        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");
        // Create and return a customized OpenAPI instance.
        return new OpenAPI()
                .info(new Info()
                        .title("To-Do List API")
                        .version("1.0")
                        .contact(contact)
                        .description("API for managing tasks (To-Do List) in my Spring Boot application.")
                        .license(mitLicense));
    }
}

