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
        // arange
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
    public void find_dog_by_valid_id_returns_one_dog()
    {
        DogHandler cut = new DogHandler(itsDogRepo);

        Dog theDog = new Dog();
        theDog.setName("Bruno");
        theDog.setId(1);
        cut.addDog(theDog);

        theDog = new Dog();
        theDog.setName("Frank");
        theDog.setId(2);
        Dog addedDog = cut.addDog(theDog);

        Dog expectedDog = theDog;

        theDog = new Dog();
        theDog.setName("Penny");
        theDog.setId(3);
        cut.addDog(theDog);

        Dog actualResult = cut.getDogById(addedDog.getId());

        assertEquals(expectedDog.getId(), actualResult.getId());
        assertEquals(expectedDog.getName(), actualResult.getName());
    }

    public void find_dog_by_invalid_id_returns_null_dog()
    {
        DogHandler cut = new DogHandler(itsDogRepo);

        Dog theDog = new Dog();
        theDog.setName("Bruno");
        theDog.setId(1);
        cut.addDog( theDog );

        theDog = new Dog();
        theDog.setName("Frank");
        theDog.setId(2);
        cut.addDog( theDog );

        theDog = new Dog();
        theDog.setName("Penny");
        theDog.setId(3);
        cut.addDog( theDog );

        long invalidId = 4;

        assertThrows(NoSuchElementException.class, () -> {
            cut.getDogById(invalidId);
        });
    }
}
