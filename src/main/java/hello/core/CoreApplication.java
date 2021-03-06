package hello.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoreApplication {

	public static void main(String[] args) {
		System.setProperty("spring.profiles.default", "local");
		SpringApplication.run(CoreApplication.class, args);
	}

}
