package com.mbmc.template.util;

import android.os.Parcelable;

import org.parceler.ParcelerRuntimeException;
import org.parceler.Parcels;

import java.lang.reflect.Field;


public final class ParcelsUtil {

    public static Parcelable wrap(Object input) {
        if (input == null) {
            return wrap(null, null);
        }
        return wrap(input.getClass(), input);
    }

    public static <T> Parcelable wrap(Class<? extends T> inputType, T input) {
        try {
            android.os.Parcel parcel = android.os.Parcel.obtain();

            Parcelable parcelable = Parcels.wrap(inputType, input);

            parcelable.writeToParcel(parcel, 0);
            parcel.setDataPosition(0);

            Field creatorField = parcelable.getClass().getField("CREATOR");

            return (Parcelable) ((Parcelable.Creator)creatorField.get(parcelable)).createFromParcel(parcel);
        } catch (IllegalAccessException e) {
            throw new ParcelerRuntimeException("IllegalAccessException", e);
        } catch (NoSuchFieldException e) {
            throw new ParcelerRuntimeException("NoSuchFieldException", e);
        }
    }


    private ParcelsUtil() {

    }

}
