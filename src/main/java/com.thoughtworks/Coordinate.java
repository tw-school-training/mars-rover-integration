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

    void increaseXBy(int step, Area area) {
        int nextX = x + step;
        if (area != null && isCoordinateXInside(nextX, area)) {
            x += step;
        }
    }

    void decreaseXBy(int step, Area area) {
        int nextX = x - step;
        if (area != null && isCoordinateXInside(nextX, area)) {
            x -= step;
        }
    }

    private boolean isCoordinateYInside(int nextY, Area area) {
        return nextY <= area.getMaxCoordinateY() && nextY >= area.getMinCoordinateY();
    }

    private boolean isCoordinateXInside(int nextX, Area area) {
        return nextX <= area.getMaxCoordinateX() && nextX >= area.getMinCoordinateX();
    }

    boolean isIncreasedYInside(int step, Area area) {
        return isCoordinateYInside(y + step, area);
    }

    boolean isDecreasedYInside(int step, Area area) {
        return isCoordinateYInside(y - step, area);
    }

    boolean isIncreasedXInside(int step, Area area) {
        return isCoordinateXInside(x + step, area);
    }

    boolean isDecreasedXInside(int step, Area area) {
        return isCoordinateXInside(x - step, area);
    }
}
