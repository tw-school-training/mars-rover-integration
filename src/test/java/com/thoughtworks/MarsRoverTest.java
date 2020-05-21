package com.thoughtworks;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MarsRoverTest {
    @Test
    public void should_init_rover_position_and_orientation_given_coordinates_and_orientation() {
        //given
        MarsRover marsRover = new MarsRover(new Coordinate(1, 2), Orientation.N);

        //when
        //then
        assertThat(marsRover.getCoordinateX(), is(1));
        assertThat(marsRover.getCoordinateY(), is(2));
        assertThat(marsRover.getOrientation(), is(Orientation.N));
    }
}
