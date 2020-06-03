package com.thoughtworks;

class CoordinateAndOrientation {
    private Coordinate coordinate;
    private Orientation orientation;

    CoordinateAndOrientation(Coordinate coordinate, Orientation orientation) {
        this.coordinate = coordinate;
        this.orientation = orientation;
    }

    Coordinate getCoordinate() {
        return coordinate;
    }

    Orientation getOrientation() {
        return orientation;
    }
}
