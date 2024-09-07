package com.tastekine.workshop_mongodb;

import com.tastekine.workshop_mongodb.workshop1.Address;
import com.tastekine.workshop_mongodb.workshop1.Gender;
import com.tastekine.workshop_mongodb.workshop1.Student;
import com.tastekine.workshop_mongodb.workshop1.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
@EnableSwagger2
public class WorkshopMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkshopMongodbApplication.class, args);
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)).paths(PathSelectors.any())
				.build().apiInfo(apiInfo()).useDefaultResponseMessages(false);
	}

	@Bean
	public ApiInfo apiInfo() {
		final ApiInfoBuilder builder = new ApiInfoBuilder();
		return builder.build();
	}

	@Bean
	CommandLineRunner runner(StudentRepository repository) {
		Address address = null;
		address.builder().city("Istanbul").country("Turkey").postCode("34440").build();

		return args -> {
			Student student = new Student(
					"Erhan",
					"Tastekin",
					"erhantastekin1@gmail.com",
					Gender.MALE,
					address,
					List.of("Computer Science"),
					BigDecimal.TEN,
					LocalDateTime.now()
			);
		};
	}
}
