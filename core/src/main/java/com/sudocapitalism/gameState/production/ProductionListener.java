package com.sudocapitalism.gameState.production;

import com.sudocapitalism.gameState.GameState;

public interface ProductionListener {

    default void productionLevelUpgraded(GameState gameState) {}

    default void productionCapacityUpgraded(GameState gameState) {}
}
