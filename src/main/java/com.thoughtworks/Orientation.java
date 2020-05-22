package com.thoughtworks;

public enum Orientation {
    S, E, N, W;

    public Orientation turnLeft() {
        int orientationEnumSize = Orientation.values().length;
        int indexIncrement = 1;
        int nextIndex = (this.ordinal() + indexIncrement) % orientationEnumSize;

        return Orientation.values()[nextIndex];
    }

    public Orientation turnRight() {
        int orientationEnumSize = Orientation.values().length;
        int indexIncrement = 3;
        int nextIndex = (this.ordinal() + indexIncrement) % orientationEnumSize;

        return Orientation.values()[nextIndex];
    }
}
