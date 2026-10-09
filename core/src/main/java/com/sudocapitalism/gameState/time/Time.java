package com.sudocapitalism.gameState.time;

import com.sudocapitalism.gameState.GameState;
import java.util.ArrayList;
import java.util.List;


public class Time {

    private int week;

    private final GameState gameState;

    private final List<TimeListener> timeListeners;

    public Time(GameState gameState) {

        this.timeListeners = new ArrayList<>();

        this.gameState = gameState;

        this.week = 1;
    }

    public int getWeek() {
        return this.week;
    }

    public void nextWeek() {
        this.week ++;
        notifyWeekHasChanged();
    }

    public boolean addTimeListener(TimeListener timeListener) {
        return this.timeListeners.add(timeListener);
    }

    public boolean removeTimeListener(TimeListener timeListener) {
        return this.timeListeners.remove(timeListener);
    }

    public void notifyWeekHasChanged() {

        for (TimeListener timeListener : this.timeListeners) {
            timeListener.weekHasChanged(this.gameState);
        }
    }
}
