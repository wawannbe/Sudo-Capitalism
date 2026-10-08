package com.sudocapitalism.gameState.time;

import com.sudocapitalism.gameState.GameState;
import java.util.ArrayList;


public class Time {

    private int week;

    private final ArrayList<TimeListener> timeListeners;

    public Time() {

        this.timeListeners = new ArrayList<>();

        this.week = 1;
    }

    public int getWeek() {
        return this.week;
    }

    public void nextWeek(GameState gameState) {
        this.week ++;
        notifyTimeListeners(gameState);
    }

    public boolean addTimeListener(TimeListener timeListener) {
        return this.timeListeners.add(timeListener);
    }

    public boolean removeTimeListener(TimeListener timeListener) {
        return this.timeListeners.remove(timeListener);
    }

    public void notifyTimeListeners(GameState gameState) {

        for (TimeListener timeListener : this.timeListeners) {
            timeListener.weekHasChanged(gameState);
        }
    }
}
