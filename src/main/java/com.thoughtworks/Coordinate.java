package com.thoughtworks;

class Coordinate {
    private static final int STEP = 1;
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

    void decreaseYBy(int step) {
        y -= step;
    }

    void increaseXBy(int step) {
        x += step;
    }

    void decreaseXBy(int step) {
        x -= step;
    }

    void update(Orientation orientation) {
        switch (orientation) {
            case N:
                increaseYBy(STEP);
                break;
            case S:
                decreaseYBy(STEP);
                break;
            case E:
                increaseXBy(STEP);
                break;
            case W:
                decreaseXBy(STEP);
                break;
        }
    }
}
