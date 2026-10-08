package com.sudocapitalism.gameState.time;

import com.sudocapitalism.gameState.GameState;

public interface TimeListener {

    default public void weekHasChanged(GameState gameState) {}
}
