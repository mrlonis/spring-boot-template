package com.mrlonis.configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final String COM_MRLONIS = "com.mrlonis";

    @Bean
    public Docket getCurrentInvoiceApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("1. Services")
                                                      .apiInfo(this.metaData())
                                                      .securitySchemes(Collections.singletonList(this.initApiKey()))
                                                      .securityContexts(Collections.singletonList(this.buildSecurityContext()))
                                                      .select()
                                                      .apis(RequestHandlerSelectors.basePackage(COM_MRLONIS))
                                                      .paths(PathSelectors.any())
                                                      .build();
    }

    private ApiKey initApiKey() {
        return new ApiKey("Authorization", "Authorization", "header");
    }

    private SecurityContext buildSecurityContext() {
        return SecurityContext.builder()
                              .securityReferences(this.defaultAuthorization())
                              .operationSelector((each) -> true)
                              .build();
    }

    private List<SecurityReference> defaultAuthorization() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Collections.singletonList(new SecurityReference("", authorizationScopes));
    }

    private ApiInfo metaData() {
        return new ApiInfo("PCF Spring Boot Project Template",
                           "API Documentation",
                           "1.0",
                           "Terms of service",
                           new Contact("Matthew Lonis", "https://github.com/mrlonis", "mattlonis@gmail.com"),
                           "Apache License Version 2.0",
                           "https://www.apache.org/licenses/LICENSE-2.0",
                           new ArrayList<>());
    }
}
