package com.thoughtworks;

public enum Orientation {
    S, E, W, N;

    public Orientation turnLeft() {
        if (this.equals(N)) {
            return W;
        }
        if (this.equals(S)) {
            return E;
        }
        if (this.equals(E)) {
            return N;
        }
        if (this.equals(W)) {
            return S;
        }

        return this;
    }
}
