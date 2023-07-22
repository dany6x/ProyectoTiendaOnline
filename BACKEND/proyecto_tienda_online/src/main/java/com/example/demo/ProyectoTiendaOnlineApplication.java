package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication  //(exclude = {DataSourceAutoConfiguration.class })
public class ProyectoTiendaOnlineApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoTiendaOnlineApplication.class, args);
	}
	
	//SOLUCIONAR PROBLEMA DE CONEXION DE CORS
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:4200").allowedMethods("*").allowedHeaders("*");
			}
		};
	}

}
