package com.sudocapitalism.gameState.Reputation;

import com.sudocapitalism.company.Company;

public class Reputation {

    private final Company playerCompany;

    public Reputation(Company playerCompany) {
        this.playerCompany = playerCompany;
    }

    public Company getPlayerCompany() {
        return playerCompany;
    }
}
