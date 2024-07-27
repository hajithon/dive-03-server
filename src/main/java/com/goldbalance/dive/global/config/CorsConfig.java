package com.goldbalance.dive.global.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
	private static final String LOCAL_REACT_CLIENT_URL = "http://localhost:5173";

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
			.allowedOrigins(LOCAL_REACT_CLIENT_URL)
			.allowedMethods("*");
	}
}
