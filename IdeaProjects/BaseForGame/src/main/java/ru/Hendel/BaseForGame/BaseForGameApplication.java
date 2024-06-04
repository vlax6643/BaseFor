package ru.Hendel.BaseForGame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BaseForGameApplication {

	public static void main(String[] args) {
		System.out.println("Hello world");
		System.out.println("Datasource URL: " + System.getenv("DATABASE_URL"));
		System.out.println("Datasource Username: " + System.getenv("DATABASE_USERNAME"));
		System.out.println("Datasource Password: " + System.getenv("DATABASE_PASSWORD"));
		SpringApplication.run(BaseForGameApplication.class, args);

	}

}
