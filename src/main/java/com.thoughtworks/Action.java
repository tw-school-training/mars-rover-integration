package com.thoughtworks;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Action {
    private MarsRover marsRover;
    private String actions;

    Action(String actions) {
        this.actions = actions;
    }

    void send() {
        String[] splitActions = actions.split("\n");
        String[] positionAndOrientation = splitActions[0].split(" ");
        List<Command> commands = getCommands(splitActions[1]);

        Coordinate coordinate = getCoordinate(positionAndOrientation);
        Orientation orientation = getOrientation(positionAndOrientation);
        marsRover = new MarsRover(coordinate, orientation);

        marsRover.executeBatch(commands);
    }

    String report() {
        return marsRover.getStatus();
    }

    private Coordinate getCoordinate(String[] positionAndOrientation) {
        int positionX = Integer.parseInt(positionAndOrientation[0]);
        int positionY = Integer.parseInt(positionAndOrientation[1]);
        return new Coordinate(positionX, positionY);
    }

    private Orientation getOrientation(String[] positionAndOrientation) {
        return Orientation.valueOf(positionAndOrientation[2]);
    }

    private List<Command> getCommands(String commands) {
        return Arrays.stream(commands.split(""))
                .map(Command::valueOf)
                .collect(Collectors.toList());
    }
}
