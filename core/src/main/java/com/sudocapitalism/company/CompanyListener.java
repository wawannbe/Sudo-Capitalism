package com.sudocapitalism.company;

import com.sudocapitalism.gameState.GameState;

public interface CompanyListener {

    default void moneyAmountHasChanged(GameState gameState) {}
}
