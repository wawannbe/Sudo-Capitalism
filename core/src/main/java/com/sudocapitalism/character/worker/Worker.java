package com.sudocapitalism.character.worker;


import com.sudocapitalism.character.Genre;
import com.sudocapitalism.character.Person;

public class Worker extends Person {

    /**
     * Creates a new Worker based on given data
     *
     * @param firstName The first name
     * @param lastName The last name
     * @param age The age
     * @param genre The Genre based on the Genre enum
     */
    public Worker(String firstName, String lastName, int age, Genre genre) {
        super(firstName, lastName, age, genre);
    }
}
