package com.thoughtworks;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class OrientationTest {
    @Test
    public void should_return_left_orientation_of_given_orientation() {
        //given
        Map<Orientation, Orientation> orientationMap = new HashMap<>();
        orientationMap.put(Orientation.N, Orientation.W);
        orientationMap.put(Orientation.W, Orientation.S);
        orientationMap.put(Orientation.S, Orientation.E);
        orientationMap.put(Orientation.E, Orientation.N);

        //when
        orientationMap.forEach(this::verify_left_orientation);
    }

    @Test
    public void should_return_right_orientation_of_given_orientation() {
        //given
        Map<Orientation, Orientation> orientationMap = new HashMap<>();
        orientationMap.put(Orientation.N, Orientation.E);
        orientationMap.put(Orientation.E, Orientation.S);
        orientationMap.put(Orientation.S, Orientation.W);
        orientationMap.put(Orientation.W, Orientation.N);

        //when
        orientationMap.forEach(this::verify_right_orientation);
    }

    private void verify_left_orientation(Orientation orientation, Orientation expectedOrientation) {
        //when
        Orientation actualOrientation = orientation.calculateLeftOrientation();

        //then
        assertThat(actualOrientation, is(expectedOrientation));
    }

    private void verify_right_orientation(Orientation orientation, Orientation expectedOrientation) {
        //when
        Orientation actualOrientation = orientation.calculateRightOrientation();

        //then
        assertThat(actualOrientation, is(expectedOrientation));
    }
}