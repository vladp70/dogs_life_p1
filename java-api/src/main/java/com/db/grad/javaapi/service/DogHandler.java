package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;

import java.util.List;

public class DogHandler
{
    private DogsRepository itsDogsRepo;

    public DogHandler(DogsRepository repo)
    {
        itsDogsRepo = repo;
    }

    public long addDog(Dog theDog)
    {
        return itsDogsRepo.save( theDog );
    }

    public long getNoOfDogs()
    {
        return itsDogsRepo.count();
    }

    public boolean removeDog(long uniqueId)
    {
        boolean result = false;

        Dog theDog = itsDogsRepo.findById(uniqueId);
        if(theDog != null)
        {
            result = itsDogsRepo.delete(theDog);
        }

        return  result;
    }

    public Dog getDogById(long uniqueId)
    {
        return itsDogsRepo.findById(uniqueId);
    }

    public Dog getDogByName(String dogsName )
    {
        Dog dogToFind = new Dog();
        dogToFind.setName(dogsName);
        List<Dog> dogs = itsDogsRepo.findByName(dogToFind);
        Dog result = null;

        if( dogs.size() == 1)
            result = dogs.get(0);

        return result;
    }

    public long updateDogDetails(Dog dogToUpdate)
    {
        return itsDogsRepo.save( dogToUpdate );
    }
}
