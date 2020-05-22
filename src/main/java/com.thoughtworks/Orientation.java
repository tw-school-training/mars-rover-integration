package com.thoughtworks;

public enum Orientation {
    S, E, W, N;

    public Orientation turnLeft() {
        if (this.equals(N)) {
            return W;
        }
        return E;
    }
}
