package com.miclaus.socialwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SocialwebappApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SocialwebappApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SocialwebappApplication.class);
	}
}
