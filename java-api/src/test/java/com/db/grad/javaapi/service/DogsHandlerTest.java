package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DogsHandlerTest
{
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private DogsRepository itsDogRepo;

    @BeforeEach
    public  void    makeSureRepoIsEmpty()
    {
        itsDogRepo.deleteAll();
    }

    @Test
    public  void    add_a_dog_return_number_of_dogs_in_repo_is_one()
    {
        // arrange
        DogHandler cut = new DogHandler( itsDogRepo );
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
    public  void    add_several_dogs_return_number_of_dogs_match_number_added()
    {
        // arrange
        DogHandler cut = new DogHandler( itsDogRepo );
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog( theDog );
        theDog = new Dog();
        theDog.setName("Frank");
        cut.addDog( theDog );
        theDog = new Dog();
        theDog.setName("Penny");
        cut.addDog( theDog );

        int expectedResult = 3;

        // act
        long actualResult = cut.getNoOfDogs();

        // assert
        assertEquals( expectedResult, actualResult );
    }

    @Ignore
    @Test
    public  void    add_dog_and_remove_dog_return_number_of_dogs_is_zero()
    {
//        // arrange
//        DogHandler cut = new DogHandler( itsDogRepo );
//        Dog theDog = new Dog();
//        theDog.setName("Bruno");
//        long uniqueId = cut.addDog( theDog );
//
//        long expectedResult = 0;
//        boolean expectedStatus = true;
//
//
//        // act
//        boolean actualStatus = cut.removeDog( uniqueId);
//        long actualResult = cut.getNoOfDogs();
//
//        // assert
//        assertEquals( expectedStatus, actualStatus);
//        assertEquals( expectedResult, actualResult );
    }

    // This test covers the other logic path in cut.removeDog()
    @Ignore
    @Test
    public  void    add_dog_and_remove_dog_that_doess_not_exist_return_number_of_dogs_is_one()
    {
//        // arrange
//        DogHandler cut = new DogHandler( itsDogRepo );
//        Dog theDog = new Dog();
//        theDog.setName("Bruno");
//        long uniqueId = cut.addDog( theDog );
//
//        long expectedResult = 1;
//        boolean expectedStatus = false;
//
//
//        // act
//        // There is no dog with ID == 33
//        boolean actualStatus = cut.removeDog( 33 );
//        long actualResult = cut.getNoOfDogs();
//
//        // assert
//        assertEquals( expectedStatus, actualStatus);
//        assertEquals( expectedResult, actualResult );
    }

    @Test
    public  void    find_dog_by_valid_id_returns_one_dog()
    {
        // arrange
        DogHandler cut = new DogHandler( itsDogRepo );
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog( theDog );
        theDog = new Dog();
        theDog.setName("Frank");
        Dog addedDog = cut.addDog( theDog );
        Dog expectedDog = theDog;
        theDog = new Dog();
        theDog.setName("Penny");
        cut.addDog( theDog );

        // act
        Dog actualResult = cut.getDogById(addedDog.getId() );

        // assert
        assertEquals( expectedDog.getId(), actualResult.getId() );
        assertEquals( expectedDog.getName(), actualResult.getName() );
    }

    @Ignore
    @Test
    public  void    find_dog_by_invalid_id_returns_null_dog()
    {
        // arrange
//        DogHandler cut = new DogHandler( itsDogRepo );
//        Dog theDog = new Dog();
//        theDog.setName("Bruno");
//        cut.addDog( theDog );
//        theDog = new Dog();
//        theDog.setName("Frank");
//        long uniqueId = cut.addDog( theDog );
//        Dog expectedDog = theDog;
//        theDog = new Dog();
//        theDog.setName("Penny");
//        cut.addDog( theDog );
//
//        // act
//        Dog actualResult = cut.getDogById( 33 );
//
//        // assert
//        assertNull( actualResult );
    }

    @Test
    public  void    find_dog_by_name_returns_one_dog()
    {
        // arrange
        DogHandler cut = new DogHandler( itsDogRepo );
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog( theDog );
        theDog = new Dog();
        theDog.setName("Frank");
        cut.addDog( theDog );
        Dog expectedDog = theDog;
        String dogToFind = "Frank";
        theDog = new Dog();
        theDog.setName("Penny");
        cut.addDog( theDog );

        // act
        Dog actualResult = cut.getDogByName( dogToFind );

        // assert
        assertEquals( expectedDog.getId(), actualResult.getId() );
        assertEquals( expectedDog.getName(), actualResult.getName() );
    }


    @Test
    public  void    find_dog_by_name_returns_null_because_many_dogs_with_same_name()
    {
        // arrange
        DogHandler cut = new DogHandler( itsDogRepo );
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog( theDog );
        theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog( theDog );
        Dog expectedDog = theDog;
        String dogToFind = "Bruno";
        theDog = new Dog();
        theDog.setName("Penny");
        cut.addDog( theDog );

        // act
        Dog actualResult = cut.getDogByName( dogToFind );

        // assert
        assertNull( actualResult );
    }

    @Test
    public  void    find_dog_by_invalid_name_returns_null_dog()
    {
        // arrange
        DogHandler cut = new DogHandler( itsDogRepo );
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog( theDog );
        theDog = new Dog();
        theDog.setName("Frank");
        cut.addDog( theDog );
        theDog = new Dog();
        theDog.setName("Penny");
        cut.addDog( theDog );

        // act
        Dog actualResult = cut.getDogByName( "Selvyn" );

        // assert
        assertNull( actualResult );
    }

    @Ignore
    @Test
    public  void    update_dog_that_exists_returns_dog_id()
    {
//        // arrange
//        DogHandler cut = new DogHandler( itsDogRepo );
//        Dog theDog = new Dog();
//        theDog.setName("Bruno");
//        cut.addDog( theDog );
//        theDog = new Dog();
//        theDog.setName("Frank");
//        long expectedResult = cut.addDog( theDog );
//        Dog dogToUpdate = theDog;
//        String dogToFind = "Frank";
//        theDog = new Dog();
//        theDog.setName("Penny");
//        cut.addDog( theDog );
//
//        // act
//        dogToUpdate.setName("Charlie");
//        long actualResult = cut.updateDogDetails( dogToUpdate );
//
//        // assert
//        assertEquals( expectedResult, actualResult );
    }
}
