package com.mbmc.template.model;

import com.mbmc.template.util.Dates;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;


@Parcel
public class Repo {

    @SerializedName("full_name") public String name;
    @SerializedName("created_at") public String createdAt;
    public String description;
    public Owner owner;


    public String getCreatedAt() {
        return Dates.getCreatedAt(createdAt);
    }

    @Override
    public String toString() {
        return "name: " + name + " owner: " + owner;
    }

}
