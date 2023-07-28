package com.example.superheroes.controller;

import com.example.superheroes.model.Hero;
import com.example.superheroes.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HeroController {
    @Autowired
    HeroService heroService;

    @GetMapping("/heroes")
    List<Hero> getHeroes() {
        return heroService.getAllHeroes();
    }

    @GetMapping("/heroes/{letter}")
    List<Hero> getHeroesStartingWithLetter(@PathVariable String letter) {
        return heroService.getHeroesStartingWithLetter(letter);
    }

    @PostMapping("/heroes")
    public HttpStatus saveNewHero(Hero hero){
        Hero result = heroService.saveHero(hero);
        if (result == null)
            return HttpStatus.PRECONDITION_FAILED;
        else
            return HttpStatus.CREATED;
    }
}
