package com.thoughtworks;

public enum Orientation {
    S, E, W, N;

    public Orientation turnLeft() {
        return Orientation.W;
    }
}
