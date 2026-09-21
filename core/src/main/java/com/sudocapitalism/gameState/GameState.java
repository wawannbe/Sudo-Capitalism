package com.sudocapitalism.gameState;

import com.sudocapitalism.character.Player;
import com.sudocapitalism.company.Company;
import com.sudocapitalism.gameState.Economy.Economy;
import com.sudocapitalism.gameState.Reputation.Reputation;

import java.util.ArrayList;


/**
 * Represents the overall state of a game session.
 * This class orchestrates the core components: the {@link Player}, their {@link Company}, the {@link Economy}, and {@link Reputation} system.
 * It also manages event listeners to notify other parts of the application when significant changes occur (e.g., money updates).
 */
public class GameState {


    // ---< Attributes >---

    /** Listeners that will be notified of state changes. */
    private final ArrayList<GameStateListener> listeners;

    /** The economic system governing resources, production, and costs. Initialized with the player's company. */
    private final Economy economy;

    /** The reputation system tracking public opinion and brand value. Initialized with the player's company. */
    private final Reputation reputation;

    /** The company owned and operated by the current player. */
    private final Company playerCompany;

    /** The active player character controlling the game session. */
    private final Player player;


    // ---< Constructor >---

    /**
     * Default constructor that initializes a fresh game state.
     * Creates an empty {@link GameStateListener} list, instantiates a default {@link Company}, and then builds the {@link Economy} and {@link Reputation} systems based on that company.
     * Finally, creates a new {@link Player} instance.
     */
    public GameState() {

        this.listeners = new ArrayList<>();

        this.playerCompany = new Company();

        this.economy = new Economy(this.playerCompany);
        this.reputation = new Reputation(this.playerCompany);

        this.player = new Player();
    }


    // ---< Listeners >

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


    // ---< Player >

    /**
     * Retrieves the current player character.
     * @return The active {@link Player} instance.
     */
    public Player getPlayer() {
        return player;
    }


    // ---< Company >

    /**
     * Retrieves the company associated with this game state (owned by the player).
     * @return The {@link Company} instance.
     */
    public Company getPlayerCompany() {
        return playerCompany;
    }

    /**
     * Adds the given amount of money to the player's {@link Company}.
     * @param amount The amount of money to be added.
     */
    public void addMoney(double amount) {
        this.playerCompany.addMoney(amount);
        this.notifyMoneyChanged();
    }

    /**
     * Removes the given amount of money to the player's {@link Company}.
     * @param amount The amount of money to be removed.
     */
    public void spendMoney(double amount) {
        this.playerCompany.spendMoney(amount);
        this.notifyMoneyChanged();
    }

    /**
     * Notifies the listeners that player's money has changed.
     * This enables to refresh the Labels displaying the money of the {@link Company}.
     */
    public void notifyMoneyChanged() {

        for (GameStateListener listener : this.listeners) {
            listener.updateMoney(this);
        }
    }


    // ---< Economy >---

    /**
     * Retrieves the {@link Economy} instance used in this GameState.
     * @return Economy The current economy used.
     */
    public Economy getEconomy() {
        return economy;
    }


    // ---< Reputation >---

    /**
     * Retrieves the {@link Reputation} instance used in this GameState.
     * @return Reputation The current reputation used.
     */
    public Reputation getReputation() {
        return reputation;
    }
}
