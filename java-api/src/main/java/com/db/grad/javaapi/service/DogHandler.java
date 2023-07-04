package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;

public class DogHandler
{
    private DogsRepository itsDogsRepo;

    public DogHandler(DogsRepository repo)
    {
        itsDogsRepo = repo;
    }

    public void addDog(Dog theDog)
    {
        itsDogsRepo.save( theDog );
    }

    public long getNoOfDogs()
    {
        return itsDogsRepo.count();
    }
}
