package com.mbmc.template.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;


public final class Dates {

    //2015-03-27T00:12:41Z
    private static final DateFormat IN = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'",
            Locale.getDefault());
    private static final DateFormat OUT = DateFormat.getDateInstance(DateFormat.MEDIUM,
            Locale.getDefault());


    public static String getCreatedAt(String dateString) {
        try {
            return OUT.format(IN.parse(dateString));
        } catch (ParseException exception) {
            return "";
        }
    }


    private Dates() {
        // Don't construct
    }

}
