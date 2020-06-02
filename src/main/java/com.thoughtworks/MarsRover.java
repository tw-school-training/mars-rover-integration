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

    void execute(Command command, Area area) {
        if (command.equals(Command.M)) {
            switch (orientation) {
                case N:
                    coordinate.increaseYBy(STEP, area);
                    break;
                case S:
                    coordinate.decreaseYBy(STEP, area);
                    break;
                case E:
                    coordinate.increaseXBy(STEP, area);
                    break;
                case W:
                    coordinate.decreaseXBy(STEP,area);
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

    void executeBatch(List<Command> commands, Area area) {
        for (Command command : commands) {
            if (isNextStepInside(command, area)) {
                execute(command, area);
            } else {
                break;
            }
        }
    }

    private boolean isNextStepInside(Command command, Area area) {
        if (command.equals(Command.M)) {
            switch (orientation) {
                case N:
                    return coordinate.isIncreasedYInside(STEP, area);
                case S:
                    return coordinate.isDecreasedYInside(STEP, area);
                case E:
                    return coordinate.isIncreasedXInside(STEP, area);
                case W:
                    return coordinate.isDecreasedXInside(STEP,area);
            }
        }
        return true;
    }

    String getStatus() {
        return String.format("%s %s %s", coordinate.getX(), coordinate.getY(), orientation);
    }
}
