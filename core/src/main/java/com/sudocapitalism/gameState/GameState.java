package com.sudocapitalism.gameState;

import com.sudocapitalism.character.Player;
import com.sudocapitalism.company.Company;
import com.sudocapitalism.gameState.Economy.Economy;
import com.sudocapitalism.gameState.Reputation.Reputation;

import java.util.ArrayList;

public class GameState {

    private ArrayList<GameStateListener> listeners;

    private final Economy economy;
    private final Reputation reputation;

    private final Company playerCompany;

    private final Player player;

    public GameState() {

        this.listeners = new ArrayList<>();

        this.playerCompany = new Company();

        this.economy = new Economy(this.playerCompany);
        this.reputation = new Reputation(this.playerCompany);

        this.player = new Player();
    }


    // ---< Listeners >

    public void addListener(GameStateListener listener) {
        this.listeners.add(listener);
    }

    public void removeListener(GameStateListener listener) {
        this.listeners.remove(listener);
    }


    // ---< Player >

    public Player getPlayer() {
        return player;
    }


    // ---< Company >

    public Company getPlayerCompany() {
        return playerCompany;
    }

    public void notifyMoneyChanged() {

        for (GameStateListener listener : this.listeners) {
            listener.updateMoney(this);
        }
    }

    public void addMoney(double amount) {
        this.playerCompany.addMoney(amount);
        this.notifyMoneyChanged();
    }
}
