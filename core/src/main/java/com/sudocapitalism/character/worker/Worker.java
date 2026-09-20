package com.sudocapitalism.character.worker;

import com.sudocapitalism.character.Genre;
import com.sudocapitalism.character.Person;


/**
 * Represents a worker hired in a Company.
 *
 * @author Elmouu
 */
public class Worker extends Person {

    /**
     * Creates a new Worker based on given data.
     * This constructor initializes the worker with specific details: first name, last name, age, and gender.
     * It calls the superclass (Person) constructor to set up these attributes.
     *
     * @param firstName The first name
     * @param lastName The last name
     * @param age The age
     * @param genre The Genre based on the Genre enum
     */
    public Worker(String firstName, String lastName, int age, Genre genre) {
        super(firstName, lastName, age, genre);
    }

    /**
     * Creates a new Worker based on an existing Person object.
     * This constructor is useful for cloning or converting a generic Person into a specialized Worker.
     * It extracts the necessary fields from the provided Person and passes them to the superclass constructor.
     *
     * @param person The instance whose details will be used to create this worker.
     */
    public Worker(Person person) {
        super(person.getFirstName(), person.getLastName(), person.getAge(), person.getGenre());
    }
}
