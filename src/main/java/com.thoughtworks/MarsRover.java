package com.thoughtworks;

import java.util.List;

class MarsRover {
    private Coordinate coordinate;
    private Orientation orientation;
    private Area area;

    MarsRover(Coordinate coordinate, Orientation orientation, Area area) {
        this.coordinate = coordinate;
        this.orientation = orientation;
        this.area = area;
    }

    MarsRover(CoordinateAndOrientation coordinateAndOrientation, Area area) {
        coordinate = coordinateAndOrientation.getCoordinate();
        orientation = coordinateAndOrientation.getOrientation();
        this.area = area;
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

    private void executeEach(Command command) {
        if (!coordinate.isAtTheBoundary(area) && command.equals(Command.M)) {
            coordinate.update(orientation);
        }

        if (command.equals(Command.L)) {
            this.orientation = orientation.calculateLeftOrientation();
        }

        if (command.equals(Command.R)) {
            this.orientation = orientation.calculateRightOrientation();
        }
    }

    void execute(List<Command> commands) {
        if (commands != null) {
            for (Command command : commands) {
                if (coordinate.isAtTheBoundary(area) && command.equals(Command.M)) {
                    break;
                }
                executeEach(command);
            }
        }
    }

    String getStatus() {
        return String.format("%s %s %s", coordinate.getX(), coordinate.getY(), orientation);
    }
}
