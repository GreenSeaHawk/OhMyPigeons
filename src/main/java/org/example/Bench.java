package org.example;

public class Bench {
    private int numPigeons = 3;
    private final int player;

    public Bench(int player) {
        this.player = player;
    }

    public int getNumPigeons() {
        return numPigeons;
    }

    public int getPlayer() {
        return player;
    }

    public void addPigeons(int num) {
        numPigeons += num;
    }

    public void subtractPigeons(int num) {
        numPigeons -= num;
    }
}
