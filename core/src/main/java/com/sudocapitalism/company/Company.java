package com.sudocapitalism.company;

import com.sudocapitalism.character.Person;
import com.sudocapitalism.character.worker.Worker;
import java.util.ArrayList;


/**
 * Represents a company capable of managing its finances and personnel.
 * This class encapsulates the name, financial capital, and list of employees for a corporation.
 *
 * @author Elmouu
 */
public class Company {


    // ---< Attributes >---

    /** The amount of money the company owns */
    private double money;

    /** The name of the company */
    private String name;

    /** List of workers employed by this company */
    private final ArrayList<Worker> employees;


    // ---< Constructor >---

    /**
     * Default constructor initializing a company without a specific name with a starting capital.
     * Creates an instance of with the name "NoNameCorp" and 2000 monetary units,
     * along with an empty list of employees.
     * The default name can be overridden by the player
     */
    public Company() {
        this.name = "NoNameCorp";
        this.money = 2000.0;

        this.employees = new ArrayList<>();
    }


    // ---< Name >---

    /**
     * Retrieves the name of the company.
     * @return The current name of the corporation, or "NoNameCorp" if never modified.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets a new name for the company.
     * @param name the new name to assign to this instance.
     */
    public void setName(String name) {
        this.name = name;
    }


    // ---< Money >---

    /**
     * Retrieves the current amount of money owned by the company.
     * @return The current financial balance.
     */
    public double getMoney() {
        return money;
    }

    /**
     * Adds a given amount to the company's capital.
     * This method is useful for simulating revenues, investments, or any other financial input.
     * @param amount the amount to add.
     */
    public void addMoney(double amount) {
        this.money += Math.abs(amount);     // Ensures that a positive amount is always added.
    }

    /**
     * Deducts an amount from the company's capital.
     * This method allows simulating expenses, salaries, or any other financial output.
     * @param amount the amount to deduct.
     */
    public void spendMoney(double amount) {
        this.money -= Math.abs(amount);     // Ensures that a positive amount is always added.
    }


    // ---< Employees >---

    /**
     * Retrieves the list of all workers currently employed by this company.
     * @return An unmodifiable view of the ArrayList containing every active employees.
     */
    public ArrayList<Worker> getEmployees() {
        return employees;
    }

    /**
     * Hires a new worker for this company based on the provided person's details.
     * A new Worker instance is created internally and added to the employee list.
     * @param person the person to hire.
     */
    public void hire(Person person) {
        this.employees.add(new Worker(person));
    }

    /**
     * Removes a specific worker from the company's list.
     * This method searches for an existing Worker matching the provided reference
     * and removes it from the internal list, effectively firing that employee.
     * @param worker the worker to be fired.
     */
    public void fire(Worker worker) {
        this.employees.remove(worker);
    }


    // ---< toString >---

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(this.name);

        stringBuilder.append(String.format("%.2f$\n", this.money));

        for (Worker worker : this.employees) {
            stringBuilder.append(worker.toString()).append('\n');
        }

        return stringBuilder.toString();
    }
}
