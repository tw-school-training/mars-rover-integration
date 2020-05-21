package com.thoughtworks;

class MarsRover {
    private static final int STEP = 1;
    private Coordinate coordinate;
    private Orientation orientation;

    MarsRover(Coordinate coordinate, Orientation orientation) {
        this.coordinate = coordinate;
        this.orientation = orientation;
    }

    int getCoordinateX() {
        return coordinate.getX();
    }

    int getCoordinateY() {
        return coordinate.getY();
    }

    Orientation getOrientation() {
        return orientation;
    }

    void execute(Command command) {
        if (orientation.equals(Orientation.N) && command.equals(Command.M)) {
            coordinate.increaseYBy(STEP);
        }
    }
}
