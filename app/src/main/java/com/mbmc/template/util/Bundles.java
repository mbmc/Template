package com.mbmc.template.util;

import android.os.Bundle;

import org.parceler.Parcels;


public final class Bundles {

    private static final String PARCELABLE = "parcelable_key";


    // Parcelable
    public static Bundle parcelableBundle(Object object) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(PARCELABLE, Parcels.wrap(object));
        return bundle;
    }

    public static <T> T getParcelable(Bundle bundle) {
        return Parcels.unwrap(bundle.getParcelable(PARCELABLE));
    }


    private Bundles() {

    }

}
