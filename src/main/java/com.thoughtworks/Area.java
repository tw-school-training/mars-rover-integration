package com.thoughtworks;

class Area {
    private int minCoordinateX;
    private int maxCoordinateX;
    private int minCoordinateY;
    private int maxCoordinateY;

    Area(int minCoordinateX, int maxCoordinateX, int minCoordinateY, int maxCoordinateY) {
        this.minCoordinateX = minCoordinateX;
        this.maxCoordinateX = maxCoordinateX;
        this.minCoordinateY = minCoordinateY;
        this.maxCoordinateY = maxCoordinateY;
    }

    int getMinCoordinateX() {
        return minCoordinateX;
    }

    int getMaxCoordinateX() {
        return maxCoordinateX;
    }

    int getMinCoordinateY() {
        return minCoordinateY;
    }

    int getMaxCoordinateY() {
        return maxCoordinateY;
    }
}
