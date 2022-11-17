package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;


@EnableEurekaClient
@EnableSwagger2
@SpringBootApplication
public class MsBillingApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsBillingApplication.class, args);
    }

    @Bean
    public Docket swaggerConfiguration() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo"))
                .paths(PathSelectors.ant("/**"))
                .build()
                .apiInfo(ApiDocumentationInfo());
    }

    private ApiInfo ApiDocumentationInfo(){
        return new ApiInfo(
                "Billing service API",
                "API for ENICARTHAGE SOC project",
                "1.0",
                "free to use",
                new springfox.documentation.service.Contact("DRISSI Houcem eddine" , "https://github.com/drissi2002","houssemmedine.drissi@enicar.ucar.tn"),
                "ENICARTHAGE API LICENSE",
                "http://www.enicarthage.rnu.tn",
                Collections.emptyList());
    }


}
