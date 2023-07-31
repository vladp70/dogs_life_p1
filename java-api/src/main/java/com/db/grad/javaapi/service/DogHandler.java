package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;

import java.util.List;
public class DogHandler {

    private DogsRepository itsDogRepo;
    public DogHandler(DogsRepository repo) {
        itsDogRepo = repo;

    }

    public long addDog(Dog theDog) {
        return itsDogRepo.save(theDog);
    }

    public Dog getDogById(long uniqueId)
    {
        return itsDogRepo.findById(uniqueId);
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
    
    public long updateDogDetails(Dog theDog) {
        return itsDogRepo.save(theDog);
    }
}
