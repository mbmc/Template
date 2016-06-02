package com.mbmc.template.test;

import android.os.Parcelable;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.SmallTest;

import com.mbmc.template.constant.TestConstants;
import com.mbmc.template.model.Ip;
import com.mbmc.template.model.Owner;
import com.mbmc.template.model.Repo;
import com.mbmc.template.util.ParcelsUtil;
import com.google.gson.Gson;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.parceler.Parcels;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


@RunWith(AndroidJUnit4.class)
@SmallTest
public class ModelsTest {

    @Test
    public void ip() {
        Ip out = new Gson().fromJson(TestConstants.IP, Ip.class);
        Ip in = wrapUnwrap(out);

        assertEquals(out.ip, in.ip);
        assertEquals(out.about, in.about);
    }

    @Test
    public void owner() {
        Owner out = new Gson().fromJson(TestConstants.OWNER, Owner.class);
        Owner in = wrapUnwrap(out);

        assertEquals(out.avatar, in.avatar);
        assertEquals(out.login, in.login);
    }

    @Test
    public void repo() {
        Repo out = new Gson().fromJson(TestConstants.REPO, Repo.class);
        Repo in = wrapUnwrap(out);

        assertEquals(out.getCreatedAt(), in.getCreatedAt());
        assertEquals(out.description, in.description);
        assertEquals(out.name, in.name);
        assertNotEquals(out.hashCode(), in.hashCode());
    }


    private <T> T wrapUnwrap(Object object) {
        Parcelable parcelable = ParcelsUtil.wrap(object);
        return Parcels.unwrap(parcelable);
    }

}
