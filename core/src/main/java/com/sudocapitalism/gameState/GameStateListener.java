package com.sudocapitalism.gameState;

/**
 * Listener interface for updates to the game state.
 *
 * @author Elmouu
 */
public interface GameStateListener {

    default public void weekHasChanged(GameState gameState) {}
}
