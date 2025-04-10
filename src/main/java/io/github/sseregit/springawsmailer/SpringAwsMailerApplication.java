package io.github.sseregit.springawsmailer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;

import io.github.sseregit.springawsmailer.config.SESConfig;

@SpringBootApplication
@EnableJdbcAuditing
@EnableConfigurationProperties(SESConfig.class)
public class SpringAwsMailerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAwsMailerApplication.class, args);
	}

}
