package com.mbmc.template.test;

import android.os.Bundle;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.SmallTest;

import com.mbmc.template.constant.TestConstants;
import com.mbmc.template.model.Ip;
import com.mbmc.template.util.Bundles;
import com.google.gson.Gson;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;


@RunWith(AndroidJUnit4.class)
@SmallTest
public class BundlesTest {

    @Test
    public void parcelable() {
        Ip out = new Gson().fromJson(TestConstants.IP, Ip.class);

        Bundle bundle = Bundles.parcelableBundle(out);
        Ip in = Bundles.getParcelable(bundle);

        assertEquals(out.ip, in.ip);
        assertEquals(out.about, in.about);
    }

}
