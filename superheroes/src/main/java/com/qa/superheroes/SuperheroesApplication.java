package com.qa.superheroes;

import com.qa.superheroes.model.Hero;
import com.qa.superheroes.repository.HeroRepository;
import com.qa.superheroes.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SuperheroesApplication{

	public static void main(String[] args) {
		SpringApplication.run(SuperheroesApplication.class, args);
	}
}
