package com.sudocapitalism.character;

/**
 * Representation of a human in the game
 *
 * @author wawannbe
 * @version 1.1.0
 */
public class Person {

    /// The first name
    protected String firstName;

    /// The last name
    protected String lastName;

    /// The age
    protected int age;

    /// The genre based on the Genre enum
    protected Genre genre;

    /**
     * Creates a new Person based on given data
     */
    public Person(String firstName, String lastName, int age, Genre genre) {
        this.firstName = firstName;
        this.lastName = lastName;

        if (age >= 18 && age <= 90) {   // restraining the age to a *realistic* value
            this.age = age;
        } else {
            this.age = 25;              // otherwise defaulting to hard written value
        }

        this.genre = genre;
    }

    /// @return The first name of the Person
    public String getFirstName() {
        return firstName;
    }

    /// @return The last name of the person
    public String getLastName() {
        return lastName;
    }

    /// @return The age of the Person
    public int getAge() {
        return age;
    }

    /// @return The genre of the Person
    public Genre getGenre() {
        return genre;
    }
}
