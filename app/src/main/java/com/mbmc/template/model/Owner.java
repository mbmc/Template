package com.mbmc.template.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;


@Parcel
public class Owner {

    public String login;
    @SerializedName("avatar_url") public String avatar;


    @Override
    public String toString() {
        return "login: " + login;
    }

}
