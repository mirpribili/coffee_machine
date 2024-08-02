package com.exe.coffeemachine.emulator;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Основной класс приложения для эмуляции кофемашины
 * Запускает Spring Boot приложение и настраивает OpenAPI документацию
 * @author user
 * @year 2024
 */
@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "API документация эмулятора кофемашины",
				description = "REST API документация для эмулятора кофемашины",
				version = "v1",
				contact = @Contact(
						name = "Разработчик Бондарев Олег",
						email = "mirpribili@ya.ru",
						url = "https://github.com/mirpribili/coffee_machine/tree/master"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.apache.org/licenses/LICENSE-2.0"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Дополнительная документация по эмулятору кофемашины",
				url = "https://github.com/mirpribili/coffee_machine/tree/master/#"
		)
)
public class CoffeeMachineApplication {

	/**
	 * Главный метод, запускающий Spring Boot приложение
	 * @param args аргументы командной строки
	 */
	public static void main(String[] args) {
		SpringApplication.run(CoffeeMachineApplication.class, args);
	}
}
