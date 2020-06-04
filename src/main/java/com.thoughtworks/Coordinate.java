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

    private void increaseY() {
        y += Coordinate.STEP;
    }

    private void decreaseY() {
        y -= Coordinate.STEP;
    }

    private void increaseX() {
        x += Coordinate.STEP;
    }

    private void decreaseX() {
        x -= Coordinate.STEP;
    }

    void update(Orientation orientation) {
        switch (orientation) {
            case N:
                increaseY();
                break;
            case S:
                decreaseY();
                break;
            case E:
                increaseX();
                break;
            case W:
                decreaseX();
                break;
        }
    }

    boolean isAtTheBoundary(Area area) {
        return x == area.getMaxCoordinateX()
                || x == area.getMinCoordinateX()
                || y == area.getMaxCoordinateY()
                || y == area.getMinCoordinateY();
    }
}
