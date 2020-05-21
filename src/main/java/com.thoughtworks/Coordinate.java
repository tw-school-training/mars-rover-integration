package com.thoughtworks;

class Coordinate {
    private int x;
    private int y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    void increaseYBy(int step) {
        y += step;
    }
}
