package com.thoughtworks;

public enum Orientation {
    S, E, N, W;

    public Orientation turnLeft() {
        int orientationEnumSize = Orientation.values().length;
        int nextIndex = (this.ordinal() + 1) % orientationEnumSize;

        return Orientation.values()[nextIndex];
    }

    public Orientation turnRight() {
        if (this.equals(S)) {
            return W;
        }
        
        return E;
    }
}
