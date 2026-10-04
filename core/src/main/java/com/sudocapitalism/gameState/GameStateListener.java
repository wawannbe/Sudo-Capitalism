package com.sudocapitalism.gameState;

/**
 * Listener interface for updates to the game state.
 *
 * @author Elmouu
 */
public interface GameStateListener {

    /**
     * Called whenever the {@link GameState} updates its money value.
     * Use this method to refresh UI elements or perform other reactions to income/expense events.
     *
     * @param gameState The current game state containing the new money amount.
     */
    public void updateMoney(GameState gameState);
}
