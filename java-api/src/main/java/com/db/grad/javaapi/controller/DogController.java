package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.service.DogHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class DogController {
  private DogHandler service;

  @Autowired
  public DogController(DogHandler service) {
    this.service = service;
  }

  @GetMapping("/status")
  public String getWelcome() {
    return "Dogs API is up and running!";
  }

  @GetMapping("/dogs")
  public List<Dog> getDogs() {
    return service.getAllDogs();
  }

  @GetMapping("/dogs/{id}")
  public ResponseEntity<Dog> getEmployeeById(@PathVariable(value = "id") Long id) {
    Dog dogs = service.getDogById(id);
    return ResponseEntity.ok().body(dogs);
  }
}
