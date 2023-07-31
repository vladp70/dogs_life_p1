package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DogService {

    private DogsRepository itsDogRepo;
    @Autowired
    public DogService(DogsRepository repo) {
        itsDogRepo = repo;

    }

    public Dog addDog(Dog theDog) {
        return itsDogRepo.save(theDog);
    }

    public long getNoOfDogs() {
        return itsDogRepo.count();
    }

    public Dog getDogByName(String name) {
        List<Dog> dogs = itsDogRepo.findByName(name);
        if(dogs.size() == 1) {
            return dogs.get(0);
        }
        return null;
    }

    public Dog updateDogDetails(Dog theDog) {
        if(itsDogRepo.findById(theDog.getId()).isPresent()) {
            itsDogRepo.delete(itsDogRepo.findById(theDog.getId()).get());
            itsDogRepo.save(theDog);
        }
        return itsDogRepo.save(theDog);
    }

    public Dog getDogById(long id) {
        if(itsDogRepo.findById(id).isPresent()) {
            return itsDogRepo.findById(id).get();
        }
        return null;
    }

    public boolean removeDog(long id) {
        if(itsDogRepo.findById(id).isPresent()) {
            itsDogRepo.delete(itsDogRepo.findById(id).get());
            return true;
        }
        return false;
    }

    public List<Dog> getAllDogs() {
        return itsDogRepo.findAll();
    }
}
