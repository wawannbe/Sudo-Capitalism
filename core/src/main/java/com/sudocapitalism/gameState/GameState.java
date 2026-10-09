package com.sudocapitalism.gameState;

import com.sudocapitalism.character.Genre;
import com.sudocapitalism.character.Person;
import com.sudocapitalism.character.Player;
import com.sudocapitalism.company.Company;
import com.sudocapitalism.gameState.economy.Economy;
import com.sudocapitalism.gameState.reputation.Reputation;
import com.sudocapitalism.gameState.time.Time;
import com.sudocapitalism.gameState.time.TimeListener;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Represents the overall state of a game session.
 * This class orchestrates the core components: the {@link Player}, their {@link Company}, the {@link Economy}, and {@link Reputation} system.
 * It also manages event listeners to notify other parts of the application when significant changes occur (e.g., money updates).
 *
 * @author Elmouu
 */
public class GameState {


    // ---< Attributes >---

    /** Listeners that will be notified of state changes. */
    private final ArrayList<GameStateListener> listeners;

    private final Time time;

    /** The economic system governing resources, production, and costs. Initialized with the player's company. */
    private final Economy economy;

    /** The reputation system tracking public opinion and brand value. Initialized with the player's company. */
    private final Reputation reputation;

    /** The company owned and operated by the current player. */
    private final Company company;

    /** The active player character controlling the game session. */
    private final Player player;

    private final ArrayList<Person> peoplePool;


    // ---< Constructor >---

    /**
     * Default constructor that initializes a fresh game state.
     * Creates an empty {@link GameStateListener} list, instantiates a default {@link Company}, and then builds the {@link Economy} and {@link Reputation} systems based on that company.
     * Finally, creates a new {@link Player} instance.
     */
    public GameState() {

        this.listeners = new ArrayList<>();

        this.time = new Time(this);

        this.company = new Company(this);

        this.economy = new Economy(this.company);
        this.reputation = new Reputation(this.company);

        this.player = new Player();

        this.peoplePool = initPeople();
    }


    // ----------< Listeners >----------

    /**
     * Registers a listener to be notified of state changes.
     * The primary use case is for money updates, but the architecture allows for extensibility.
     * @param listener the {@link GameStateListener} to add.
     */
    public void addListener(GameStateListener listener) {
        this.listeners.add(listener);
    }

    /**
     * Unregisters a previously added listener.
     * @param listener the {@link GameStateListener} to remove.
     */
    public void removeListener(GameStateListener listener) {
        this.listeners.remove(listener);
    }

    // ---< Notify >---



    // ----------< Time >----------

    public boolean addTimeListener(TimeListener timeListener) {
        return this.time.addTimeListener(timeListener);
    }

    public int getWeek() {
        return this.time.getWeek();
    }

    public void nextWeek() {
        this.time.nextWeek();
    }


    // ----------< Player >----------

    /**
     * Retrieves the current player character.
     * @return The active {@link Player} instance.
     */
    public Player getPlayer() {
        return player;
    }


    // ----------< Company >----------

    /**
     * Retrieves the company associated with this game state (owned by the player).
     * @return The {@link Company} instance.
     */
    public Company getCompany() {
        return company;
    }

    /**
     * Adds the given amount of money to the player's {@link Company}.
     * @param amount The amount of money to be added.
     */
    public void addMoney(double amount) {
        this.company.addMoney(amount);
    }

    /**
     * Removes the given amount of money to the player's {@link Company}.
     * @param amount The amount of money to be removed.
     */
    public void spendMoney(double amount) {
        this.company.spendMoney(amount);
    }


    // ----------< Economy >----------

    /**
     * Retrieves the {@link Economy} instance used in this GameState.
     * @return Economy The current economy used.
     */
    public Economy getEconomy() {
        return economy;
    }


    // ----------< Reputation >----------

    /**
     * Retrieves the {@link Reputation} instance used in this GameState.
     * @return Reputation The current reputation used.
     */
    public Reputation getReputation() {
        return reputation;
    }


    // ----------< People >----------

    public ArrayList<Person> initPeople() {

        ArrayList<Person> people = new ArrayList<>();

        try {
            InputStream inputStream  =  getClass().getResourceAsStream("/data/people.csv");
            Scanner scanner = new Scanner(inputStream);
            scanner.useDelimiter(",");

            while (scanner.hasNext()) {
                String line = scanner.nextLine();

                String[] data = line.split(",");

                switch (data[3]) {
                    case "M" -> people.add(new Person(data[0], data[1], Integer.parseInt(data[2]), Genre.MALE));
                    case "F" -> people.add(new Person(data[0], data[1], Integer.parseInt(data[2]), Genre.FEMALE));
                }
            }
            scanner.close();

        } catch (Exception exception) {
            System.out.println("bite");
        }
        return people;
    }

    public ArrayList<Person> getPeoplePool() {
        return peoplePool;
    }


}
