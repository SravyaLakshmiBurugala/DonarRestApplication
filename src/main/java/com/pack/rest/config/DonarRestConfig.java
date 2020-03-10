package com.pack.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class DonarRestConfig {
	
	@Bean
	public Docket docketBean()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build()
				.apiInfo(apiEndpoitsInfo());
	}

	private ApiInfo apiEndpoitsInfo() {
		return new ApiInfoBuilder()
				.title("Donar API Documentation")
				.description("Donar Management System")
				.license("Satya 2.0")
				.licenseUrl("www.shekhar.com")
				.version("2.0")
				.contact(new Contact("shekhar","www.shekar.com","shekar@gmailcom"))
				.build();
	}
	

}
