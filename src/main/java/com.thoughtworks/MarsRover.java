package com.thoughtworks;

import java.util.List;

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
        if (command.equals(Command.M)) {
            switch (orientation) {
                case N:
                    coordinate.increaseYBy(STEP);
                    break;
                case S:
                    coordinate.decreaseYBy(STEP);
                    break;
                case E:
                    coordinate.increaseXBy(STEP);
                    break;
                case W:
                    coordinate.decreaseXBy(STEP);
                    break;
            }
        }

        if (command.equals(Command.L)) {
            this.orientation = orientation.turnLeft();
        }

        if (command.equals(Command.R)) {
            this.orientation = orientation.turnRight();
        }
    }

    void executeBatch(List<Command> commands) {
        commands.forEach(this::execute);
    }

    String getStatus() {
        return String.format("%s %s %s", coordinate.getX(), coordinate.getY(), orientation);
    }
}
