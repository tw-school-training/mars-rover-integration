package com.thoughtworks;

import java.util.List;

class MarsRover {
    private Coordinate coordinate;
    private Orientation orientation;

    MarsRover(Coordinate coordinate, Orientation orientation) {
        this.coordinate = coordinate;
        this.orientation = orientation;
    }

    MarsRover(CoordinateAndOrientation coordinateAndOrientation) {
        coordinate = coordinateAndOrientation.getCoordinate();
        orientation = coordinateAndOrientation.getOrientation();
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
            coordinate.update(orientation);
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
