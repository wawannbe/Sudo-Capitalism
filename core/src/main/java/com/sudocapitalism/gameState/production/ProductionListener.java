package com.sudocapitalism.gameState.production;

import com.sudocapitalism.gameState.GameState;

public interface ProductionListener {

    default void productionHasBeenUpgraded(GameState gameState) {}
}
