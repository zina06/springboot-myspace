package com.kosa.springbootmyspace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SpringbootMyspaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMyspaceApplication.class, args);
	}

}
