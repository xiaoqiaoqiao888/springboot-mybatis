package com.rails.config;

import static springfox.documentation.builders.PathSelectors.regex;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

	@Bean
	public Docket petApi() {
		return new Docket(DocumentationType.SWAGGER_2)//
				.select()//
				.apis(RequestHandlerSelectors.any())//
				.paths(regex("/api/v1.*"))//
				.build()//
				.pathMapping("/")//
				.directModelSubstitute(LocalDate.class, String.class)//
				.genericModelSubstitutes(ResponseEntity.class)//
				.useDefaultResponseMessages(false)//
				.enableUrlTemplating(false)
				.apiInfo(apiInfo());//
	}

	private ApiInfo apiInfo() {
		Contact contact = new Contact("EMPLOYEE服务", "", "qdj@rails.com");
		return new ApiInfoBuilder()//
				.title("EMPLOYEE提供的Api")//
				.description("EMPLOYEE服务接口说明")//
				.license("Rails License Version 2.0")//
				.contact(contact)//
				.version("2.0")//
				.build();
	}
}
