package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	private final long MAX_AGE_SECS = 7200;
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
			//Origin이 http://localhost:8080에 대해
			.allowedOriginPatterns("http://localhost:8080")
			//GET, POST, PUT, PATCH, DELETE, OPTIONS 메서드를 허용한다.
			.allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
			.allowedHeaders("*")
			.allowCredentials(true) 
			.maxAge(MAX_AGE_SECS);
	}
}