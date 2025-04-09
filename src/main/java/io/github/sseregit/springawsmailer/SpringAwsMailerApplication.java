package io.github.sseregit.springawsmailer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;

@SpringBootApplication
@EnableJdbcAuditing
public class SpringAwsMailerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAwsMailerApplication.class, args);
	}

}
