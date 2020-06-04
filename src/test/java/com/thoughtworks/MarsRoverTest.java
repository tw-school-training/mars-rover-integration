package com.thoughtworks;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

    @Test
    public void should_coordinate_y_plus_1_given_command_M_and_orientation_N() {
        checkCoordinateAndOrientation(Collections.singletonList(Command.M), Orientation.N, Orientation.N, new Coordinate(1, 3));
    }

    @Test
    public void should_coordinate_y_minus_1_given_command_M_and_orientation_S() {
        checkCoordinateAndOrientation(Collections.singletonList(Command.M), Orientation.S, Orientation.S, new Coordinate(1, 1));
    }

    @Test
    public void should_coordinate_x_plus_1_given_command_M_and_orientation_E() {
        checkCoordinateAndOrientation(Collections.singletonList(Command.M), Orientation.E, Orientation.E, new Coordinate(2, 2));
    }

    @Test
    public void should_coordinate_x_minus_1_given_command_M_and_orientation_W() {
        checkCoordinateAndOrientation(Collections.singletonList(Command.M), Orientation.W, Orientation.W, new Coordinate(0, 2));
    }

    @Test
    public void should_facing_W_given_command_L_and_orientation_N() {
        checkCoordinateAndOrientation(Collections.singletonList(Command.L), Orientation.N, Orientation.W, new Coordinate(1, 2));
    }

    @Test
    public void should_facing_E_given_command_L_and_orientation_S() {
        checkCoordinateAndOrientation(Collections.singletonList(Command.L), Orientation.S, Orientation.E, new Coordinate(1, 2));
    }

    @Test
    public void should_facing_N_given_command_L_and_orientation_E() {
        checkCoordinateAndOrientation(Collections.singletonList(Command.L), Orientation.E, Orientation.N, new Coordinate(1, 2));
    }

    @Test
    public void should_facing_S_given_command_L_and_orientation_W() {
        checkCoordinateAndOrientation(Collections.singletonList(Command.L), Orientation.W, Orientation.S, new Coordinate(1, 2));
    }

    @Test
    public void should_facing_E_given_command_R_and_orientation_N() {
        checkCoordinateAndOrientation(Collections.singletonList(Command.R), Orientation.N, Orientation.E, new Coordinate(1, 2));
    }

    @Test
    public void should_facing_W_given_command_R_and_orientation_S() {
        checkCoordinateAndOrientation(Collections.singletonList(Command.R), Orientation.S, Orientation.W, new Coordinate(1, 2));
    }

    @Test
    public void should_facing_S_given_command_R_and_orientation_E() {
        checkCoordinateAndOrientation(Collections.singletonList(Command.R), Orientation.E, Orientation.S, new Coordinate(1, 2));
    }

    @Test
    public void should_facing_N_given_command_R_and_orientation_W() {
        checkCoordinateAndOrientation(Collections.singletonList(Command.R), Orientation.W, Orientation.N, new Coordinate(1, 2));
    }

    @Test
    public void should_facing_S_given_command_R_R_and_orientation_N() {
        checkCoordinateAndOrientation(Arrays.asList(Command.R, Command.R), Orientation.N, Orientation.S, new Coordinate(1, 2));
    }

    @Test
    public void should_facing_W_given_command_R_R_M_L_and_orientation_N() {
        checkCoordinateAndOrientation(Arrays.asList(Command.R, Command.R, Command.M, Command.L),
                Orientation.N, Orientation.E, new Coordinate(1, 1));

    }

    private void checkCoordinateAndOrientation(List<Command> commands, Orientation previousOrientation,
                                               Orientation orientation, Coordinate coordinate) {
        //given
        MarsRover marsRover = new MarsRover(new Coordinate(1, 2), previousOrientation);

        //when
        marsRover.execute(commands);

        //then
        assertThat(marsRover.getCoordinateX(), is(coordinate.getX()));
        assertThat(marsRover.getCoordinateY(), is(coordinate.getY()));
        assertThat(marsRover.getOrientation(), is(orientation));
    }
}
