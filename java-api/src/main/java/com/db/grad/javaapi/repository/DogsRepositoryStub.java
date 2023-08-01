package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Dog;

import java.util.ArrayList;
import java.util.List;

public class DogsRepositoryStub {
    private ArrayList<Dog> itsDogs = new ArrayList<>();

    private long addDog(Dog theDog) {
        long result = 0;
        itsDogs.add(theDog);
        result = itsDogs.size();
        theDog.setId(result);
        return result;
    }

    public Dog findById(long id) {
        Dog result = null;

        for( Dog theDog: itsDogs)
            if(theDog.getId() == id ) {
                result = theDog;
                break;
            }

        return result;
    }

    public List<Dog> findByName(Dog aDog) {
        ArrayList<Dog> result = new ArrayList<>();

        for( Dog theDog: itsDogs)
            if( theDog.getName().equalsIgnoreCase(aDog.getName()) ) {
                result.add(theDog);
            }

        return result;
    }

    public long save(Dog aDog) {
        Dog retrievedDog = null;
        long result = -1;

        for( Dog theDog: itsDogs)
            if( theDog.getId() == aDog.getId()) {
                retrievedDog = theDog;
                retrievedDog.setName( aDog.getName() );
                result = retrievedDog.getId();
                break;
            }
        if( retrievedDog == null )
            result = addDog(aDog);

        return result;
    }


    public boolean delete(Dog aDog) {
        boolean result = false;
        long initialSize = itsDogs.size();

        itsDogs.removeIf(dog -> dog.getId() == aDog.getId());
        result = initialSize != itsDogs.size();

        return result;
    }

    public  long count()
    {
        return this.itsDogs.size();
    }


    public  boolean existsById( long id )
    {
        boolean result = false;

        for( Dog theDog: itsDogs)
            if(theDog.getId() == id ) {
                result = true;
                break;
            }

        return result;
    }


    public  void    deleteAll()
    {
        itsDogs.clear();
    }

}
