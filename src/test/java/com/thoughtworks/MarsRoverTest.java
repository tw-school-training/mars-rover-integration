package com.thoughtworks;

import org.junit.Test;

import java.util.Collections;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

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
        checkCoordinateAndOrientation(Command.M, Orientation.N, Orientation.N, new Coordinate(1, 3));
    }

    @Test
    public void should_coordinate_y_minus_1_given_command_M_and_orientation_S() {
        checkCoordinateAndOrientation(Command.M, Orientation.S, Orientation.S, new Coordinate(1, 1));
    }

    @Test
    public void should_coordinate_x_plus_1_given_command_M_and_orientation_E() {
        checkCoordinateAndOrientation(Command.M, Orientation.E, Orientation.E, new Coordinate(2, 2));
    }

    @Test
    public void should_coordinate_x_minus_1_given_command_M_and_orientation_W() {
        checkCoordinateAndOrientation(Command.M, Orientation.W, Orientation.W, new Coordinate(0, 2));
    }

    @Test
    public void should_facing_W_given_command_L_and_orientation_N() {
        checkCoordinateAndOrientation(Command.L, Orientation.N, Orientation.W, new Coordinate(1, 2));
    }

    @Test
    public void should_facing_E_given_command_L_and_orientation_S() {
        checkCoordinateAndOrientation(Command.L, Orientation.S, Orientation.E, new Coordinate(1, 2));
    }

    @Test
    public void should_facing_N_given_command_L_and_orientation_E() {
        checkCoordinateAndOrientation(Command.L, Orientation.E, Orientation.N, new Coordinate(1, 2));
    }

    @Test
    public void should_facing_S_given_command_L_and_orientation_W() {
        checkCoordinateAndOrientation(Command.L, Orientation.W, Orientation.S, new Coordinate(1, 2));
    }

    @Test
    public void should_facing_E_given_command_R_and_orientation_N() {
        checkCoordinateAndOrientation(Command.R, Orientation.N, Orientation.E, new Coordinate(1, 2));
    }

    @Test
    public void should_facing_W_given_command_R_and_orientation_S() {
        checkCoordinateAndOrientation(Command.R, Orientation.S, Orientation.W, new Coordinate(1, 2));
    }

    @Test
    public void should_facing_S_given_command_R_and_orientation_E() {
        checkCoordinateAndOrientation(Command.R, Orientation.E, Orientation.S, new Coordinate(1, 2));
    }

    @Test
    public void should_facing_N_given_command_R_and_orientation_W() {
        checkCoordinateAndOrientation(Command.R, Orientation.W, Orientation.N, new Coordinate(1, 2));
    }

    @Test
    public void should_facing_S_given_command_R_R_and_orientation_N() {
        //given
        MarsRover marsRover = new MarsRover(new Coordinate(1, 2), Orientation.N);
        Area area = new Area(-10, 10, -10, 10);

        //when
        marsRover.execute(Command.R, area);
        marsRover.execute(Command.R, null);

        //then
        assertThat(marsRover.getCoordinateX(), is(1));
        assertThat(marsRover.getCoordinateY(), is(2));
        assertThat(marsRover.getOrientation(), is(Orientation.S));
    }

    @Test
    public void should_facing_W_given_command_R_R_M_L_and_orientation_N() {
        //given
        MarsRover marsRover = new MarsRover(new Coordinate(1, 2), Orientation.N);
        Area area = new Area(-10, 10, -10, 10);

        //when
        marsRover.execute(Command.R, area);
        marsRover.execute(Command.R, area);
        marsRover.execute(Command.M, area);
        marsRover.execute(Command.L, area);

        //then
        assertThat(marsRover.getCoordinateX(), is(1));
        assertThat(marsRover.getCoordinateY(), is(1));
        assertThat(marsRover.getOrientation(), is(Orientation.E));
    }

    private void checkCoordinateAndOrientation(Command command, Orientation previousOrientation,
                                               Orientation orientation, Coordinate coordinate) {
        //given
        MarsRover marsRover = new MarsRover(new Coordinate(1, 2), previousOrientation);
        Area area = new Area(-10, 10, -10, 10);
        //when
        marsRover.execute(command, area);

        //then
        assertThat(marsRover.getCoordinateX(), is(coordinate.getX()));
        assertThat(marsRover.getCoordinateY(), is(coordinate.getY()));
        assertThat(marsRover.getOrientation(), is(orientation));
    }

    @Test
    public void should_not_move_at_the_given_coordinate_y_boundary_given_command_M_and_orientation_N() {
        //given
        MarsRover marsRover = new MarsRover(new Coordinate(1, 3), Orientation.N);
        Area area = new Area(-3, 3, -3, 3);

        //when
        marsRover.executeBatch(Collections.singletonList(Command.M), area);

        //then
        assertThat(marsRover.getCoordinateX(), is(1));
        assertThat(marsRover.getCoordinateY(), is(3));
        assertThat(marsRover.getOrientation(), is(Orientation.N));
    }

    @Test
    public void should_not_move_at_the_given_coordinate_y_boundary_given_command_M_and_orientation_S() {
        //given
        MarsRover marsRover = new MarsRover(new Coordinate(1, -3), Orientation.S);
        Area area = new Area(-3, 3, -3, 3);

        //when
        marsRover.executeBatch(Collections.singletonList(Command.M), area);

        //then
        assertThat(marsRover.getCoordinateX(), is(1));
        assertThat(marsRover.getCoordinateY(), is(-3));
        assertThat(marsRover.getOrientation(), is(Orientation.S));
    }

    @Test
    public void should_not_move_at_the_given_coordinate_x_boundary_given_command_M_and_orientation_E() {
        //given
        MarsRover marsRover = new MarsRover(new Coordinate(3, 1), Orientation.E);
        Area area = new Area(-3, 3, -3, 3);

        //when
        marsRover.executeBatch(Collections.singletonList(Command.M), area);

        //then
        assertThat(marsRover.getCoordinateX(), is(3));
        assertThat(marsRover.getCoordinateY(), is(1));
        assertThat(marsRover.getOrientation(), is(Orientation.E));
    }

    @Test
    public void should_not_move_at_the_given_coordinate_x_boundary_given_command_M_and_orientation_W() {
        //given
        MarsRover marsRover = new MarsRover(new Coordinate(-3, 1), Orientation.W);
        Area area = new Area(-3, 3, -3, 3);

        //when
        marsRover.executeBatch(Collections.singletonList(Command.M), area);

        //then
        assertThat(marsRover.getCoordinateX(), is(-3));
        assertThat(marsRover.getCoordinateY(), is(1));
        assertThat(marsRover.getOrientation(), is(Orientation.W));
    }
}
