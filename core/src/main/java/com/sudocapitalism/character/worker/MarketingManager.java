package com.sudocapitalism.character.worker;

import com.sudocapitalism.character.Genre;

/**
 * Representation of a marketing manager
 * Child class of Person
 *
 * @author wawannbe
 * @version 1.0.0
 */
public class MarketingManager extends Worker {
    /**
     * Creates a new Worker based on given data
     *
     * @param firstName The first name
     * @param lastName  The last name
     * @param age       The age
     * @param genre     The Genre based on the Genre enum
     */
    public MarketingManager(String firstName, String lastName, int age, Genre genre) {
        super(firstName, lastName, age, genre);
    }
}
