package com.example.FirstStep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;*/


@SpringBootApplication
public class FirstStepApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstStepApplication.class, args);
	}
	
	
	
	//http://localhost:8084/swagger-ui/#/
	/*
	 * @Bean public Docket swaggerConfirguration() { return new
	 * Docket(DocumentationType.SWAGGER_2) .select()
	 * .paths(PathSelectors.ant("/cloudvendordb/*"))
	 * .apis(RequestHandlerSelectors.basePackage("com.example.FirstStep")) .build()
	 * .apiInfo(apiCustomerData());
	 * 
	 * }
	 * 
	 * private ApiInfo apiCustomerData() { return new ApiInfo(
	 * "Cloud Vendor API Application", "Cloud Vendor Documention", "1.0",
	 * "Cloud Vendor Service Terms", new Contact("Shri", "http://StrangerShri.com",
	 * "shri@gmail.com"), "Stranger Shri License",
	 * "http://StrangerShri.com",Collections.emptyList()); }
	 */
}
