package com.yofc.framework.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

//@Configuration
public class Swagger2Configuration {

    @Value("${roger.swagger2.header.basePackage}")
    protected String basePackage = "com.yofc";

    @Value("${roger.swagger2.header.title}")
    protected String title = "mobile cloud service";

    @Value("${roger.swagger2.header.description}")
    protected String description = "--------------------------------";

    @Value("${roger.swagger2.header.termsOfServiceUrl}")
    protected String termsOfServiceUrl = "";

    @Value("${roger.swagger2.header.author}")
    protected String author = "Roger";

    @Value("${roger.swagger2.header.version}")
    protected String version = "0.1";

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .termsOfServiceUrl(termsOfServiceUrl)
                .contact(author)
                .version(version)
                .build();
    }
}
