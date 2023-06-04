package com.db.grad.javaapi.service;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Dogs;
import com.db.grad.javaapi.repository.DogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogsService
{
    @Autowired
    private DogsRepository dogsRepository;

    public List<Dogs> getAllDogs()
    {
        return dogsRepository.findAll();
    }

    public Dogs findDogById(long id ) throws ResourceNotFoundException
    {
        Dogs dogs = dogsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dog not found for this id :: " + id));
        return dogs;
    }
}