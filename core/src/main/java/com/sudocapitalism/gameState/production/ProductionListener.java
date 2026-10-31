package com.sudocapitalism.gameState.production;

/**
 * Used to trigger updates when events related with the production occurs in the game.
 *
 * @author Elmouu
 */
public interface ProductionListener {

    default void productionLevelUpgraded() {}

    default void productionCapacityUpgraded() {}
}
