package com.thoughtworks;

class Mission {
    private MarsRover marsRover;
    private String actions;
    private MissionReceiver missionReceiver;

    Mission(String actions) {
        this.actions = actions;
        missionReceiver = new MissionReceiver();
    }

    void perform() {
        missionReceiver.resolve(actions);

        marsRover = new MarsRover(missionReceiver.getCoordinateAndOrientation());

        marsRover.execute(missionReceiver.getCommands());
    }

    String report() {
        return marsRover.getStatus();
    }
}
