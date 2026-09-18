package com.sudocapitalism.character;

public class Player extends Person {

    /**
     * Creates a new Person based on given data
     *
     * @param firstName Player's first name
     * @param lastName  Players last name
     * @param genre     Player's genre, based on the Genre enum
     */
    public Player(String firstName, String lastName, Genre genre) {
        super(firstName, lastName, 0, genre);
    }

    public Player() {
        super("", "", 0, Genre.UNSET);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
