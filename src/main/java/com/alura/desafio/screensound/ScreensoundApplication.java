package com.alura.desafio.screensound;

import com.alura.desafio.screensound.principal.Principal;
import com.alura.desafio.screensound.repository.ArtistaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreensoundApplication implements CommandLineRunner {

	@Autowired
	private ArtistaRepositorio repositorio;

	public static void main(String[] args) {
		SpringApplication.run(ScreensoundApplication.class, args);
	}

	public void run(String... args) throws Exception{
		Principal principal = new Principal(repositorio);
		principal.exibeMenu();
	}
}
