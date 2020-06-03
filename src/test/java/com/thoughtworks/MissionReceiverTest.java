package com.thoughtworks;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MissionReceiverTest {

    @Test
    public void should_get_coordinate_and_orientation_given_actions() {
        //given
        MissionReceiver missionReceiver = new MissionReceiver();

        //when
        missionReceiver.resolve("1 2 N\n" + "RRLLMLRM");

        //then
        assertThat(getCoordinateX(missionReceiver), is(1));
        assertThat(getCoordinateY(missionReceiver), is(2));
        assertThat(missionReceiver.getCommands().size(), is(8));
        assertTrue(containsCommands(missionReceiver));
    }

    private boolean containsCommands(MissionReceiver missionReceiver) {
        return missionReceiver
                .getCommands()
                .containsAll(Arrays.asList(Command.R,
                        Command.R, Command.L, Command.L, Command.M, Command.R, Command.R, Command.M));
    }

    private int getCoordinateY(MissionReceiver missionReceiver) {
        return missionReceiver.getCoordinateAndOrientation().getCoordinate().getY();
    }

    private int getCoordinateX(MissionReceiver missionReceiver) {
        return missionReceiver.getCoordinateAndOrientation().getCoordinate().getX();
    }

}