package com.example.superheroes;

import com.example.superheroes.model.Hero;
import com.example.superheroes.practice.Calculator;
import com.example.superheroes.repository.HeroRepository;
import com.example.superheroes.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SuperheroesApplication{

	/*
	@Autowired
	HeroService heroService;
	 */

	public static void main(String[] args) {
		SpringApplication.run(SuperheroesApplication.class, args);
	}

	/*
	@Override
	public void run(String... args) throws Exception {
		List<Hero> res = heroService.getHeroesStartingWithLetter("C");
		System.out.println("Starting with C:");
		for (Hero h : res)
			System.out.println(h);

		res = heroService.getAllHeroes();
		System.out.println("All heroes:");
		for (Hero h : res)
			System.out.println(h);

		res = heroService.getTop3ByNameDesc();
		System.out.println("Last 3 names:");
		for (Hero h : res)
			System.out.println(h);
	}
	 */
}
