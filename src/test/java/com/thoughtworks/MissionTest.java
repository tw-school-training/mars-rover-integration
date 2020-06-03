package com.thoughtworks;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MissionTest {
    @Test
    public void should_return_new_orientation_and_position_given_multiple_commands_and_initial_position_and_orientation() {
        //given
        Mission mission = new Mission("1 2 N\n" + "RRLLMLRM");

        //when
        mission.perform();

        //then
        assertThat(mission.report(), is("1 4 N"));
    }
}
