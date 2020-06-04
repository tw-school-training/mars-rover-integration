package com.thoughtworks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class MissionReceiver {
    private CoordinateAndOrientation coordinateAndOrientation;
    private List<Command> commands;
    private Area area;

    void resolve(String actions) {
        String[] splitActions = actions.split("\n");

        buildCoordinateAndOrientation(splitActions[0]);
        buildArea(splitActions[1]);
        buildCommands(splitActions[2]);
    }

    private void buildArea(String area) {
        String[] splitArea = area.split(" ");
        int minCoordinateX = Integer.parseInt(splitArea[0]);
        int maxCoordinateX = Integer.parseInt(splitArea[1]);
        int minCoordinateY = Integer.parseInt(splitArea[2]);
        int maxCoordinateY = Integer.parseInt(splitArea[3]);

        this.area = new Area(minCoordinateX, maxCoordinateX, minCoordinateY, maxCoordinateY);
    }

    private void buildCoordinateAndOrientation(String coordinateAndOrientation) {
        String[] splitCoordinateAndOrientation = coordinateAndOrientation.split(" ");
        Coordinate coordinate = getCoordinate(splitCoordinateAndOrientation);
        Orientation orientation = getOrientation(splitCoordinateAndOrientation);

        this.coordinateAndOrientation = new CoordinateAndOrientation(coordinate, orientation);
    }

    private static Coordinate getCoordinate(String[] positionAndOrientation) {
        int positionX = Integer.parseInt(positionAndOrientation[0]);
        int positionY = Integer.parseInt(positionAndOrientation[1]);
        return new Coordinate(positionX, positionY);
    }

    private static Orientation getOrientation(String[] positionAndOrientation) {
        return Orientation.valueOf(positionAndOrientation[2]);
    }

    private void buildCommands(String commands) {
        this.commands = Arrays.stream(commands.split(""))
                .map(Command::valueOf)
                .collect(Collectors.toList());
    }

    CoordinateAndOrientation getCoordinateAndOrientation() {
        return coordinateAndOrientation;
    }

    List<Command> getCommands() {
        return new ArrayList<>(commands);
    }

    Area getArea() {
        return area;
    }
}
