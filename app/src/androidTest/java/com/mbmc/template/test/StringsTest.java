package com.mbmc.template.test;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.SmallTest;

import com.mbmc.template.util.Strings;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;


@RunWith(AndroidJUnit4.class)
@SmallTest
public class StringsTest {

    @Test
    public void getRepoName() {
        String string = "owner/repo";
        assertEquals("repo", Strings.getRepoName(string));
    }

}
