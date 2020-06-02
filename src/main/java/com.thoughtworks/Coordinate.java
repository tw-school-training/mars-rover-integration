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

    void increaseYBy(int step, Area area) {
        int nextY = y + step;
        if (area != null && isCoordinateYInside(nextY, area)) {
            y += step;
        }
    }

    void decreaseYBy(int step, Area area) {
        int nextY = y - step;
        if (area != null && isCoordinateYInside(nextY, area)) {
            y -= step;
        }
    }

    void increaseXBy(int step) {
        x += step;
    }

    void decreaseXBy(int step) {
        x -= step;
    }

    private boolean isCoordinateYInside(int nextY, Area area) {
        return nextY <= area.getMaxCoordinateY() && nextY >= area.getMinCoordinateY();
    }
}
