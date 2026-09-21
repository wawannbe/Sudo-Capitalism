package com.sudocapitalism.character.worker;

import com.sudocapitalism.character.Genre;
import com.sudocapitalism.character.Person;

import java.util.Random;


/**
 * Represents a worker hired in a Company.
 *
 * @author Elmouu
 */
public class Worker extends Person {


    // ---< Attributes >---

    /** Rate representing the global efficiency of the worker */
    private double efficiency;


    // ---< Constructors >---

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

        Random random = new Random();
        this.efficiency = random.nextDouble(101);   // Efficiency ranging between 0% ~ 100%
    }

    /**
     * Creates a new Worker based on an existing Person object.
     * This constructor is useful for cloning or converting a generic Person into a specialized Worker.
     * It extracts the necessary fields from the provided Person and passes them to the superclass constructor.
     *
     * @param person The instance whose details will be used to create this worker.
     */
    public Worker(Person person) {
        this(person.getFirstName(), person.getLastName(), person.getAge(), person.getGenre());
    }


    // ---< Efficiency >---

    /**
     * Retrieves the current efficiency of the worker.
     * This value represents how productive the worker is.
     * @return The current efficiency as a double.
     */
    public double getEfficiency() {
        return efficiency;
    }

    /**
     * Increases the worker's efficiency by a given rate.
     * If the rate is zero, no change occurs. Otherwise, the current efficiency
     * is multiplied by the absolute value of the rate to ensure it only grows.1
     * This method simulates happiness, or gain of motivation.
     *
     * @param rate The factor by which to multiply the current efficiency (e.g., 1.1 for a 10% increase).
     */
    public void increaseEfficiency(double rate) {

        if (rate != 0) {
            this.efficiency *= Math.abs(rate);
        }
    }

    /**
     * Decreases the worker's efficiency by a given rate.
     * If the rate is zero, no change occurs. Otherwise, the current efficiency
     * is divided by the absolute value of the rate to ensure it only shrinks.
     * This method simulates burnout, illness, or lack of motivation.
     *
     * @param rate The factor by which to divide the current efficiency (e.g., 0.9 for a 10% decrease).
     */
    public void decreaseEfficiency(double rate) {

        if (rate != 0) {
            this.efficiency /= Math.abs(rate);
        }
    }


    // ---< toString >---

    @Override
    public String toString() {
        return String.format("[Worker] -> %s %S - Efficiency: %.2f", this.firstName, this.lastName, this.efficiency);
    }
}
