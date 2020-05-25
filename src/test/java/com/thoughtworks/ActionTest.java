package com.thoughtworks;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ActionTest {
    @Test
    public void should_return_new_orientation_and_position_given_multiple_commands_and_initial_position_and_orientation() {
        //given
        Action action = new Action("1 2 N\n" + "RRLLMLRM");

        //when
        action.send();

        //then
        assertThat(action.report(), is("1 4 N"));
    }
}
