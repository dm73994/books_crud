package com.library_test.library_test;

import com.library_test.library_test.configuration.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class LibraryTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryTestApplication.class, args);
	}

}
