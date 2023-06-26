package org.jsp.bootcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="BootCrud",description="This is sample project"))
public class BootCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootCrudApplication.class, args);
	}

}
