package com.sudocapitalism.gameState.Economy;

import com.sudocapitalism.company.Company;

public class Economy {

    private final Company playerCompany;

    public Economy(Company playerCompany) {
        this.playerCompany = playerCompany;
    }

    public Company getPlayerCompany() {
        return playerCompany;
    }
}
