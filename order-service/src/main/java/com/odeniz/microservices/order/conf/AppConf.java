package com.odeniz.microservices.order.conf;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConf {

    @Bean
    public OpenAPI orderServiceApi() {
        return new OpenAPI()
                .info(new Info().title("Order Service API")
                        .description("This is Rest Api for Order Service")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0")))
                .externalDocs(new ExternalDocumentation()
                        .description("You can refer to Order service Wiki Document")
                        .url("https://order-service-dummy-url.com/docs"));
    }
}
