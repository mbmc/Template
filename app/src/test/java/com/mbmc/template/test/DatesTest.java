package com.mbmc.template.test;

import com.mbmc.template.util.Dates;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;


public class DatesTest {

    @Test
    public void getCreatedAt() {
        String string = "2015-03-27T00:12:41Z";
        assertEquals("Mar 27, 2015", Dates.getCreatedAt(string));
    }

}
