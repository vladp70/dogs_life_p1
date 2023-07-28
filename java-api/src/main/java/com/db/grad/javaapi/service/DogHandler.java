package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogHandler {

    private DogsRepository itsDogRepo;

    @Autowired
    public DogHandler(DogsRepository repo) {
        itsDogRepo = repo;

    }

    public Dog addDog(Dog theDog) {
        return itsDogRepo.save(theDog);
    }

    public long getNoOfDogs() {
        return itsDogRepo.count();
    }

    public Dog getDogByName(String name) {
        Dog aDog = new Dog();
        aDog.setName(name);
        List<Dog> found = itsDogRepo.findByName(aDog);
        if (found.size() == 1) {
            return found.get(0);
        } else
            return null;
    }
    
    public Dog updateDogDetails(Dog theDog) {
        return itsDogRepo.save(theDog);
    }
}
