package com.sudocapitalism.gameState.time;

public class Time {

    public int week;

    public Time() {

        this.week = 1;
    }

    public int getWeek() {
        return this.week;
    }

    public void nextWeek() {
        this.week ++;
    }
}
