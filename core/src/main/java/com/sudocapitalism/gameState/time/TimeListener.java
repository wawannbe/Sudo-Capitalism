package com.sudocapitalism.gameState.time;

import com.sudocapitalism.gameState.GameState;

public interface TimeListener {

    default void weekHasChanged(GameState gameState) {}
}
