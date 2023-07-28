package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;
import com.db.grad.javaapi.repository.DogsRepositoryStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DogsHandlerTest {

    private DogsRepository itsDogRepo = new DogsRepositoryStub();

    @BeforeEach
    public void makeSureRepoIsEmpty() {
        itsDogRepo.deleteAll();
    }
  
    @Test
    public void add_a_dog_return_number_of_dogs_in_repo_is_one() {
        // arrange
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog( theDog );

        int expectedResult = 1;

        // act
        long actualResult = cut.getNoOfDogs();

        // assert
        assertEquals( expectedResult, actualResult );
    }

    @Test
    public void add_a_dog_get_that_dog_by_name_from_repo() {    
        // arrange
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog( theDog );

        Dog expectedResult = theDog;

        // act
        Dog actualResult = cut.getDogByName("Bruno");

        // assert
        assertEquals( expectedResult, actualResult );
    }

    @Test
    public void add_dogs_get_other_dog_by_name_from_repo() {
        // arrange
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog theDog0 = new Dog();
        theDog0.setName("Bruno");
        cut.addDog( theDog0 );
        Dog theDog1 = new Dog();
        theDog1.setName("Isabel");
        cut.addDog( theDog1 );

        Dog expectedResult = null;

        // act
        Dog actualResult = cut.getDogByName("Spike");

        // assert
        assertEquals( expectedResult, actualResult );
    }

    @Test
    public void add_same_dogs_get_that_dog_by_name_from_repo() {
        // arrange
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog theDog0 = new Dog();
        theDog0.setName("Antonio");
        cut.addDog( theDog0 );
        Dog theDog1 = new Dog();
        theDog1.setName("Antonio");
        cut.addDog( theDog1 );

        Dog expectedResult = null;

        // act
        Dog actualResult = cut.getDogByName("Antonio");

        // assert
        assertEquals( expectedResult, actualResult );
    }

  
  public void updateogDetailsWhenDogIsInTheList() {
        // arrange
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        theDog.setId(1);
        Dog theDog2 = new Dog();
        theDog2.setName("Scooby");
        theDog2.setId(1);
        cut.addDog(theDog);

        long expected = 1;

        // act
        long actualResult = cut.updateDogDetails(theDog2);

        // assert
        assertEquals(expected, actualResult);
    }

    @Test
    public void updateogDetailsWhenDogIsNotInTheList() {
        // arrange
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        theDog.setId(1);
        Dog theDog2 = new Dog();
        theDog2.setName("Scooby");
        theDog2.setId(2);
        cut.addDog(theDog);

        long expected = 2;

        // act
        long actualResult = cut.updateDogDetails(theDog2);

        // assert
        assertEquals(expected, actualResult);
    }
}
