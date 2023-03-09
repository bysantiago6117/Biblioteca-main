package com.biblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages={
		"com.biblioteca.controller", "com.biblioteca.modelo","com.biblioteca.servicios","com.biblioteca.Repositorio","com.biblioteca.configuracion"})
public class BibliotecaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
	}

}
