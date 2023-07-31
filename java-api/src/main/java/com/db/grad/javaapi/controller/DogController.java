package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin (origins = "http://localhost:3000")
public class DogController {
    private DogService dogService;
    @Autowired
    public DogController(DogService dogService) {
        this.dogService = dogService;
    }
    @GetMapping("/dogs")
    public List<Dog> getAllDogs() {
        return dogService.getAllDogs();
    }

}
