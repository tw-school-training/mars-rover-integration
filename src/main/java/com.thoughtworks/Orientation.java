package com.thoughtworks;

public enum Orientation {
    S, E, N, W;

    public Orientation calculateLeftOrientation() {
        int orientationEnumSize = Orientation.values().length;
        int indexIncrement = 1;
        int nextIndex = (this.ordinal() + indexIncrement) % orientationEnumSize;

        return Orientation.values()[nextIndex];
    }

    public Orientation calculateRightOrientation() {
        int orientationEnumSize = Orientation.values().length;
        int indexIncrement = 3;
        int nextIndex = (this.ordinal() + indexIncrement) % orientationEnumSize;

        return Orientation.values()[nextIndex];
    }
}
