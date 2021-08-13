package com.weekend.drive.interview.documentation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
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
	
	HashSet<String> consumesAndProduces = new HashSet<String>(Arrays.asList("application/json"));
	
	private ApiKey apiKey() { 
	    return new ApiKey("JWT", "Authorization", "header"); 
	}
	
	
	private SecurityContext securityContext() { 
	    return SecurityContext.builder().securityReferences(defaultAuth()).build(); 
	} 

	private List<SecurityReference> defaultAuth() { 
	    AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything"); 
	    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1]; 
	    authorizationScopes[0] = authorizationScope; 
	    return Arrays.asList(new SecurityReference("JWT", authorizationScopes)); 
	}
	
	@Bean
	public Docket api() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(metadata())
				.consumes(consumesAndProduces)
				.produces(consumesAndProduces)
				.pathMapping("/")
				.securityContexts(Arrays.asList(securityContext()))
			    .securitySchemes(Arrays.asList(apiKey()));
	}
	
	@Bean
	public Docket apiV1() {
	    return new Docket(DocumentationType.SWAGGER_2)
	        .groupName("api-1.0")
	        .securityContexts(Arrays.asList(securityContext()))
	        .securitySchemes(Arrays.asList(apiKey()))
	        .select()
	            .apis(RequestHandlerSelectors.basePackage("com.weekend.drive.interview.controller"))
	            .paths(PathSelectors.ant("/api/interview/v1/*"))
	        .build()
	        .apiInfo(metadata())
	        .consumes(consumesAndProduces)
			.produces(consumesAndProduces);
	}
	
	@Bean
	public Docket apiV2() {
	    return new Docket(DocumentationType.SWAGGER_2)
	        .groupName("api-2.0")
	        .securityContexts(Arrays.asList(securityContext()))
	        .securitySchemes(Arrays.asList(apiKey()))
	        .select()
	            .apis(RequestHandlerSelectors.basePackage("com.weekend.drive.interview.controller"))
	            .paths(PathSelectors.ant("/api/interview/v2/*"))
	        .build()
	        .apiInfo(metadata())
	        .consumes(consumesAndProduces)
			.produces(consumesAndProduces);
	}

	private ApiInfo metadata() {
		return new ApiInfoBuilder()
				.title("Interview-Mini-Project")
				.description("Interview Scheduler Api")
				.version("1.0")
				.contact(new Contact("Himanshu", "http://anblicks.com",
						"hr@anblicks.com"))
				.license("Apache 2.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
				.build();
	}
	
}