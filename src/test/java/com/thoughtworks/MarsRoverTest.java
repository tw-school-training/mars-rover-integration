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

    @Test
    public void should_coordinate_y_plus_1_given_command_M_and_orientation_N() {
        //given
        MarsRover marsRover = new MarsRover(new Coordinate(1, 2), Orientation.N);

        //when
        marsRover.execute(Command.M);
        //then
        assertThat(marsRover.getCoordinateX(), is(1));
        assertThat(marsRover.getCoordinateY(), is(3));
        assertThat(marsRover.getOrientation(), is(Orientation.N));
    }

    @Test
    public void should_coordinate_y_minus_1_given_command_M_and_orientation_S() {
        //given
        MarsRover marsRover = new MarsRover(new Coordinate(1, 2), Orientation.S);

        //when
        marsRover.execute(Command.M);
        //then
        assertThat(marsRover.getCoordinateX(), is(1));
        assertThat(marsRover.getCoordinateY(), is(1));
        assertThat(marsRover.getOrientation(), is(Orientation.S));
    }

    @Test
    public void should_coordinate_x_plus_1_given_command_M_and_orientation_E() {
        //given
        MarsRover marsRover = new MarsRover(new Coordinate(1, 2), Orientation.E);

        //when
        marsRover.execute(Command.M);
        //then
        assertThat(marsRover.getCoordinateX(), is(2));
        assertThat(marsRover.getCoordinateY(), is(2));
        assertThat(marsRover.getOrientation(), is(Orientation.E));
    }

    @Test
    public void should_coordinate_x_minus_1_given_command_M_and_orientation_W() {
        //given
        MarsRover marsRover = new MarsRover(new Coordinate(1, 2), Orientation.W);

        //when
        marsRover.execute(Command.M);
        //then
        assertThat(marsRover.getCoordinateX(), is(0));
        assertThat(marsRover.getCoordinateY(), is(2));
        assertThat(marsRover.getOrientation(), is(Orientation.W));
    }

    @Test
    public void should_facing_W_given_command_L_and_orientation_N() {
        //given
        MarsRover marsRover = new MarsRover(new Coordinate(1, 2), Orientation.N);

        //when
        marsRover.execute(Command.L);
        //then
        assertThat(marsRover.getCoordinateX(), is(1));
        assertThat(marsRover.getCoordinateY(), is(2));
        assertThat(marsRover.getOrientation(), is(Orientation.W));
    }

    @Test
    public void should_facing_E_given_command_L_and_orientation_S() {
        //given
        MarsRover marsRover = new MarsRover(new Coordinate(1, 2), Orientation.S);

        //when
        marsRover.execute(Command.L);
        //then
        assertThat(marsRover.getCoordinateX(), is(1));
        assertThat(marsRover.getCoordinateY(), is(2));
        assertThat(marsRover.getOrientation(), is(Orientation.E));
    }

    @Test
    public void should_facing_N_given_command_L_and_orientation_E() {
        //given
        MarsRover marsRover = new MarsRover(new Coordinate(1, 2), Orientation.E);

        //when
        marsRover.execute(Command.L);
        //then
        assertThat(marsRover.getCoordinateX(), is(1));
        assertThat(marsRover.getCoordinateY(), is(2));
        assertThat(marsRover.getOrientation(), is(Orientation.N));
    }

    @Test
    public void should_facing_S_given_command_L_and_orientation_W() {
        //given
        MarsRover marsRover = new MarsRover(new Coordinate(1, 2), Orientation.W);

        //when
        marsRover.execute(Command.L);
        //then
        assertThat(marsRover.getCoordinateX(), is(1));
        assertThat(marsRover.getCoordinateY(), is(2));
        assertThat(marsRover.getOrientation(), is(Orientation.S));
    }

    @Test
    public void should_facing_E_given_command_R_and_orientation_N() {
        //given
        MarsRover marsRover = new MarsRover(new Coordinate(1, 2), Orientation.N);

        //when
        marsRover.execute(Command.R);
        //then
        assertThat(marsRover.getCoordinateX(), is(1));
        assertThat(marsRover.getCoordinateY(), is(2));
        assertThat(marsRover.getOrientation(), is(Orientation.E));
    }

    @Test
    public void should_facing_W_given_command_R_and_orientation_S() {
        //given
        MarsRover marsRover = new MarsRover(new Coordinate(1, 2), Orientation.S);

        //when
        marsRover.execute(Command.R);
        //then
        assertThat(marsRover.getCoordinateX(), is(1));
        assertThat(marsRover.getCoordinateY(), is(2));
        assertThat(marsRover.getOrientation(), is(Orientation.W));
    }

    @Test
    public void should_facing_S_given_command_R_and_orientation_E() {
        //given
        MarsRover marsRover = new MarsRover(new Coordinate(1, 2), Orientation.E);

        //when
        marsRover.execute(Command.R);
        //then
        assertThat(marsRover.getCoordinateX(), is(1));
        assertThat(marsRover.getCoordinateY(), is(2));
        assertThat(marsRover.getOrientation(), is(Orientation.S));
    }
}
